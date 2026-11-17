package boletin2.ejercicio3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Lanzador {
	public static final String rutaDirectorio = "src/main/resources";
	public static void main(String[] args) {
	       List<String> ficheros = new ArrayList<String>();
	       long t_comienzo = 0;
	       long t_fin= 0;
	       int caracteresTotales = 0;
	       ficheros.add(rutaDirectorio+"app.log");
	       ficheros.add(rutaDirectorio+"concurrencia.txt");
	       ficheros.add(rutaDirectorio+"app.log");
	       ficheros.add(rutaDirectorio+"concurrencia.txt");
	       List<Thread> hilos = new ArrayList<Thread>();
	       List<ContadorCaracteresHilo> contadores = new ArrayList<ContadorCaracteresHilo>();
	       t_comienzo = System.currentTimeMillis();
	           for (String archivo :  ficheros)
	           {
		            // Crear y ejecutar un hilo para cada archi
	 ContadorCaracteresHilo contador = new ContadorCaracteresHilo(archivo);
		            contadores.add(contador);
		            Thread hilo = new Thread(contador);


		            hilos.add(hilo);
		            hilo.start();
	           }
	           //Todos mis hilos están creados y runnable
	           for(Thread h : hilos)
	           {
	           	try {
						h.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	           }
	 
	          
	           t_fin = System.currentTimeMillis();
	           long tiempototal = t_fin-t_comienzo;
	           System.out.println("El proceso total ha tardado= "+tiempototal+"mseg");
	           for(ContadorCaracteresHilo c : contadores)
	           {
	           	caracteresTotales = caracteresTotales+c.getContador();
	           }
	          
	           System.out.println(caracteresTotales);


	   }


}
