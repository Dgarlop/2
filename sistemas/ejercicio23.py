clientes = [
    {
        "nombre": "Ana",
        "email": "ana@email.com",
        "ciudad": "Sevilla"
    },
    {
        "nombre": "Luis",
        "email": "luis@email.com",
        "ciudad": "Córdoba"
    },
    {
        "nombre": "Jose",
        "email": "jose@email.com",
        "ciudad": "Huelva"
    }
]

Email = input("Introduce un email: ")
clienteEncontrado = None

for cliente in clientes:
    if cliente["email"] == Email:
        clienteEncontrado = cliente

if clienteEncontrado:
    print("Cliente encontrado:")
    print(f"Nombre: {clienteEncontrado['nombre']}")
    print(f"Ciudad: {clienteEncontrado['ciudad']}")
else:
    print("No existe ningún cliente con ese email.")