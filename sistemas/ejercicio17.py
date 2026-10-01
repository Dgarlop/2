producto = ("P001", "Teclado", 21)

print(producto[0])
print(producto[1])
print(producto[2])

producto[0] = "P002"

# Ocurre porque las tuplas son inmutables,
# y estas no se pueden modificar una vez creadas.