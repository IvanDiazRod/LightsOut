package proyectolightsout;

public class Casilla {
	
    private boolean encendida;

    public Casilla (boolean estado) {
    	
        this.encendida = estado;
        
    }

    public void invertir() {
    	
        encendida = !encendida;
        
    }

    public boolean estaEncendida() {
    	
        return encendida;
        
    }

    @Override
    
    public String toString() {
    	
        return encendida ? "1" : "0";
        
    }
    
}