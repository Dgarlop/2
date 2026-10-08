contraseña = input("Ingrese la contraseña: ")
password_correcta = "python123"
if contraseña == password_correcta:
    print("Acceso concedido.")
else:
    while contraseña != password_correcta:
        print("Contraseña incorrecta. Intente nuevamente.")
        contraseña = input("Ingrese la contraseña: ")
    print("Acceso concedido.")