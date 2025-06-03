package lightsout;

import java.io.IOException;

/**
 * 
 * Clase principal del programa Lights Out.
 * 
 * Se encarga de inicializar la configuración y el juego.
 * 
 */

public class Main {

    /**
     * 
     * Método principal que inicia la ejecución del juego.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     * 
     * @throws IOException Si ocurre un error en la lectura/escritura de archivos de configuración.
     * 
     */
	
    public static void main(String[] args) throws IOException {

        Configuracion config = new Configuracion("config.txt");

        // Se intenta cargar la configuración desde el fichero
        
        Configuracion.cargarDesdeFichero("config.txt");

        if (config == null) {
        	
            System.out.println("No se pudo cargar la configuración.");
            
            return;
            
        } else {
        	
            // Se inicializa el juego con la configuración obtenida
        	
            Juego lightsout = new Juego(config);
            
            lightsout.iniciar();
            
        }
        
    }
    
}