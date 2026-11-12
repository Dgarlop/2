package boletin1;

public class HiloEjemplo extends Thread{
	String nombreHilo;
	public HiloEjemplo(String nombreHilo) {
		super();
		this.nombreHilo = nombreHilo;
	}
	
	@Override
	public void run() {
		
		while(true) {
			System.out.println(this.nombreHilo);
		
		
		try {
			Thread.sleep(500);
		}
		catch (InterruptedException e){
			// TODO: handle exception
			e.printStackTrace();
		}
		}
		
		
			
	}
			

}
