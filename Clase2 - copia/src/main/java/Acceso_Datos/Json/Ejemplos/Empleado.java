package Acceso_Datos.Json.Ejemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Empleado {
	public static void main(String[] args) throws FileNotFoundException {
		FileReader fichero = new FileReader("src/main/java/Acceso_Datos/Json/Ejemplos/Empleados.json");
		Gson gson = new Gson();
		Empleado empleado = gson.fromJson(fichero, Empleado.class);

	}

}
