package Proyecto;

public class AeropuertoPublico extends Aeropuerto {
    private double subsidio;

    public AeropuertoPublico(String nombre, String cuidad, String pais) {
        super(nombre, cuidad, pais);
    }

    public AeropuertoPublico(String nombre, String cuidad, String pais, Compañia[] c, double subsidio) {
        super(nombre, cuidad, pais, c);
        this.subsidio = subsidio;
    }

    public AeropuertoPublico(String nombre, String cuidad, String pais, double subsidio) {
        super(nombre, cuidad, pais);
        this.subsidio = subsidio;
    }

    public double getSubsidio() {
        return subsidio;
    }

    
    
}
