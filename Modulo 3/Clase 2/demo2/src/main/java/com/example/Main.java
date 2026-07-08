package com.example;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Bienvenido al programa de notas");

        int cantidad = solicitarCantidadNotas();

        double[] notas = crearArreglo(cantidad);

        ingresarNotas(notas);
        mostrarNotasForEach(notas);
        mostrarNotasFor(notas);
        double promedio = calcularPromedio(notas);
        double mayor = calcularMayor(notas);
        double menor = calcularMenor(notas);

        mostrarResultados(promedio, mayor, menor);

        sc.close();

    }

    public static int solicitarCantidadNotas() {
        
        System.out.println("Ingrese la cantidad de notas que desea ingresar: ");
        return sc.nextInt();
    }


    public static double[] crearArreglo(int cantidad) {
        return new double[cantidad];
    }

    public static void ingresarNotas(double[] notas) {
        System.out.println("Ingrese las notas: ");
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();
        }
    }

    public static void mostrarNotasForEach(double[] notas) {
        System.out.println("Las notas ingresadas For Each son: ");
        int contador = 1;
        for (double nota : notas) {
            System.out.println("calificación: " + contador + " de " + notas.length + ": " + nota);
            contador++;
        }
    }

    public static void mostrarNotasFor(double[] notas) {
        System.out.println("Las notas ingresadas son: ");
        for (int i = 0; i < notas.length; i++) {
            System.out.println("calificación: " + (i + 1) + " de " + notas.length + ": " + notas[i]);
        }
    }

    public static double calcularPromedio(double[] notas) {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }

    public static double calcularMayor(double[] notas) {
        double mayor = notas[0];
        for (double nota : notas) {
            if (nota > mayor) {
                mayor = nota;
            }
        }
        return mayor;
    }

    public static double calcularMenor(double[] notas) {
        double menor = notas[0];
        for (double nota : notas) {
            if (nota < menor) {
                menor = nota;
            }
        }
        return menor;
    }

    public static void mostrarResultados(double promedio, double mayor, double menor) {
        System.out.println("El promedio de las notas es: " + promedio);
        System.out.println("La nota mayor es: " + mayor);
        System.out.println("La nota menor es: " + menor);
    }
}

