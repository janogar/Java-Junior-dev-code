package com.example;

interface Navegable {
    void Navegar();
}

class Embarcacion {

    protected String nombre;
    protected double velocidadMaxima;

    public Embarcacion() {
    }

    public Embarcacion(String nombre, double velocidadMaxima) {
        this.nombre = nombre;
        this.velocidadMaxima = velocidadMaxima;
    }

    public void mostrarDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Velocidad máxima: " + velocidadMaxima + " km/h");
    }
    
}

class buqueCarga extends Embarcacion implements Navegable {
     
    private int capacidadToneladas;

    public buqueCarga(int capacidadToneladas) {
        this.capacidadToneladas = capacidadToneladas;
    }

    public buqueCarga(String nombre, double velocidadMaxima, int capacidadToneladas) {
        super(nombre, velocidadMaxima);
        this.capacidadToneladas = capacidadToneladas;
    }

    @Override
    public void Navegar() {
        System.out.println("El buque de carga transporta mercancia pesada");
    }

   @Override
    public void mostrarDetalles(){
        super.mostrarDetalles();
            System.out.println("El buque carga con: " + capacidadToneladas);
        }
}

class Crucero extends Embarcacion implements Navegable {

    private int cantidadPasajeros;

    public Crucero(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public Crucero(String nombre, double velocidadMaxima, int cantidadPasajeros) {
        super(nombre, velocidadMaxima);
        this.cantidadPasajeros = cantidadPasajeros;
    }

    @Override
    public void Navegar() {
        System.out.println("El crucero traslada turistas a destinos vacacionales");
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("cantidad de pasajeros: " + cantidadPasajeros);
    }
    

} 

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println("*** Buque de carga ****");

        buqueCarga miBuqueCarga = new buqueCarga("Buque Mercante", 100, 1000);

        miBuqueCarga.mostrarDetalles();
        miBuqueCarga.Navegar();

        System.out.println("");

        System.out.println("*** Crucero ***");
        Crucero miCrucero = new Crucero("Crucero Turistico", 300, 1000);


        miCrucero.mostrarDetalles();
        miCrucero.Navegar();

    }
}