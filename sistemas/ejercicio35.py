numero = 1
ventas = 0
total = 0
while numero != 0:
    numero = int(input("Ingrese un importe (0 para salir): "))
    ventas += 1
    total += numero
print("Cantidad de ventas realizadas:", ventas - 1)
print("Total de ventas:", total)
