package Acceso_Datos.Repositorio;

import Acceso_Datos.Exception.RepositorioException;
import Acceso_Datos.Persona;

import java.io.FileNotFoundException;
import java.util.List;

public interface IRepositorioPersonas {
    List<Persona> findAll() throws RepositorioException, FileNotFoundException;
    //Hace lectura de fichero si lista personas es nula
    Persona findById(String nombre) throws RepositorioException;
    //Puede devolver null si no hay una persona con eses nombre
    boolean existsById(String nombre) throws RepositorioException;
    int count() throws RepositorioException;
    void save(Persona persona) throws RepositorioException;
    // alta o modificación Escribe fichero
    boolean deleteById(String nombre) throws RepositorioException;
    // Escribe en fichero
    public List<Persona> getPersonas();
}

