productos = [
    "Teclado",
    "Ratón",
    "Monitor",
    "Webcam",
    "Impresora"
]

nombre = input("Ingrese su nombre: ").strip().lower()
nombre_producto = nombre[0].upper() + nombre[1:]

for producto in productos:
    if producto == nombre_producto:
        encontrado = True
        break
    else:
        encontrado = False
        
if encontrado:
    print(f"El producto '{nombre_producto}' se encuentra en la lista.")
else:
    print(f"El producto '{nombre_producto}' no se encuentra en la lista.")  
