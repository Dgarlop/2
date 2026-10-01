nombre = input("Ingrese su nombre: ").strip()
apellido = input("Ingrese su apellido: ").strip()

usuario = (nombre[0] + apellido).lower()

print(f"Nombre: {nombre}")
print(f"Apellido: {apellido}")
print(f"Usuario: {usuario}")