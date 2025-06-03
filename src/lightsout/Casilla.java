package lightsout;

/**
 * La clase {@code Casilla} representa una casilla en el juego Lights Out.
 * Puede estar activa o inactiva, y se puede cambiar su estado.
 */
public class Casilla {

    /** Indica si la casilla está activa (encendida) o inactiva (apagada). */
    private boolean activa;

    /**
     * Constructor de la clase {@code Casilla}.
     * 
     * @param activa {@code true} si la casilla está activa, {@code false} si está inactiva.
     */
    public Casilla(boolean activa) {
        this.activa = activa;
    }

    /**
     * Verifica si la casilla está activa.
     * 
     * @return {@code true} si la casilla está activa, {@code false} si está apagada.
     */
    public boolean estaActiva() {
        return activa;
    }

    /**
     * Cambia el estado de la casilla.
     * Si está activa, se apaga. Si está apagada, se activa.
     */
    public void cambiarEstado() {
        this.activa = !this.activa;
    }

    /**
     * Apaga la casilla, estableciendo su estado en inactivo.
     */
    public void apagar() {
        this.activa = false;
    }

    /**
     * Enciende la casilla, estableciendo su estado en activo.
     */
    public void encender() {
        this.activa = true;
    }

    /**
     * Devuelve una representación de la casilla como cadena de texto.
     * 
     * @return "1" si la casilla está activa, "0" si está apagada.
     */
    @Override
    public String toString() {
        return activa ? "1" : "0";
    }
}