package boletin1.ejercicio8;

import java.util.Scanner;

import boletin1.Mascota;

public class HiloServicio{
	public static void main(String[] args) {
		Mascota lulu = new Mascota("Lulú");
		Thread hilo1 = new Thread(lulu);
		
		hilo1.start();
		//Scanner sc = new Scanner(null);
		
	}
	

}
