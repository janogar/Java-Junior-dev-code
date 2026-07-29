package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class ProcesadorLista {

    private List<String> elementos;

    public ProcesadorLista(List<String> elementos) {

        this.elementos = new ArrayList<>(elementos);

    }

    public List<String> getElementos() {
        return elementos;
    }

    public void setElementos(List<String> elementos) {
        this.elementos = new ArrayList<>(elementos);
    }

    public abstract void ordenar();

    public void imprimirLista(String mensaje) {
        System.out.println(mensaje + " : " + elementos);
    }
    
}

class OrdenarColecciones extends ProcesadorLista {

    public OrdenarColecciones(List<String> elementos) {
        super(elementos);
    }

    @Override
    public void ordenar() {
        Collections.sort(getElementos());
    }
}

    




public class Main {

    public static void main(String[] args) {

        List<String> nombresOriginales = new ArrayList<>();
        nombresOriginales.add("Angel");
        nombresOriginales.add("Jano");
        nombresOriginales.add("Sol");
        nombresOriginales.add("Juan");
        nombresOriginales.add("Maria");


        ProcesadorLista procesador = new OrdenarColecciones(nombresOriginales);
        procesador.imprimirLista("Lista original");
        procesador.ordenar();
        procesador.imprimirLista("Lista ordenada");
    }

}