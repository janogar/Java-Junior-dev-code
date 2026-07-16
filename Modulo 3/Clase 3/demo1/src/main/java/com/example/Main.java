package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        
        //trabajarConArrayList();

        //trabajarConLinkedList();

       // trabajarConHashSet();

        trabajarConTreeSet();
    }

    public static void trabajarConArrayList() {
        System.out.println("Trabajar con ArrayList");

        List<String> estudiantes = new ArrayList<>();
        estudiantes.add("Juan");
        estudiantes.add("Maria");
        estudiantes.add("Pedro");
        estudiantes.add("Ana");


        System.out.println("Lista de estudiantes: ");
        System.out.println(estudiantes);
        
        System.out.println("Primer estudiante: " + estudiantes.get(0));
        estudiantes.set(1, "Luis");
        System.out.println("Nueva Lista: ");
        System.out.println(estudiantes);

        System.out.println("Eliminar un estudiante: ");
        estudiantes.remove("Pedro");
        System.out.println("Elementos restantes luego de eliminar pedro: ");
        System.out.println(estudiantes);
    
        System.out.println("Cantidad de estudiantes restantes en la lista: " + estudiantes.size());
        System.out.println("En la lista se encuentra Maria? " + estudiantes.contains("Luis"));
    }

    public static void trabajarConLinkedList() {
        System.out.println("Trabajar con LinkedList");

        LinkedList<String> turnos = new LinkedList<>();

        turnos.add("Turno 1");
        turnos.add("Turno 2");
        turnos.add("Turno 3");

        System.out.println("Turnos iniciales:");
        System.out.println(turnos);

        turnos.addFirst("Turno urgente");
        turnos.addLast("Turno final");

        System.out.println("Turnos luego de actualizar");
        System.out.println(turnos);

        System.out.println("Primer turno: " + turnos.getFirst());
        System.out.println("Ultimo turno: " + turnos.getLast());

        turnos.removeFirst();
        turnos.removeLast();

        System.out.println("Despues de llamar inicio y final:");
        System.out.println(turnos);

    }

    public static void trabajarConHashSet() {
        System.out.println("Trabajar con HashSet");

        HashSet<String> correos = new HashSet<>();

        correos.add("Luis@gmail.com");
        correos.add("Maria@gmail.com");
        correos.add("Juan@gmail.com");
        correos.add("Ana@gmail.com");

        System.out.println("Lista de correos: ");
        System.out.println(correos);

        System.out.println("Cantidad de correos registrados: " + correos.size());

        System.out.println("Se encuentra registrado el correo de Juan? " + correos.contains("Juan@gmail.com"));

        correos.remove("Juan@gmail.com");
        System.out.println("Registros luego de eliminar el correo de Juan: ");
        System.out.println(correos);


    }

    public static void trabajarConTreeSet() {
    
        System.out.println("Trabajar con TreeSet");
    
        TreeSet<Integer> notas = new TreeSet<>();

        notas.add(5);
        notas.add(8);
        notas.add(10);
        notas.add(3);
        notas.add(7);
    
        System.out.println("Notas ordenadas sin duplicados: ");
        System.out.println(notas);
    
        System.out.println("Nota mas baja: " + notas.first());
        System.out.println("Nota mas alta: " + notas.last());
    
        System.out.println("Notas menores a 4: " + notas.lower(4));
        System.out.println("Notas mayores a 4: " + notas.higher(4));

        notas.remove(5);
        System.out.println("Notas luego de eliminar la nota 5: ");
        System.out.println(notas);
    }
}