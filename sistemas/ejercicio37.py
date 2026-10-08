ventas = [100, -25, 50, -10, 200]
total = 0
for venta in ventas:
    if venta < 0:
        continue
    else:
        total += venta
print("Total de ventas:", total)
