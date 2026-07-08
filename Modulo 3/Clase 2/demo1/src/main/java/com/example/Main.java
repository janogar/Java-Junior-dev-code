package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de edades que desea ingresar: ");
        int cantidad = sc.nextInt();

        int[] edades = new int[cantidad];
        for (int i = 0; i < edades.length; i++) {
            System.out.println("Ingrese la edad " + (i + 1) + " de " + edades.length + ": ");
            edades[i] = sc.nextInt();
        }

        System.out.println("Las edades ingresadas son: ");
        for (int edad : edades) {
            System.out.println(edad);
        }
        sc.close();



    }
}