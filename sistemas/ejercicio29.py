importe = int(input("Ingrese el importe de la compra: "))
vip = input("¿Es cliente VIP? (si/no): ")
if vip.lower() == "si":
    descuento = importe * 0.1
    total = importe - descuento
    print(f"Descuento aplicado: {descuento}")
elif vip.lower() == "no" and importe > 100:
    descuento = importe * 0.05
    total = importe - descuento
    print(f"Descuento aplicado: {descuento}")
else:
    print("No se aplica descuento.")

print(f"Total a pagar: {total}")