package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ingrese su edad en texto: ");
        Scanner sc = new Scanner(System.in);
        String edad = sc.nextLine();
        try {
            int edadInt = Integer.parseInt(edad);
            System.out.println("Su edad es: " + edadInt);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: La edad ingresada no es un número válido.");
        }
        System.out.println("Programa finalizado.");
    }
}