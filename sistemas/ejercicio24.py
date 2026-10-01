clientes = [
    {
        "nombre": "Ana",
        "email": "ana@email.com",
        "ciudad": "Sevilla"
    },
    {
        "nombre": "Luis",
        "email": "luis@email.com",
        "ciudad": "Cordoba"
    },
    {
        "nombre": "Jose",
        "email": "jose@email.com",
        "ciudad": "Huelva"
    }
]

Ciudad = input("Dime una ciudad: ")
contador = 0
for cliente in clientes:    
    if cliente["ciudad"] == Ciudad:
        contador += 1

print(f"Número de clientes de {Ciudad}: {contador}")