#menu
def menu():
    print("1. Mostrar mensaje")
    print("2. Mostrar fecha ficticia")
    print("3. Salir")

menu()
eleccion = input("Ingrese su elección (1, 2 o 3): ")
if eleccion == "3":
    print("Saliendo del programa...")
else:
    while eleccion != "3":
        menu()
        eleccion = input("Ingrese su elección (1, 2 o 3): ")
print("Saliendo del programa...")