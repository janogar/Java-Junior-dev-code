package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de nombres que desea ingresar: ");
        int cantidad = sc.nextInt();

        String[] nombres = new String[cantidad];
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Ingrese el nombres " + (i + 1) + " de " + nombres.length + ": ");
            nombres[i] = sc.next();
        }

        System.out.println("Los nombres ingresados son: ");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i]);
        }
        sc.close();

    }
}