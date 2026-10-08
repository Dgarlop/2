stock = int(input("Ingrese el stock del producto: "));
cantidad = int(input("Ingrese la cantidad a comprar: "));
if cantidad <= stock:
    print("Venta posible")
else:
    print("Stock insuficiente")