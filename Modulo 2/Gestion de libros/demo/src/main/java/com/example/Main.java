package com.example;

class Libro {

    // Atributos del libro
    private String titulo;
    private String autor;
    private String isbn;
    private double precio;
    private int anioPublicacion;
    private String cubierta;

    // Constructor para inicializar el libro
    public Libro(String titulo, String autor, String isbn, double precio, int anioPublicacion, String cubierta) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.precio = precio;
        this.anioPublicacion = anioPublicacion;
        this.cubierta = cubierta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getCubierta() {
        return cubierta;
    }

    public void setCubierta(String cubierta) {
        this.cubierta = cubierta;
    }
    
    public void mostrarInformacion() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + isbn);
        System.out.println("Precio: $" + precio);
        System.out.println("Año de Publicación: " + anioPublicacion);
        System.out.println("Cubierta: " + cubierta);
    }

    
}

public class Main {
    public static void main(String[] args) {
        // Crear un libro de ejemplo
        Libro libro1 = new Libro("100 Años de Soledad", "Gabriel García Márquez", "978-3-16-148410-0", 19.99, 1967, "Tapa dura");

        Libro libro2 = new Libro("El Principito", "Antoine de Saint-Exupéry", "978-3-16-148410-1", 14.99, 1943, "Tapa blanda");
        // Mostrar la información del libro
        libro1.mostrarInformacion();
    }
}