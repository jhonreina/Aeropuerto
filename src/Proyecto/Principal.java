package Proyecto;

import java.util.Scanner;

public class Principal {
    static Scanner entrada = new Scanner(System.in);
    final static int num = 4;//Numero de aeropuertos
    static Aeropuerto aeropuertos[] = new Aeropuerto[num];

    public static void main(String[] args) {
        //insertar datos de los aeropuerto
        insertarDatosAeropuertos(aeropuertos);
        menu();
    }

    public static void insertarDatosAeropuertos(Aeropuerto aero[]) {
        aero[0] = new AeropuertoPublico("El dorado", "Bogota", "Colombia", 80000000);
        aero[0].insertarCompañia(new Compañia("AeroColombia"));
        aero[0].insertarCompañia(new Compañia("LATAM"));
        aero[0].getCompañia("AeroColombia").insertarVuelo(new Vuelo("IB20", "Bogota", "Mexico", 150.90, 150));
        aero[0].getCompañia("AeroColombia").insertarVuelo(new Vuelo("IB21", "Bogota", "Buenos Aires", 180.99, 120));
        aero[0].getCompañia("LATAM").insertarVuelo(new Vuelo("FC12", "Bogota", "Londres", 500.90, 180));
        aero[0].getCompañia("AeroColombia").getVuelo("IB20")
                .insertarPasajero(new Pasajero("Jonathan", "65413166", "Colombiana"));
        aero[0].getCompañia("AeroColombia").getVuelo("IB20")
                .insertarPasajero(new Pasajero("Alejandra", "1123151", "Colombiana"));
        aero[0].getCompañia("LATAM").getVuelo("FC12").insertarPasajero(new Pasajero("Pedro", "54651321", "Inglesa"));

        aero[1] = new AeropuertoPrivado("Alfonso", "Cali", "Colombia");
        aero[1].insertarCompañia(new Compañia("AirEuropa"));
        String empresas[] = { "Bavaria", "Argos" };
        ((AeropuertoPrivado) aero[1]).insertarEmpresas(empresas);
        aero[1].getCompañia("AirEuropa").insertarVuelo(new Vuelo("AE025", "Madrid", "Venezuela", 450.45, 150));
        aero[1].getCompañia("AirEuropa").getVuelo("AE025")
                .insertarPasajero(new Pasajero("Carlos", "13254321", "española"));

        aero[2] = new AeropuertoPublico("Rafael", "Cartagena", "Colombia", 40000000);
        aero[2].insertarCompañia(new Compañia("Avianca"));
        aero[2].insertarCompañia(new Compañia("Vivacolombia"));
        aero[2].getCompañia("Avianca").insertarVuelo(new Vuelo("AS210", "Cartagena", "Medellin", 200.50, 180));
        aero[2].getCompañia("Avianca").insertarVuelo(new Vuelo("FG523", "Cartagena", "Medellin", 189.50, 180));
        aero[2].getCompañia("Avianca").getVuelo("AS210")
                .insertarPasajero(new Pasajero("Maria", "45465113", "Colombiana"));
        aero[2].getCompañia("Avianca").getVuelo("FG523")
                .insertarPasajero(new Pasajero("Sandra", "15454162", "Cubana"));

        aero[3] = new AeropuertoPublico("Aeropuerto Mexicano", "Cancún", "Mexico", 20000000);
        aero[3].insertarCompañia(new Compañia("AeroMexico"));
        aero[3].getCompañia("AeroMexico").insertarVuelo(new Vuelo("IB2040", "Mexico", "Cancun", 380.90, 150));
        aero[3].getCompañia("AeroMexico").insertarVuelo(new Vuelo("IB2042", "Mexico", "Italia", 750.52, 170));

    }
    
    public static void menu() {
        String nombreAeropuerto,nombreCompañia,origen,destino;
        int opcion;
        Aeropuerto aeropuerto;
        Compañia compañia;

        do {
            System.out.println("\t.:MENU:.");
            System.out.println("1. Ver Aeropuertos gestionados(Publicos o Privados)");
            System.out.println("2. Ver empresas (privadas) o subsidiadas");
            System.out.println("3. Lista de compañias de Aeropuerto");
            System.out.println("4. Lista de vuelos por compañia");
            System.out.println("5. Listar posible vuelos de Origen a Destino");
            System.out.println("6. Salir");
            System.out.print("Digite la opcion a realizar: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println();
                    mostrarDatosAeropuertos(aeropuertos);// Ver Aeropuertos gestionados(Publicos o Privados)                
                    break;
                case 2:
                    System.out.println();// Ver empresas (privadas) o subsidiadas
                    mostrarPatrocinio(aeropuertos);
                    break;
                case 3:// Lista de compañias de un aeropuerto
                    entrada.nextLine();
                    System.out.print("\nDigite el nombre del Aeropuerto: ");
                    nombreAeropuerto = entrada.nextLine();
                    aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                    if (aeropuerto == null) {
                        System.out.println("El Aeropuerto no existe");
                    }
                    else {
                        mostrarCompañias(aeropuerto);
                    }
                    break;
                case 4:// Lista de vuelos por 
                    entrada.nextLine();
                    System.out.print("\nDigite el nombre del Aeropuerto: ");
                    nombreAeropuerto = entrada.nextLine();
                    aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                    if (aeropuerto == null) {
                        System.out.print("El Aeropuerto no existe");
                    }
                    else {
                        System.out.print("Digite el nombre de la compañia: ");
                        nombreCompañia = entrada.nextLine();
                        compañia = aeropuerto.getCompañia(nombreCompañia);
                        mostrarVuelos(compañia);
                    }
                    break;
                case 5:// Listar posible vuelos de Origen a 
                    entrada.nextLine();
                    System.out.print("\nDigite la cuiudad Origen: ");
                    origen = entrada.nextLine();
                    System.out.print("Dgite la cuidada Destino: ");
                    destino = entrada.nextLine();
                    mostrarVueloOrigenDestino(origen,destino,aeropuertos);

                    break;
                case 6:
                    break;
                default:
                    System.out.println("Error, se equivico de opcion de menú");
                    break;
            }

        } while (opcion != 6);
    }

