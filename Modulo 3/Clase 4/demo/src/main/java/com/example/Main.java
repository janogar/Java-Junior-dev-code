package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> nombres = List.of("Ana", "Pedro", "Luis", "Arelis");

        System.out.println("lista original: ");
        System.out.println(String.join(",",nombres));
        
        System.out.println("*** inicio del pipeline (stream) ***");

        nombres.stream()
            .filter(nombre ->{
                System.out.println("/n [PASO 1 - FILTRO] Evaluando:" + nombre);
                boolean pasa = nombre.startsWith("A");
                System.out.println("    ¿Empieza con A: " + (pasa ? "SI (AVANZA)" : "NO (ELIMINADO)"));
                return pasa;
            })

            .map(nombre -> {
                String conversion = nombre.toUpperCase();
                System.out.println("/n [PASO 2 - MAP] Transformando: " + nombre + " -> " + conversion);
                return conversion;
            })
            
            .forEach(resultadoFinal -> {
                System.out.println("[PASO 3 - TERMINAL] Resultado impreso: " + resultadoFinal);
            });

            System.out.println("*** fin del pipeline (stream) ***");

    }
}