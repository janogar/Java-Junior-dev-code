package com.example;

public class Main {
    public static void main(String[] args) {
        String edad = null;
        try {
            edad.length();
        } catch (NullPointerException e) {
            System.out.println("ERROR: La edad ingresada es nula.");    
        }
        System.out.println("Programa finalizado.");
    
    }
}