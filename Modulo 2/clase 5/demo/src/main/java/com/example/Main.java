package com.example;

class Libro {

    private String titulo;
    private String autor;

    public Libro(String autor, String titulo) {
        this.autor = autor;
        this.titulo = titulo;
    }
    
    public void mostrarInformacion() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
    }
}

class Biblioteca {

    private String nombre;
    private Libro libro;

    public Biblioteca(String nombre, String tituloLibro, String autorLibro) {
        this.nombre = nombre;
        // La Biblioteca crea y es dueña de su propia instancia de Libro.
        this.libro = new Libro(autorLibro, tituloLibro);
    }

    public void mostrarBiblioteca() {
        System.out.println("Biblioteca: " + nombre);
        libro.mostrarInformacion();
    }
    
}


public class Main {
    public static void main(String[] args) {
        // Ahora, la Biblioteca se encarga de crear el libro internamente.
        Biblioteca biblioteca = new Biblioteca("La Biblioteca Nacional", "Cien años de soledad", "Gabriel García Márquez");
        biblioteca.mostrarBiblioteca();
    }
}