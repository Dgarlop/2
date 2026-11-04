import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LanzadorProcesadorSuministros {
	public static void main(String[] args) throws IOException, InterruptedException {
		LanzadorProcesadorSuministros lps = new LanzadorProcesadorSuministros();
		String ruta = "src/main/resources/recargas.txt";
		File archivo = new File(ruta);
		BufferedReader br = new BufferedReader(new FileReader(ruta));
	    
		String linea = null;
	    Scanner scan = new Scanner(archivo);
	    while (scan.hasNext()) {
	    	linea = scan.next();
	    	String argumentos = linea.replace(";" , " ");
	    	System.out.println(argumentos);
	    	lps.ejecuta(argumentos);
	    	/*for(String l : campos) {
	    		if(!(l == campos[0])) {
	    			kw = l;
	    		}
	    		lps.ejecuta(l,kw);*/
	    		
	    	
	    	
        }
}
	public void ejecuta(String strings) throws IOException, InterruptedException {
		String[] comandos = {"java", "-cp","ProcesadorFichero", strings};
		ProcessBuilder pb = new ProcessBuilder(comandos);
        Process proceso = pb.start();
        proceso.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
        String linea = reader.readLine();
        System.out.println(linea);
	}


}