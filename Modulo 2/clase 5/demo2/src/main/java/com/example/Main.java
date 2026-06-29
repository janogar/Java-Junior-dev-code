package com.example;

class Profesor {
    private String nombre;
    private String profesion;

    public Profesor(String nombre, String profesion) {
        this.nombre = nombre;
        this.profesion = profesion;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Profesión: " + profesion);
    }
}

class Universidad {
    private String nombre;
    private Profesor profesor;

    public Universidad(String nombre, Profesor profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public void mostrarUniversidad() {
        System.out.println("Universidad: " + nombre);
        profesor.mostrarInformacion();
    }
}

public class Main {
    public static void main(String[] args) {
        Profesor profesor = new Profesor("Juan Pérez", "Matemáticas");
        Universidad universidad = new Universidad("Universidad Nacional", profesor);
        universidad.mostrarUniversidad();
    }
}