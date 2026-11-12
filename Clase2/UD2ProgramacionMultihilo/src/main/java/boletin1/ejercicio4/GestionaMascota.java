package boletin1.ejercicio4;

public class GestionaMascota {
	public static void main(String[] args) {
        Mascota lulu = new Mascota("Lulú");

        
        for (int i = 0; i < 5; i++) {
            Thread cuidador = new Thread(lulu);
            cuidador.start();
        }
        for (int i = 0; i < 100; i++) {
            Thread cuidador = new Thread(lulu);
            cuidador.start();
        }
        System.out.println("Veces que ha comido Lulú: " + lulu.getVecesComido());
    }

}
