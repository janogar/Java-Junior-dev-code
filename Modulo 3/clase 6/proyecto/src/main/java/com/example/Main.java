package com.example;

import java.util.ArrayList;
import java.util.List;

class Libro {

    private String titulo;
    private int numeroPaginas;

    public Libro(String titulo, int numeroPaginas) {
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String toString() {
        return "El libro con el título '" + titulo + "' tiene " + numeroPaginas + " páginas.";
    }
}

abstract class ProcesadorLibros {

    protected List<Libro> libros;

    //constructor que reciba una lista de libros y cree una copia de la lista
    public ProcesadorLibros(List<Libro> libros) {
        this.libros = new ArrayList<>(libros);
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = new ArrayList<>(libros);
    }

    abstract void ordenar();

    public void imprimirLista(String mensaje) {
        System.out.println(mensaje);
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

}

class OrdenadorBiblioteca extends ProcesadorLibros {

    public OrdenadorBiblioteca(List<Libro> libros) {
        super(libros);
    }

    //sobreescribir el metodo ordenar
    @Override
    public void ordenar() {
        libros.sort((l1, l2) -> Integer.compare(l1.getNumeroPaginas(), l2.getNumeroPaginas()));
    }

}

class paquete {

    private String codigo;
    private String prioridad;

    //la prioridad debera representarse mediante textos que permitan su ordenamiento alfabetico, por ejemplo: A express B prioritario c estandar
    public paquete(String codigo, String prioridad) {
        this.codigo = codigo;
        this.prioridad = prioridad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "El paquete con código " + codigo + " tiene prioridad " + prioridad;
    }
}

abstract class ProcesadorPaquetes {

    protected List<paquete> paquetes;

    //constructor
    public ProcesadorPaquetes(List<paquete> paquetes) {
        this.paquetes = new ArrayList<>(paquetes);
    }

    public List<paquete> getPaquetes() {
        return paquetes;
    }

    //setter
    public void setPaquetes(List<paquete> paquetes) {
        this.paquetes = new ArrayList<>(paquetes);
    }

    abstract void ordenar();

    public void imprimirLista(String mensaje) {
        System.out.println(mensaje);
        for (paquete paquete : paquetes) {
            System.out.println(paquete);
        }
    }

}

class OrdenadorMensajeria extends ProcesadorPaquetes {

    public OrdenadorMensajeria(List<paquete> paquetes) {
        super(paquetes);
    }

    //sobreescribir el metodo ordenar
    @Override
    public void ordenar() {
        paquetes.sort((p1, p2) -> {
            int prioridadComparacion = p1.getPrioridad().compareTo(p2.getPrioridad());
            if (prioridadComparacion != 0) {
                return prioridadComparacion;
            } else {
                return p1.getCodigo().compareTo(p2.getCodigo());
            }
        });
    }

}




public class Main {

    public static void main(String[] args) {
        // --- 1. PRUEBA CON LIBROS ---
        List<Libro> libros = new ArrayList<>();
        libros.add(new Libro("El Quijote", 1000));
        libros.add(new Libro("El Principito", 96));
        libros.add(new Libro("Cien Años de Soledad", 417));

        OrdenadorBiblioteca ordenadorLibros = new OrdenadorBiblioteca(libros);
        ordenadorLibros.imprimirLista("--- Libros Sin Ordenar ---");
        
        ordenadorLibros.ordenar();
        ordenadorLibros.imprimirLista("\n--- Libros Ordenados por Páginas ---");

        System.out.println("\n-----------------------------------\n");

        // --- 2. PRUEBA CON PAQUETES ---
        List<paquete> paquetes = new ArrayList<>();
        paquetes.add(new paquete("PKG-003", "C estándar"));
        paquetes.add(new paquete("PKG-001", "A express"));
        paquetes.add(new paquete("PKG-002", "A express"));
        paquetes.add(new paquete("PKG-004", "B prioritario"));

        OrdenadorMensajeria ordenadorPaquetes = new OrdenadorMensajeria(paquetes);
        ordenadorPaquetes.imprimirLista("--- Paquetes Sin Ordenar ---");

        ordenadorPaquetes.ordenar();
        ordenadorPaquetes.imprimirLista("\n--- Paquetes Ordenados por Prioridad y Código ---");
    }
}