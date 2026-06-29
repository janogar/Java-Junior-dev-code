package com.example;

import java.util.ArrayList;

interface Trabajable {
    void trabajar();
}

abstract class Persona {

     protected String nombre;
     protected String documento;

     public Persona(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
     }

     public abstract void mostrarRol();
     
     public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Documento: " + documento);
     }
}

abstract class Empleado extends Persona implements Trabajable {

    protected double salario;

    public Empleado(String nombre, String documento, double salario) {
        super(nombre, documento);
        this.salario = salario;
    }
    
    public void mostrarSalario() {
        System.out.println("Salario: " + salario);
    }
}

class Mesero extends Empleado {

    private int numeroMesas;

    public Mesero(String nombre, String documento, double salario, int numeroMesas) {
        super(nombre, documento, salario);
        this.numeroMesas = numeroMesas;
    }

    @Override
    public void trabajar() {
        System.out.println(nombre + "atiende" + numeroMesas + "mesas");
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Mesero");
    }

}

class Cocinero extends Empleado {

    private String especialidad;

    public Cocinero(String nombre, String documento, double salario, String especialidad) {
        super(nombre, documento, salario);
        this.especialidad = especialidad;
    }

    @Override
    public void trabajar() {
        System.out.println(nombre + "cocinando" + especialidad + ".");
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Cocinero");
    }

}

class Cliente extends Persona {

    private String telefono;

    public Cliente(String nombre, String documento, String telefono) {
        super(nombre, documento);
        this.telefono = telefono;
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Cliente");
    }

    public void mostrarTelefono() {
        System.out.println("Telefono: " + telefono);
    }

}

class DetallePedido {
    
    private String producto;
    private int cantidad;
    private double precioUnitario;

    public DetallePedido(String producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }

    public void mostrarDetalle() {
        System.out.println(producto + 
            " | Cantidad: " + cantidad + 
            " | Precio Unitario: " + precioUnitario + 
            " | Subtotal: " + calcularSubtotal());
    }


}

class Pedido {

    private int nummeroPedido;
    private Cliente cliente;
    private ArrayList<DetallePedido> detalles;

    public Pedido(int nummeroPedido, Cliente cliente, ArrayList<DetallePedido> detalles) {
        this.nummeroPedido = nummeroPedido;
        this.cliente = cliente;
        this.detalles = detalles;
    }

    public Pedido(int nummeroPedido, Cliente cliente) {
        this.nummeroPedido = nummeroPedido;
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
    }

    public void agregarDetalle(DetallePedido detalle) {
        detalles.add(detalle);
    }

    public double calcularTotal() {

        double total = 0;

        for (DetallePedido detalle : detalles) {
            total += detalle.calcularSubtotal();
        }
        return total;
    }
    
    public void mostrarPedido() {
        System.out.println("Numero de pedido: " + nummeroPedido);
        System.out.println("Cliente: " + cliente.nombre);
        
        for (DetallePedido detalle : detalles) {
            detalle.mostrarDetalle();
        }

        System.out.println("Total: " + calcularTotal());
    }


}

class Restaurante {

    private String nombre;
    private ArrayList<Empleado> empleados;
    private ArrayList<Pedido> pedidos;

    public Restaurante(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void mostrarEmpleados() {
        System.out.println("Empleados del restaurante " + nombre + ":");
        for (Empleado empleado : empleados) {
            empleado.mostrarInformacion();
            empleado.mostrarRol();
            empleado.mostrarSalario();
            System.out.println();
        }
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void mostrarPedidos() {
        System.out.println("Pedidos del restaurante " + nombre + ":");

        for (Pedido pedido : pedidos) {
            pedido.mostrarPedido();
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        
        Restaurante restaurante = new Restaurante("Arepas Jaliscos");

        Mesero mesero1 = new Mesero("Juan", "123456789", 1200.0, 2);
        Cocinero cocinero1 = new Cocinero("Maria", "987654321", 1500.0, "Carnes");

        restaurante.agregarEmpleado(mesero1);
        restaurante.agregarEmpleado(cocinero1);

        Cliente cliente1 = new Cliente("Ana", "987654321", "1234567");

        Pedido pedido1 = new Pedido(1, cliente1);

        pedido1.agregarDetalle(new DetallePedido("Tacos arracheros", 5, 500));
        pedido1.agregarDetalle(new DetallePedido("Cantarito", 1, 1000));
        pedido1.agregarDetalle(new DetallePedido("Doritos", 5, 30));
        pedido1.agregarDetalle(new DetallePedido("hot dogs", 5, 100));

    restaurante.agregarPedido(pedido1);

    restaurante.mostrarEmpleados();
    restaurante.mostrarPedidos();

    }
}