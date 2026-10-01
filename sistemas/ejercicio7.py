precio = float(input("Ingrese el precio del producto: "))
descuento = int(input("Ingrese el descuento: "))

descuento_decimal = descuento / 100
precioFinal= precio - (precio * descuento_decimal)

print(f"Precio: {precio} €")
print(f"Descuento: {descuento}%")
print(f"Descuento en euros: {precio * descuento_decimal} €")
print(f"Precio final: {precioFinal} €")