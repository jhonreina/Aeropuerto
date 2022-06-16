package Proyecto;

public class Vuelo {
    
    private String identificarVuelo;
    private String ciudadOrigen;
    private String cuidadDestino;
    private double precio;
    private int numeroMaximo;
    private int numeroActual;
    private Pasajero listaPasajero[];

    public Vuelo(String identificarVuelo, String ciudadOrigen, String cuidadDestino, double precio, int numeroMaximo) {
        this.identificarVuelo = identificarVuelo;
        this.ciudadOrigen = ciudadOrigen;
        this.cuidadDestino = cuidadDestino;
        this.precio = precio;
        this.numeroMaximo = numeroMaximo;
        this.numeroActual = 0;
        this.listaPasajero = new Pasajero[numeroMaximo];
    }
    
    public void insertarPasajero(Pasajero pasajero) {
        listaPasajero[numeroActual] = pasajero;
        numeroActual++;
    }

    public String getIdentificarVuelo() {
        return identificarVuelo;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCuidadDestino() {
        return cuidadDestino;
    }

    public double getPrecio() {
        return precio;
    }

    public int getNumeroMaximo() {
        return numeroMaximo;
    }

    public int getNumeroActual() {
        return numeroActual;
    }

    public Pasajero getPasajero(int i) {
        return listaPasajero[i];
    }

    public Pasajero getpPasajero(String pasaporte) {
        boolean encontrado = false;
        int i = 0;
        Pasajero pas = null;
        while (!encontrado && i<listaPasajero.length) {
            if (pasaporte == listaPasajero[i].getPasaporte()) {
                encontrado = true;
                pas = listaPasajero[i];
            }
            i++;
        }
        return pas;
        
    }

    
}
