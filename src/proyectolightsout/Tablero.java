package proyectolightsout;

import java.util.Random;

public class Tablero {
	
    private Casilla[][] tablero;
    
    private int tamaño;

    public Tablero(int tamaño) {
    	
        this.tamaño = tamaño;
        
        this.tablero = new Casilla[tamaño][tamaño];
        
        inicializarTablero();
        
    }

    private void inicializarTablero() {
    	
        Random rand = new Random();
        
        for (int i = 0; i < tamaño; i++) {
        	
            for (int j = 0; j < tamaño; j++) {
            	
                tablero[i][j] = new Casilla(rand.nextBoolean());
                
            }
            
        }
        
    }

    public void mostrarTablero() {
    	
        for (int i = 0; i < tamaño; i++) {
        	
            for (int j = 0; j < tamaño; j++) {
            	
                System.out.print(tablero[i][j] + " | ");
                
            }
            
            System.out.println();
            
        }
        
    }

    public void pulsarCasilla(int fila, int col) {
    	
        if (fila >= 0 && fila < tamaño && col >= 0 && col < tamaño) {
        	
            tablero[fila][col].invertir();
            
            if (fila > 0) tablero[fila - 1][col].invertir(); 
            
            if (fila < tamaño - 1) tablero[fila + 1][col].invertir();
            
            if (col > 0) tablero[fila][col - 1].invertir(); 
            
            if (col < tamaño - 1) tablero[fila][col + 1].invertir();
            
        }
        
    }

    public boolean haGanado() {
    	
        for (Casilla[] fila : tablero) {
        	
            for (Casilla casilla : fila) {
            	
                if (casilla.estaEncendida()) {
                	
                    return false;
                    
                }
                
            }
            
        }
        
        return true;
        
    }
    
}