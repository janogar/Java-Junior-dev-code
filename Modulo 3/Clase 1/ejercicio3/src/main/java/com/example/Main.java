package com.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Introduzca un numero entero: ");
    
        Scanner sc = new Scanner(System.in);
        String numero = sc.nextLine();
        try {
            int numeroInt = Integer.parseInt(numero);
            System.out.println("El numero ingresado es: " + numeroInt);
        } catch (InputMismatchException e) {
        System.out.println("ERROR: El valor ingresado no es un número entero válido.");
    }
}
}