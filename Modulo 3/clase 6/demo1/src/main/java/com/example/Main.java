package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Producto {

    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", precio=" + precio + "]";
    }
} 

class Paciente {

    private String nombre;
    private String urgencia;

    public Paciente(String nombre, String urgencia) {
        this.nombre = nombre;
        this.urgencia = urgencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    
    

    

}

abstract class ProcesadorProducto {

    private List<Producto> elementos;

    public ProcesadorProducto(List<Producto> elementos) {

        this.elementos = new ArrayList<>(elementos);
    }

    public List<Producto> getElementos() {
        return elementos;
    }

    public void setElementos(List<Producto> elementos) {
        this.elementos = new ArrayList<>(elementos);
    }

    public abstract void ordenar();

    public void imprimirLista(String mensaje) {
        System.out.println(mensaje);
        for (Producto elemento : elementos) {
            System.out.println(elemento);
        }
    }
}

class OrdenadorTienda extends ProcesadorProducto {

    public OrdenadorTienda(List<Producto> productos) {
        super(productos);
    }

    @Override
    public void ordenar() {
        Collections.sort(getElementos(), Comparator.comparingDouble(Producto::getPrecio));
    }
}

abstract class ProcesadorPacientes {

    private List<Paciente> elementos;

    public ProcesadorPacientes(List<Paciente> elementos) {
        this.elementos = new ArrayList<>(elementos);
    }

    public List<Paciente> getElementos() {
        return elementos;
    }

    public void setElementos(List<Paciente> elementos) {
        this.elementos = elementos;
    }

    public abstract void ordenar();

    public void imprimirLista(String mensaje) {
        System.out.println(mensaje);
        for (Paciente elemento : elementos) {
            System.out.println(elemento);
        }
    }
}

class OrdenadorHospital extends ProcesadorPacientes {

    public OrdenadorHospital(List<Paciente> elementos) {
        super(elementos);
    }

    @Override
    public void ordenar() {
        Collections.sort(getElementos(), Comparator.comparing(Paciente::getUrgencia));
    }
}
public class Main {
    public static void main(String[] args) {

        // [PRUEBA MÓDULO 1]: Catálogo de la Tienda Virtual (Criterio Numérico)
        List<Producto> productosTienda = new ArrayList<>();
        productosTienda.add(new Producto("Teclado Mecánico RGB", 85.50));
        productosTienda.add(new Producto("Mouse Gamer Inalámbrico", 45.00));
        productosTienda.add(new Producto("Monitor Curvo 4K", 320.00));
        productosTienda.add(new Producto("Alfombrilla XL", 15.25));

        // Uso de Polimorfismo en la declaración (Tipo Padre -> Instancia Hijo)
        ProcesadorProducto sistemaTienda = new OrdenadorTienda(productosTienda);

        sistemaTienda.imprimirLista("Catálogo de Productos Original");
        sistemaTienda.ordenar(); // Ejecución del método polimórfico
        sistemaTienda.imprimirLista("Catálogo Ordenado por Precio (Menor a Mayor)");

        // [PRUEBA MÓDULO 2]: Admisión del Hospital (Criterio Alfabético / Texto)
        List<Paciente> listaPacientes = new ArrayList<>();
        listaPacientes.add(new Paciente("Juan Pérez", "C_Estable"));
        listaPacientes.add(new Paciente("María López", "A_Critico"));
        listaPacientes.add(new Paciente("Carlos Ruíz", "B_Urgente"));
        listaPacientes.add(new Paciente("Ana Gómez", "A_Critico"));

        // Uso de Polimorfismo en la declaración (Tipo Padre -> Instancia Hijo)
        ProcesadorPacientes sistemaHospital = new OrdenadorHospital(listaPacientes);

        sistemaHospital.imprimirLista("Fila de Espera de Pacientes Original");
        sistemaHospital.ordenar(); // Ejecución del método polimórfico
        sistemaHospital.imprimirLista("Fila de Espera Clasificada por Prioridad de Triage");
    }
}

