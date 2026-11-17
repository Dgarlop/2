package boletin1.ejercicio4;

import boletin1.Mascota;

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
        /*for(Thread h: cuidador) {
        	h.join();
        }*/
        System.out.println("Veces que ha comido Lulú: " + lulu.getVecesComido());
        long t_fin = System.currentTimeMillis();
    }

}
