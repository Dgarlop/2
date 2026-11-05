package Acceso_Datos.Json.Boletin.Paises.Controller;

import Acceso_Datos.Json.Boletin.Paises.Repository.RepositorioPaises;

public class Controlador {
	public static void main(String[] args) {
		RepositorioPaises rp = new RepositorioPaises();
		rp.leerFichero();
	}

}
