precio = int(input("Ingrese el precio del producto: "))
if precio < 20:
    print("Producto económico.")
elif precio >= 20 and precio <= 100:
    print("Precio medio")
else:
    print("Producto de precio elevado")