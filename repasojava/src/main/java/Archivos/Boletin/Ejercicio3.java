package Archivos.Boletin;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ejercicio3 {
	private static final Logger logger = LogManager.getLogger(Ejercicio3.class);
    public static void main(String[] args) {
        File origin = new File(System.getProperty("user.home"));
        File miDirectorio = new File(origin, "miDirectorio");
        boolean creado = miDirectorio.mkdir();
        if (creado) {
        	logger.debug("Directorio creado." + miDirectorio.getAbsolutePath());
        }
        File lectura = new File(miDirectorio, "lectura.txt");
        logger.debug("Archivo lectura.txt creado");
        File normal = new File(miDirectorio, "normal.txt");
        logger.debug("Archivo normal.txt creado");

        boolean marcado = lectura.setReadOnly();
        if (marcado) {
        	logger.debug("Lectura.txt marcado como solo lectura.");
        }
        logger.debug("lectura.txt -> lectura: " + lectura.canRead() + " | escritura: " + lectura.canWrite() + " | ejecucion: " + lectura.canExecute());
        logger.debug("normal.txt -> lectura: " + normal.canRead() + " | escritura: " + normal.canWrite() + " | ejecucion: " + normal.canExecute());

        File nuevoArchivo = new File(miDirectorio, "renombrado.txt");
        boolean renombrado = normal.renameTo(nuevoArchivo);
        if (renombrado) {
        	logger.debug("normal.txt renombrado a renombrado.txt");
        }
        boolean borrado = lectura.delete();

        if (!borrado) {
        	logger.debug("No se ha podido borrar lectura.txt");
            lectura.setWritable(true);
            logger.debug("Permiso de escritura restuarado en lectura.txt");
            borrado = lectura.delete();
        }

        if (borrado) {
        	logger.debug("Lectura.txt borrado");
        }

        logger.debug("Contenido final de miDirectorio");
        File[] archivos = miDirectorio.listFiles();

        if (archivos != null && archivos.length > 0) {
            for (File archivo : archivos) {
            	logger.debug(archivo.getName());
            }
        } else {
        	logger.debug("El directorio está vacío.");
        }

    }
}
