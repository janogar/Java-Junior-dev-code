package com.example;

import java.util.Arrays;


//pilares de la PPO => encapsulamiento, Herencia, polimorfismo, abstraccion

abstract class ProcesadorArreglos { 

    private double[] datos; //encapsulamiento

    public ProcesadorArreglos(double[] datos) {
        this.datos = datos.clone();
    }

    public double[] getDatos() {
        return datos;
    }

    public void setDatos(double[] datos) {
        this.datos = datos.clone();
    }

    public abstract void ordenar();

    //metodos "utilidades"

    public double obtenerMinimo(){
        return datos.length > 0 ? datos[0] : 0;
    }

    public double obtenerMaximo(){
        return datos.length > 0 ? datos[datos.length - 1] : 0;
    }

    public void mostrarDatos(String mensaje){
        System.out.println(mensaje + " : " + Arrays.toString(datos));
    }


}

//Herencia

class OrdenadorBurbuja extends ProcesadorArreglos {

    public OrdenadorBurbuja(double[] calificaciones) {
        super(calificaciones);
    }

    //polimorfismo
    @Override
    public void ordenar() {

        double[] lista = getDatos();

        for (int pasadaLista = 0; pasadaLista < lista.length - 1; pasadaLista++) { //ciclo que controla la cantidad de pasadas
            for(int indiceComparacionVecino = 0; indiceComparacionVecino < lista.length - 1
                 - pasadaLista; indiceComparacionVecino++){ //comparar el elemento anterior con su vecino posterior
                    if (lista[indiceComparacionVecino] > lista[indiceComparacionVecino + 1]) {
                        double auxiliar = lista[indiceComparacionVecino];
                        lista[indiceComparacionVecino] = lista[indiceComparacionVecino + 1];
                        lista[indiceComparacionVecino + 1] = auxiliar;
                    }
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        double[] calificacionesOriginales = { 4.2, 3.5, 2.8, 4.8, 3.9 };

        ProcesadorArreglos procesador = new OrdenadorBurbuja(calificacionesOriginales);

        procesador.mostrarDatos("Calificaciones originales");

        procesador.ordenar();

        procesador.mostrarDatos("Calificaciones ordenadas");

        System.out.println("Calificacion menor: " + procesador.obtenerMinimo());
        System.out.println("Callificacion maxima:" + procesador.obtenerMaximo());
    }
}