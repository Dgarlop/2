nombre = input("Ingrese el nombre del producto: ")
precio = float(input("Ingrese el precio del producto: "))
cantidad = int(input("Ingrese la cantidad: "))
suma = precio * cantidad

print(f"Nombre: {nombre}")
print(f"Precio: {precio}")
print(f"Cantidad: {cantidad}")
print(f"Total: {suma} €")