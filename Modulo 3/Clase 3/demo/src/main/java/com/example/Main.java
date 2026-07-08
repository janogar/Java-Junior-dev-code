package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>(); //acceso rapido, pero la insercion y remocion es mas costosa
        List<String> lista2 = new LinkedList<>(); //acceso mas lento, pero la insercion y remocion es mas rapida
        Set<String> set1 = new HashSet<>(); //no permite elementos duplicados, no mantiene el orden de insercion
        Set<String> set2 = new TreeSet<>();  //no permite elementos duplicados, mantiene el orden natural de los elementos
        Set<String> set3 = new LinkedHashSet<>(); //no permite elementos duplicados, mantiene el orden de insercion
        Map<String, String> registro = new HashMap<>(); //no permite claves duplicadas, no mantiene el orden de insercion
        Map<String, Integer> agendaTelefonica = new LinkedHashMap<>(); //no permite claves duplicadas, mantiene el orden de insercion
        Map<String, String> registro2 = new TreeMap<>(); //no permite claves duplicadas, mantiene el orden natural de las claves
        Map<String, String> registro3 = new Hashtable<>(); //no permite claves duplicadas, no mantiene el orden de insercion, es sincronizado
    }
}