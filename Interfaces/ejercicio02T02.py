import sys
from PySide6.QtCore import Slot
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton


class Ventana(QMainWindow):
    def __init__(self):
        super().__init__()

        self.resize(400, 180)

        # Botón conmutable
        self.boton = QPushButton()
        self.boton.setCheckable(True)
        self.setCentralWidget(self.boton)

        # Conexión de señales
        self.boton.clicked.connect(self.registrar_activacion)
        self.boton.toggled.connect(self.actualizar_estado)

        # Estado inicial: desactivado
        self.actualizar_estado(False)

    @Slot(bool)
    def registrar_activacion(self, marcado):
        estado = "ACTIVADA" if marcado else "DESACTIVADA"
        print(f"Clic recibido. Vigilancia {estado}")

    @Slot(bool)
    def actualizar_estado(self, activo):
        if activo:
            self.setWindowTitle("Vigilancia: ACTIVADA")
            self.boton.setText("Desactivar vigilancia")
        else:
            self.setWindowTitle("Vigilancia: DESACTIVADA")
            self.boton.setText("Activar vigilancia")


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = Ventana()
    ventana.show()
    sys.exit(app.exec())