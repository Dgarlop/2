package Acceso_Datos.Json.Boletin.Paises.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Acceso_Datos.Json.Boletin.Paises.Modelo.Pais;

public class RepositorioPaises {
	public static final String RUTA = "/src/main/java/Acceso_Datos/Json/Boletin/Paises/Modelo/paises.csv";
	FileReader archivoLeer;
	List<Pais> listaPaises;
	
	public List<Pais> leerFichero() {
		
		listaPaises = new ArrayList<Pais>();
		
		try {
			archivoLeer = new FileReader (RUTA);
			Scanner sc = new Scanner(archivoLeer);
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(",");
				if(campos[0] != null && campos[1] != null) {
					Pais p = new Pais(campos[0], campos[1]);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaPaises;
	}

}
