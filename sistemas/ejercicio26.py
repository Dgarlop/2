clientes_tienda_a = {"Ana", "Luis", "Marta", "Carlos"}
clientes_tienda_b = {"Marta", "Carlos", "Lucía"}

print(clientes_tienda_a | clientes_tienda_b)

clientesAmbas = clientes_tienda_a.intersection(clientes_tienda_b)
print(clientesAmbas)

clientesUnicosA = clientes_tienda_a.difference(clientes_tienda_b)
print(clientesUnicosA)