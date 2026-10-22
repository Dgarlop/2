package Acceso_Datos.Controller;

import Acceso_Datos.Persona;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Controlador {

    static void main(String[] args) throws FileNotFoundException {
        Controlador ct = new Controlador();
        System.out.println(ct.leePersonas("C:\\Users\\alumno\\Desktop\\2\\Clase2\\src\\main\\java\\Acceso_Datos\\ListaAlumnos"));
    }
}

