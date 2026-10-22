package Acceso_Datos.Repositorio;

import Acceso_Datos.Controller.Controlador;
import Acceso_Datos.Exception.RepositorioException;
import Acceso_Datos.Persona;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class RepositorioPersona implements IRepositorioPersonas{
    public File fichero;
    public List<Persona> personas;

    public RepositorioPersona(String ruta) {
        this.personas = new ArrayList<Persona>();
        this.fichero = new File(NOMBRE_FICHERO) ;//Aqui hiria la variable ruta
    }
    public static final String  NOMBRE_FICHERO= "src\\main\\java\\Acceso_Datos\\ListaAlumnos";

    @Override
    public List<Persona> findAll() throws RepositorioException, FileNotFoundException {
        if(this.personas.size() == 0){
            this.personas = leePersonas(NOMBRE_FICHERO);//Aqui hiria el fichero
        }
        return this.personas;
    }

    @Override
    public Persona findById(String nombre) throws RepositorioException {
        return null;
    }

    @Override
    public boolean existsById(String nombre) throws RepositorioException {
        return false;
    }

    @Override
    public int count() throws RepositorioException {
        return 0;
    }

    @Override
    public void save(Persona persona) throws RepositorioException {

    }

    @Override
    public boolean deleteById(String nombre) throws RepositorioException {
        return false;
    }

    @Override
    public List<Persona> getPersonas() {
        return List.of();
    }
    private List<Persona> leePersonas(String rutaFichero) throws FileNotFoundException {
        Scanner scan = null;
        List<Persona> listaPersona = new ArrayList<Persona>();

        try {
            FileReader fichero = new FileReader(rutaFichero);
            scan = new Scanner(fichero);
            scan.useLocale(Locale.ENGLISH);
            while (scan.hasNext()) {
                String nombre = scan.next();
                Persona p = new Persona(nombre);
                List<Double> listaNotas = new ArrayList<Double>();
                while (scan.hasNextDouble()) {
                    Double nota = scan.nextDouble();
                    listaNotas.add(nota);
                }

                p.setNotas(listaNotas);
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
