package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
        FileReader file = new FileReader("archivo_que_no_existe.txt");
        BufferedReader br = new BufferedReader(file);
        System.out.println(br.readLine());
        br.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: El archivo no existe.");
        } catch (IOException e) {
            System.out.println("ERROR: No se pudo leer el archivo.");
        }
        System.out.println("Programa finalizado.");
    }
}