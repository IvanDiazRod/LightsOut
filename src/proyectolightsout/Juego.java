package proyectolightsout;

import java.util.Scanner;

public class Juego {
	
    private Tablero tablero;
    
    private Scanner scanner;

    public Juego(int tamaño) {
    	
        this.tablero = new Tablero(tamaño);
        
        this.scanner = new Scanner(System.in);
        
    }

    public void jugar() {
    	
        while (!tablero.haGanado()) {
        	
            tablero.mostrarTablero();
            
            System.out.println("Introduce fila y columna, escribe -1 para salir:");
            
            int fila = scanner.nextInt();
            
            if (fila == -1) break;
            
            int col = scanner.nextInt();
            
            tablero.pulsarCasilla(fila, col);
            
        }

        if (tablero.haGanado()) {
        	
            System.out.println("Felicidades! Has ganado.");
            
        } else {
        	
            System.out.println("Bye");
            
        }
        
        scanner.close();
        
    }
    
}