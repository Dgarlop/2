
public class Hilo extends Thread {
	
	public Hilo(String nombre) {
		super(nombre);
	}
	
	@Override
	public void run() {
		System.out.println("Entro en el hilo: " + this.getName());
		
		try {
			Thread.sleep(3000);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Salgo del hilo: " + this.getName());
	}
}