    public static void mostrarDatosAeropuertos(Aeropuerto aeropuertos[]) {
        for (int i = 0; i < aeropuertos.length; i++) {
            if (aeropuertos[i] instanceof AeropuertoPrivado) {
                System.out.println("Aeropuerto Privado");
                System.out.println("Nombre: " + aeropuertos[i].getNombre());
                System.out.println("Cuidad: " + aeropuertos[i].getCuidad());
                System.out.println("Pais: " + aeropuertos[i].getPais());

            } else {
                System.out.println("Aeropuerto Publico");
                System.out.println("Nombre: " + aeropuertos[i].getNombre());
                System.out.println("Cuidad: " + aeropuertos[i].getCuidad());
                System.out.println("Pais: " + aeropuertos[i].getPais());

            }
            System.out.println();
        }
    }
    
    public static void mostrarPatrocinio(Aeropuerto aeropuerto[]) {
        String empresas[];

        for (int i = 0; i < aeropuerto.length; i++) {
            if (aeropuerto[i] instanceof AeropuertoPrivado) {
                System.out.println("Aeropuerto Privado: " + aeropuerto[i].getNombre());
                empresas = ((AeropuertoPrivado) aeropuertos[i]).getListaEmpresas();
                System.out.println("Empreasas: ");
                for (int j = 0; j < empresas.length; j++) {
                    System.out.println(empresas[j]);
                }
            } else {
                System.out.println("Aeropuetos Publicos: " + aeropuertos[i].getNombre());
                System.out.println("Subsidio: " + ((AeropuertoPublico) aeropuertos[i]).getSubsidio());
            }
            System.out.println();
        }
    }

    public static Aeropuerto buscarAeropuerto(String nombre, Aeropuerto aeropuertos[]) {
        boolean encontrado = false;
        int i = 0;
        Aeropuerto aero = null;
        while (!encontrado && i < aeropuertos.length) {
            if (nombre.equals(aeropuertos[i].getNombre())) {
                encontrado = true;
                aero = aeropuertos[i];
            }
            i++;
        }
        return aero;
    }
    
    public static void mostrarCompañias(Aeropuerto aeropuerto) {
        System.out.println("\nLas compañias del Aeropuerto: " + aeropuerto.getNombre());
        for (int i = 0; i < aeropuerto.getNumCompañia(); i++) {
            System.out.println(aeropuerto.getCompañia(i).getNombre());
        }
        System.out.println();
    }
    
    public static void mostrarVuelos(Compañia compañia) {
        Vuelo vuelo;
        System.out.println("Los vuelos de la compañia: " + compañia.getNombre());
        for (int i = 0; i < compañia.getNumVuelo(); i++) {
            vuelo = compañia.getVuelo(i);
            System.out.println("Identificador: " + vuelo.getIdentificarVuelo());
            System.out.println("Ciudad Origen: " + vuelo.getCiudadOrigen());
            System.out.println("Ciudad Destino: " + vuelo.getCuidadDestino());
            System.out.println("Precio: $" + vuelo.getPrecio());
            System.out.println();
        }

    }

    public static Vuelo[] buscarVuelosOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]) {
        Vuelo vuelo;
        int contador = 0;
        Vuelo[] listaVuelos;
        for (int i = 0; i < aeropuertos.length; i++) {//recorremos los aeropuertos 
            for (int j = 0; j < aeropuertos[i].getNumCompañia(); j++) {//recorremos compañias
                for (int j2 = 0; j2 < aeropuertos[i].getCompañia(j).getNumVuelo(); j2++) {//recoreemos los vuelos
                    vuelo = aeropuertos[i].getCompañia(j).getVuelo(j2);
                    if (origen.equals(vuelo.getCiudadOrigen()) && (destino.equals(vuelo.getCuidadDestino()))) {
                        contador++;
                    }
                }
            }
        }
        listaVuelos = new Vuelo[contador];
        int q = 0;

        for (int i = 0; i < aeropuertos.length; i++) {
            for (int j = 0; j < aeropuertos[i].getNumCompañia(); j++) {
                for (int j2 = 0; j2 < aeropuertos[i].getCompañia(j).getNumVuelo(); j2++) {
                    vuelo = aeropuertos[i].getCompañia(j).getVuelo(j2);
                    if (origen.equals(vuelo.getCiudadOrigen()) && (destino.equals(vuelo.getCuidadDestino()))) {
                        listaVuelos[q] = vuelo;
                        q++;
                    }
                }
            }
        }
        return listaVuelos;
    }

    public static void mostrarVueloOrigenDestino(String origen,String destino,Aeropuerto aeropuertos[]){
      Vuelo vuelos[];
      vuelos=buscarVuelosOrigenDestino(origen, destino, aeropuertos);
      if (vuelos.length == 0) {
        System.out.println("No existen vuelos de esa cuidada origen a destino");

      }
      else{
        System.out.println("\nVuelos encontrados: \n");
        for (int i = 0; i < vuelos.length; i++) {
            System.out.println("Identificador: "+vuelos[i].getIdentificarVuelo());
            System.out.println("Ciudad Origen: "+vuelos[i].getCiudadOrigen());
            System.out.println("Ciudada destino: "+vuelos[i].getCuidadDestino());
            System.out.println("Precio: $"+vuelos[i].getPrecio());
            System.out.println();
        }
      }
    }
}
