package lightsout;

import java.util.Random;

/**
 * 
 * La clase {@code Tablero} representa el tablero del juego Lights Out.
 * 
 * Contiene una matriz de casillas y métodos para interactuar con ellas.
 * 
 */

public class Tablero {

    /** Matriz bidimensional que almacena las casillas del tablero. */
	
    private Casilla[][] casillas;

    /** Número de filas en el tablero. */
    
    private int filas;

    /** Número de columnas en el tablero. */
    
    private int columnas;

    /**
     * 
     * Constructor que inicializa un tablero con casillas apagadas.
     * 
     * @param filas Número de filas en el tablero.
     * 
     * @param columnas Número de columnas en el tablero.
     * 
     */
    
    public Tablero(int filas, int columnas) {
    	
        this.filas = filas;
        
        this.columnas = columnas;
        
        this.casillas = new Casilla[filas][columnas];

        // Se inicializan todas las casillas como apagadas
        
        for (int i = 0; i < filas; i++) {
        	
            for (int j = 0; j < columnas; j++) {
            	
                casillas[i][j] = new Casilla(false);
                
            }
            
        }
        
    }

    /**
     * 
     * Activa un número determinado de casillas de manera aleatoria.
     * 
     * @param casillasActivas Número de casillas que deben activarse aleatoriamente.
     * 
     */
    
    public void inicializarAleatoriamente(int casillasActivas) {
    	
        Random random = new Random();
        
        int activadas = 0;

        while (activadas < casillasActivas) {
        	
            int fila = random.nextInt(filas);
            
            int columna = random.nextInt(columnas);

            if (!casillas[fila][columna].estaActiva()) {
            	
                casillas[fila][columna].encender();
                
                activadas++;
                
            }
            
        }
        
    }

    /**
     * 
     * Muestra el tablero en la consola.
     * 
     * Cada casilla se representa con "1" si está encendida y "0" si está apagada.
     * 
     */
    
    public void mostrarTablero() {
    	
        for (int i = 0; i < filas; i++) {
        	
            for (int j = 0; j < columnas; j++) {
            	
                System.out.print(casillas[i][j] + " ");
                
            }
            
            System.out.println();
            
        }
        
    }

    /**
     * 
     * Cambia el estado de la casilla seleccionada y de sus casillas adyacentes.
     * 
     * @param fila Fila de la casilla a cambiar.
     * 
     * @param columna Columna de la casilla a cambiar.
     * 
     */
    
    public void cambiarCasilla(int fila, int columna) {
    	
        if (esCoordenadaValida(fila, columna)) {
        	
            casillas[fila][columna].cambiarEstado();

            // Cambiar estado de las casillas adyacentes si están dentro de los límites
            
            if (esCoordenadaValida(fila - 1, columna)) casillas[fila - 1][columna].cambiarEstado();
            
            if (esCoordenadaValida(fila + 1, columna)) casillas[fila + 1][columna].cambiarEstado();
            
            if (esCoordenadaValida(fila, columna - 1)) casillas[fila][columna - 1].cambiarEstado();
            
            if (esCoordenadaValida(fila, columna + 1)) casillas[fila][columna + 1].cambiarEstado();
            
        }
        
    }

    /**
     * 
     * Determina si todas las casillas del tablero están apagadas.
     * 
     * @return {@code true} si todas las casillas están apagadas, {@code false} si hay alguna encendida.
     * 
     */
    
    public boolean estaResuelto() {
    	
        for (int i = 0; i < filas; i++) {
        	
            for (int j = 0; j < columnas; j++) {
            	
                if (casillas[i][j].estaActiva()) {
                	
                    return false;
                    
                }
                
            }
            
        }
        
        return true;
        
    }

    /**
     * 
     * Verifica si una coordenada es válida dentro del tablero.
     * 
     * @param fila Fila a verificar.
     * 
     * @param columna Columna a verificar.
     * 
     * @return {@code true} si la coordenada está dentro del rango del tablero, {@code false} en caso contrario.
     * 
     */
    private boolean esCoordenadaValida(int fila, int columna) {
    	
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
        
    }
    
}