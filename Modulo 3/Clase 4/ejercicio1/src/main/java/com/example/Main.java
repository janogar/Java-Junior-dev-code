package com.example;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        //guardar el nombre de una fruta y su cantidad disponible

        //crear el mapa
        Map<String, Integer> inventarioFrutas = new HashMap<>();

        inventarioFrutas.put("manzana", 10);
        inventarioFrutas.put("banana", 5);
        inventarioFrutas.put("naranja", 8);

        //imprimir el mapa
        System.out.println("Inventario de frutas:");
        System.out.println(inventarioFrutas);

        //buscar la cantidad de una fruta especifica
            System.out.println("Cantidad de bananas disponibles: " + inventarioFrutas.get("banana"));

        //modificar la cantidad de una fruta
            inventarioFrutas.put("manzana", 15);

        //imprimir el mapa actualizado
            System.out.println("Inventario de frutas actualizado:");
            System.out.println(inventarioFrutas);
        
        //eliminar una fruta del mapa
            inventarioFrutas.remove("naranja");
            
        //imprimir todo el mapa
            System.out.println("inventario completo: ");
            System.out.println(inventarioFrutas);

        
    }
}