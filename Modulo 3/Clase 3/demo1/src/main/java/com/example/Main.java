package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
    }

    public static void trabajarConArrayList() {
        System.out.println("Trabajar con ArrayList");

        List<String> estudiantes = new ArrayList<>();
        estudiantes.add("Juan");
        estudiantes.add("Maria");
        estudiantes.add("Pedro");

        System.out.println("Lista de estudiantes: ");
        System.out.println(estudiantes);
        
    }

}