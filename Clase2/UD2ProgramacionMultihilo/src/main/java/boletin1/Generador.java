package boletin1;

import java.util.List;
import java.util.ArrayList;

public class Generador {
	public Generador() {}
	
	public static void main(String[] args) {
		List<Thread.State> estadosHilo1 = new ArrayList<Thread.State>();
		
		Hilo hilo1 = new Hilo("Servicio");
		Hilo hilo2 = new Hilo("Proceso");
		Thread h1 = new Thread(hilo1);
		Thread h2 = new Thread(hilo2);
		
		estadosHilo1.add(h1.getState());
		
		h1.start();
		estadosHilo1.add(h1.getState());
		h2.start();
		try {
			Thread.currentThread().sleep(5000);
			estadosHilo1.add(h1.getState());
			System.out.println(estadosHilo1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
