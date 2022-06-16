package Proyecto;

public class AeropuertoPrivado extends Aeropuerto{
    private String listaEmpresas[] = new String[10];
    private int numEmpresa;


    public AeropuertoPrivado(String nombre, String cuidad, String pais) {
        super(nombre, cuidad, pais);
    }


    public AeropuertoPrivado(String nombre, String cuidad, String pais, Compañia[] c, String e[]) {
        super(nombre, cuidad, pais, c);
        this.listaEmpresas = e;
        numEmpresa = e.length;
    }

    public void insertarEmpresas(String e[]) {
        this.listaEmpresas = e;
        this.numEmpresa = e.length;
    }

    public void insertarEmpresa(String e) {
        listaEmpresas[numEmpresa] = e;
        numEmpresa++;
    }


    public String[] getListaEmpresas() {
        return listaEmpresas;
    }


    public int getNumEmpresa() {
        return numEmpresa;
    }

    
    
    
}
