package com.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //crear el mapa de alumnos con sus notas
        Map<String, Double> alumnoNotas = new HashMap<>();

        //agregar tres alumnos con sus notas
        alumnoNotas.put("Jose", 7.5);
        alumnoNotas.put("Juan", 9.0);
        alumnoNotas.put("Juana", 10.0);

        //imprimir mapa
        System.out.println(alumnoNotas);

        //comprobar si un alumno especifico esta registrado
        if (alumnoNotas.containsKey("Juan")) {
            System.out.println("El alumno Juan Existe");
        } else {
            System.out.println("el alumno juan no existe");
        }

        //actualizar la nota de uno de los alumnos

        alumnoNotas.put("Juana", 5.7);
        System.out.println("se elimino juana del registro");
        System.out.println(alumnoNotas);

        //eliminar alumno

        alumnoNotas.remove("Jose");

        //imprimir toda la lista
        System.out.println(alumnoNotas);



    }
}