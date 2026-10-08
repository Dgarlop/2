precios = [10, 250, 30, 150, 80, 300]
contador = 0
for precio in precios:
    if precio > 100:
        print(f"El precio {precio} es mayor a 100")
        contador += 1
print(f"Cantidad de precios mayores a 100: {contador}")
