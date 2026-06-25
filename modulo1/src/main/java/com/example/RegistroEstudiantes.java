package com.example;

import java.util.Scanner;

public class RegistroEstudiantes {

    static String[] nombres = new String[100];
    static int[] edades = new int[100];
    static double[] notas = new double[100];

    static int contador = 0;

    static Scanner entrada = new Scanner(System.in);

    public static void mostrarMenu() {
        System.out.println("/n=== Menu Principal ===");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Mostrar estudiante");
        System.out.println("3. Buscar estudiante");
        System.out.println("4. Promedio de notas");
        System.out.println("5. Salir del sistema");
    }

    public static void registrarEstudiante() {
        System.out.println("Por favor, ingrese el nombre del estudiante:");
        nombres[contador] = entrada.nextLine();

        System.out.println("Por favor, ingrese la edad del estudiante:");
        edades[contador] = entrada.nextInt();

        System.out.println("Por favor, ingrese la nota del estudiante:");
        notas[contador] = entrada.nextDouble();
        contador++;

        entrada.nextLine(); // Limpiar el buffer

        System.out.println("Estudiante registrado exitosamente.");
    }

    public static void mostrarEstudiantes() {

        System.out.println("=== Lista de Estudiantes ===");
        for (int i = 0; i < contador; i++) {
            System.out.println("Nombre: " + nombres[i] + ", Edad: " + edades[i] + ", Nota: " + notas[i]);
        }
    }

    public static void buscarEstudiante() {
        System.out.println("Nombre a buscar:");
        String nombreBuscado = entrada.nextLine();

        boolean encontrado = false;
        
        for (int i = 0; i < contador; i++) {
            if (nombres[i].equalsIgnoreCase(nombreBuscado)) {

                System.out.println("Estudiante encontrado:");
                System.out.println(nombres[i]);

                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Estudiante no encontrado.");
        }
    }

    public static void calcularPromedio() {
        double suma = 0;
        for (int i = 0; i < contador; i++) {
            suma += notas[i];
        }
        double promedio = suma / contador;
        System.out.println("El promedio de notas es: " + promedio);
    }
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = entrada.nextInt();
            entrada.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    mostrarEstudiantes();
                    break;
                case 3:
                    buscarEstudiante();
                    break;
                case 4:
                    calcularPromedio();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
    }       while (opcion != 5);
    }
}