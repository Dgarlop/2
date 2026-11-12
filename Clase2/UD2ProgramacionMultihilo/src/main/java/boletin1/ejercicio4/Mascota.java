package boletin1.ejercicio4;

public class Mascota implements Runnable {
    private String nombre;
    private int vecesComido;

    public Mascota(String nombre) {
        this.nombre = nombre;
        this.vecesComido = 0;
    }

    public int getVecesComido() {
        return vecesComido;
    }

    @Override
    public void run() {
        comer();
    }

    public void comer() {
        vecesComido++;
        System.out.println(nombre + " ha comenzado a comer");
        try {
            Thread.sleep(1000L * vecesComido);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nombre + " ha terminado de comer");
    }
}
