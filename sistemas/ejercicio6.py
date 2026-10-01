precio = float(input("Ingrese el precio del producto: "))
cantidad = int(input("Ingrese la cantidad: "))

subtotal = precio * cantidad
iva = subtotal * 0.21
total = subtotal + iva

print(f"subtotal: {subtotal} €")
print(f"IVA: {iva} €")
print(f"total: {total} €")