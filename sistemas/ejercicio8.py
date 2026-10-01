precio = float(input("Ingrese el precio: "))
precio2 = float(input("Ingrese el precio 2: "))

if precio > precio2:
    print(f"El precio mayor es: {precio}")
else:
    print(f"El precio mayor es: {precio2}")

if precio < precio2:
    print(f"El precio menor es: {precio}")
else:
    print(f"El precio menor es: {precio2}")

if precio == precio2:
    print(f"Los precios son iguales: {precio} = {precio2}")

