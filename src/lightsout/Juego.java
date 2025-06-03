package lightsout;

import java.util.Scanner;

/**
 * 
 * La clase {@code Juego} gestiona la lógica principal del juego Lights Out.
 * 
 * Se encarga de iniciar el juego, manejar la interacción con el usuario y determinar el resultado.
 * 
 */

public class Juego {

    /** Representa el tablero del juego. */
	
    private Tablero tablero;

    /** Contiene la configuración del juego, incluyendo dimensiones y duración. */
    
    private Configuracion config;

    /** Lleva el conteo de los movimientos realizados por el jugador. */
    
    private int movimientos;

    /** Almacena el tiempo en milisegundos cuando el juego comienza. */
    
    private long tiempoInicio;

    /**
     * 
     * Constructor que inicializa el juego con una configuración dada.
     * 
     * @param config Configuración del juego, incluyendo dimensiones y modo de inicio.
     * 
     */
    
    public Juego(Configuracion config) {
    	
        this.config = config;
        
        this.tablero = new Tablero(config.getFilas(), config.getColumnas());
        
        this.movimientos = 0;
        
    }

    /**
     * 
     * Inicia el juego Lights Out. Se encarga de inicializar el tablero y gestionar la interacción con el usuario.
     * 
     */
    public void iniciar() {
    	
        // Verifica si el modo de juego es aleatorio o manual
    	
        if (config.getModo().equalsIgnoreCase("aleatorio")) {
        	
            tablero.inicializarAleatoriamente(config.getCasillasActivas());
            
        } else {
        	
            System.out.println("Modo manual aún no implementado.");
            
            return;
            
        }

        // Comienza el contador de tiempo
        
        tiempoInicio = System.currentTimeMillis();
        
        Scanner lector = new Scanner(System.in);

        // Bucle principal del juego
        
        while (true) {
            System.out.println("\nMovimientos: " + movimientos);
            
            System.out.println("Tiempo restante: " + tiempoRestante() + " segundos");
            
            tablero.mostrarTablero();

            // Verificar si el jugador ha ganado
            
            if (tablero.estaResuelto()) {
            	
                System.out.println("\n¡Has ganado en " + movimientos + " movimientos!");
                
                break;
                
            }

            // Verificar si el tiempo ha expirado
            
            if (tiempoRestante() <= 0) {
            	
                System.out.println("\n⏰ Tiempo agotado. ¡Has perdido!");
                
                break;
                
            }

            // Solicitar entrada al usuario
            
            System.out.println("Introduce coordenadas (fila y columna) o '00' para salir:");
            
            String entrada = lector.nextLine().trim();

            // Manejar la opción de salida
            
            if (entrada.equals("00")) {
            	
                System.out.println("Has salido de la partida.");
                
                break;
                
            }

            // Procesar la entrada del usuario
            
            try {
            	
                String[] partes = entrada.split("\\s+");
                
                int fila = Integer.parseInt(partes[0]);
                
                int columna = Integer.parseInt(partes[1]);

                tablero.cambiarCasilla(fila, columna);
                
                movimientos++;
                
            } catch (Exception e) {
            	
                System.out.println("❌ Entrada no válida. Usa formato: 'fila columna'");
                
            }
            
        }

        lector.close();
        
    }

    /**
     * 
     * Calcula el tiempo restante antes de que la partida expire.
     * 
     * @return Número de segundos restantes antes de que el juego termine.
     * 
     */
    
    private long tiempoRestante() {
    	
        long tiempoActual = System.currentTimeMillis();
        
        long transcurrido = (tiempoActual - tiempoInicio) / 1000;
        
        return config.getDuracion() - transcurrido;
        
    }
    
}