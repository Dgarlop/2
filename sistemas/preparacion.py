"""Dados multijugador por LAN (solo créditos virtuales).

Uso: en un equipo ejecuta ``python preparacion.py --host`` y en los demás
``python preparacion.py --join IP_DEL_HOST``.
"""

import argparse
import json
import random
import socket
import threading
import queue


jugadores = {}
jugadores_lock = threading.Lock()


def enviar(conexion: socket.socket, datos: dict) -> None:
	conexion.sendall((json.dumps(datos) + "\n").encode("utf-8"))


def publicar_saldos() -> None:
	with jugadores_lock:
		estado = [{"nombre": nombre, "creditos": datos["creditos"]}
			for nombre, datos in jugadores.items()]
		conexiones = [datos["conexion"] for datos in jugadores.values()]
	for conexion in conexiones:
		try:
			enviar(conexion, {"tipo": "estado", "jugadores": estado})
		except OSError:
			pass


def jugar_local(conexion: socket.socket) -> None:
	creditos = 100
	archivo = conexion.makefile("r", encoding="utf-8")
	mensajes = queue.Queue()

	def escuchar() -> None:
		try:
			for linea in archivo:
				mensajes.put(json.loads(linea))
		except (ConnectionError, json.JSONDecodeError):
			pass

	threading.Thread(target=escuchar, daemon=True).start()
	print("=== DADOS DE LA SUERTE (LAN) ===")
	print("Juego solo con créditos virtuales; no usa dinero real.")
	while creditos > 0:
		print(f"\nCréditos: {creditos}")
		entrada = input("Apuesta (o 'salir'): ").strip().lower()
		if entrada in {"salir", "s", "q"}:
			enviar(conexion, {"tipo": "salir"})
			break
		try:
			apuesta = int(entrada)
			objetivo = int(input("Elige un número del 1 al 6: "))
		except ValueError:
			print("Datos no válidos.")
			continue
		if apuesta <= 0 or apuesta > creditos or not 1 <= objetivo <= 6:
			print("Apuesta o número no válido.")
			continue
		enviar(conexion, {"tipo": "tirada", "apuesta": apuesta, "objetivo": objetivo})
		respuesta = mensajes.get()
		while respuesta.get("tipo") == "estado":
			print("\nSaldos:", ", ".join(
				f"{jugador['nombre']}: {jugador['creditos']}"
				for jugador in respuesta["jugadores"]))
			respuesta = mensajes.get()
		if respuesta.get("tipo") == "resultado":
			creditos = respuesta["creditos"]
			print(f"\nDado: {respuesta['dado']}")
			print(respuesta["mensaje"])
	print(f"\nFin del juego. Créditos finales: {creditos}")


def atender_jugador(conexion: socket.socket, direccion: tuple) -> None:
	creditos = 100
	archivo = conexion.makefile("r", encoding="utf-8")
	nombre = None
	try:
		for linea in archivo:
			peticion = json.loads(linea)
			if nombre is None:
				if peticion.get("tipo") != "registro":
					continue
				nombre = str(peticion.get("nombre", "Jugador")).strip()[:30] or "Jugador"
				with jugadores_lock:
					jugadores[nombre] = {"conexion": conexion, "creditos": creditos}
				print(f"Jugador conectado: {nombre} ({direccion})")
				publicar_saldos()
				continue
			if peticion.get("tipo") == "salir":
				break
			if peticion.get("tipo") != "tirada":
				continue
			apuesta, objetivo = peticion["apuesta"], peticion["objetivo"]
			# Enviar los nombres de todos los jugadores en cada apuesta.
			publicar_saldos()
			dado = random.randint(1, 6)
			if dado == objetivo:
				ganancia = apuesta * dado / 10
				creditos += ganancia
				mensaje = f"¡Has ganado {ganancia} créditos!"
			else:
				creditos -= apuesta
				mensaje = f"Has perdido {apuesta} créditos."
			with jugadores_lock:
				if nombre in jugadores:
					jugadores[nombre]["creditos"] = creditos
			enviar(conexion, {"tipo": "resultado", "dado": dado,
				"creditos": creditos, "mensaje": mensaje})
			publicar_saldos()
	finally:
		with jugadores_lock:
			if nombre in jugadores and jugadores[nombre]["conexion"] is conexion:
				del jugadores[nombre]
		publicar_saldos()
		conexion.close()


def servidor(puerto: int) -> None:
	with socket.socket() as servidor_socket:
		servidor_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
		servidor_socket.bind(("0.0.0.0", puerto))
		servidor_socket.listen()
		print(f"Servidor listo en el puerto {puerto}. Comparte la IP local.")
		while True:
			conexion, direccion = servidor_socket.accept()
			threading.Thread(target=atender_jugador, args=(conexion, direccion), daemon=True).start()


def cliente(host: str, puerto: int) -> None:
	with socket.create_connection((host, puerto)) as conexion:
		nombre = input("Tu nombre: ").strip() or "Jugador"
		enviar(conexion, {"tipo": "registro", "nombre": nombre})
		jugar_local(conexion)


if __name__ == "__main__":
	parser = argparse.ArgumentParser()
	grupo = parser.add_mutually_exclusive_group(required=True)
	grupo.add_argument("--host", action="store_true", help="inicia el servidor LAN")
	grupo.add_argument("--join", metavar="IP", help="conecta con el servidor")
	parser.add_argument("--port", type=int, default=5000)
	args = parser.parse_args()
	servidor(args.port) if args.host else cliente(args.join, args.port)

