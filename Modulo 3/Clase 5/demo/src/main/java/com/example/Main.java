package com.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] numeros = {45, 12, 78, 3, 20};

        System.out.println("Lista original: ");
        System.out.println(Arrays.toString(numeros));

        for (int pasadaLista = 0; pasadaLista < numeros.length - 1; pasadaLista++) { //ciclo que controla la cantidad de pasadas
            for(int indiceComparacionVecino = 0; indiceComparacionVecino < numeros.length - 1
                 - pasadaLista; indiceComparacionVecino++){ //comparar el elemento anterior con su vecino posterior
                    if (numeros[indiceComparacionVecino] > numeros[indiceComparacionVecino + 1]) {
                        int auxiliar = numeros[indiceComparacionVecino];
                        numeros[indiceComparacionVecino] = numeros[indiceComparacionVecino + 1];
                        numeros[indiceComparacionVecino + 1] = auxiliar;
                    }
            }
        }
        System.out.println("lista ordenada: ");
        System.out.println(Arrays.toString(numeros));
    }
}