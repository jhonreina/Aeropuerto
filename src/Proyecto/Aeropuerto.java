package Proyecto;

public class Aeropuerto {
    private String nombre;
    private String cuidad;
    private String pais;
    private Compañia listaCompañias[] = new Compañia[10];
    private int numCompañia;

    public Aeropuerto(String nombre, String cuidad, String pais) {
        this.nombre = nombre;
        this.cuidad = cuidad;
        this.pais = pais;
        this.numCompañia = 0;
    }

    public Aeropuerto(String nombre, String cuidad, String pais, Compañia c[]) {
        this.nombre = nombre;
        this.cuidad = cuidad;
        this.pais = pais;
        listaCompañias = c;
        this.numCompañia = c.length;
    }

    public void insertarCompañia(Compañia compañia) {
        listaCompañias[numCompañia] = compañia;
        numCompañia++;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCuidad() {
        return cuidad;
    }

    public String getPais() {
        return pais;
    }

    public Compañia[] getListaCompañias() {
        return listaCompañias;
    }

    public int getNumCompañia() {
        return numCompañia;
    }

    public Compañia getCompañia(int i) {
        return listaCompañias[i];
    }

    public Compañia getCompañia(String nombre) {
        boolean encontrado = false;
        int i = 0;
        Compañia c = null;
        while (!encontrado && i < listaCompañias.length) {
            if (nombre.equals(listaCompañias[i].getNombre())) {
                encontrado = true;
                c = listaCompañias[i];
            }
            i++;
        }
        return c;
    }



    
}
