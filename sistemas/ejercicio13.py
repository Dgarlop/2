productos = ["Teclado", "Ratón", "Monitor"]
productos.append("Webcam")
productos.append("Altavoces")
productos.remove("Ratón")
for producto in productos:
    if producto == "Monitor":
        productos[productos.index(producto)] = "Monitor 27 pulgadas"

#For para ver la lista completa y actualizada
for producto in productos:
    print(producto)