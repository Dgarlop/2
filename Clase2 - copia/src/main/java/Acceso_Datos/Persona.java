package Acceso_Datos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Persona {
    private double notaMin;
    private double notaMax;
    private String nombre;
    List<Double> notas;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<Double>();
    }


    public double getNotaMin() {
        return notaMin;
    }

    public void setNotaMin(double notaMin) {
        this.notaMin = notaMin;
    }

    public double getNotaMax() {
        return notaMax;
    }

    public void setNotaMax(double notaMax) {
        this.notaMax = notaMax;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return ", nombre='" + nombre + '\'' +
                ", notas=" + notas;
    }
    public List<Persona> leePersonas(String rutaFichero) throws FileNotFoundException {
        Scanner scan = null;
        List<Persona> listaPersona = new ArrayList<Persona>();
        try {
            FileReader fichero = new FileReader(rutaFichero);
            scan = new Scanner(fichero);
            scan.useLocale(Locale.ENGLISH);
            while (scan.hasNext()) {
                String nombre = scan.next();
                Persona p = new Persona(nombre);
                scan.next();
                while (scan.hasNextDouble()) {
                    Double nota = scan.nextDouble();
                    getNotas().add(nota);
                }
                listaPersona.add(p);
            }
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
        return listaPersona;
    }
}
