package boletin1.ejercicio4;

public class Mascota implements Runnable{
	private String nombre; 
	private int contadorVecesComido;
	public Mascota(String nombre, int contadorVecesComido) {
		super();
		this.nombre = nombre;
		this.contadorVecesComido = contadorVecesComido;
	}
	
	private void comer() {
		this.contadorVecesComido ++;
		System.out.println("La mascota con nombre : " + this.nombre + " ha comenzado a comer");
		try {
			Thread.sleep(this.contadorVecesComido * 1000);
			System.out.println("La mascota con nombre : " + this.nombre + " ha terminado de comer");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.comer();
		
	}		
}
