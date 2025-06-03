package lightsout;

import java.io.*;
import java.util.Properties;

/**
 * La clase {@code Configuracion} gestiona la configuración del juego Lights Out.
 * Carga los parámetros desde un fichero de propiedades o utiliza valores por defecto.
 */
public class Configuracion {
    
    /** Número de filas del tablero. */
    private int filas;
    
    /** Número de columnas del tablero. */
    private int columnas;
    
    /** Duración máxima de la partida en segundos. */
    private int duracion;
    
    /** Modo de juego (por ejemplo, "aleatorio"). */
    private String modo;
    
    /** Número de casillas activas al inicio del juego. */
    private int casillasActivas;

    /**
     * Constructor que carga la configuración desde un fichero.
     * 
     * @param rutaFichero Ruta del fichero de configuración.
     * @throws IOException Si ocurre un error al leer el fichero.
     */
    public Configuracion(String rutaFichero) throws IOException {
        cargarConfiguracion(rutaFichero);
    }

    /**
     * Carga la configuración desde un fichero de propiedades.
     * Si el fichero no existe, se establecen valores por defecto.
     * 
     * @param rutaFichero Ruta del fichero de configuración.
     * @throws IOException Si ocurre un error en la lectura del fichero.
     */
    private void cargarConfiguracion(String rutaFichero) throws IOException {
        Properties props = new Properties();

        try (FileReader lector = new FileReader(rutaFichero)) {
            props.load(lector);

            this.filas = Integer.parseInt(props.getProperty("filas", "5"));
            this.columnas = Integer.parseInt(props.getProperty("columnas", "5"));
            this.duracion = Integer.parseInt(props.getProperty("duracion", "60"));
            this.modo = props.getProperty("modo", "aleatorio");
            this.casillasActivas = Integer.parseInt(props.getProperty("casillasActivas", "8"));

            if (filas < 4 || filas > 9 || columnas < 4 || columnas > 9) {
                throw new IllegalArgumentException("Tamaño del tablero fuera del rango permitido (4-9).");
            }
        }
    }

    /**
     * Obtiene el número de filas del tablero.
     * 
     * @return Número de filas.
     */
    public int getFilas() {
        return filas;
    }

    /**
     * Obtiene el número de columnas del tablero.
     * 
     * @return Número de columnas.
     */
    public int getColumnas() {
        return columnas;
    }

    /**
     * Obtiene la duración máxima de la partida.
     * 
     * @return Duración en segundos.
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Obtiene el modo de juego.
     * 
     * @return Modo de juego como cadena de texto.
     */
    public String getModo() {
        return modo;
    }

    /**
     * Obtiene el número de casillas activas al inicio del juego.
     * 
     * @return Número de casillas activas.
     */
    public int getCasillasActivas() {
        return casillasActivas;
    }

    /**
     * Carga la configuración desde el fichero de configuración.
     * (Este método aún no está implementado correctamente)
     * 
     * @param rutaFichero Ruta del fichero.
     * @return {@code null} por ahora, ya que no está completamente desarrollado.
     */
    public static Configuracion cargarDesdeFichero(String rutaFichero) {
        return null; // Método pendiente de implementación
    }
}