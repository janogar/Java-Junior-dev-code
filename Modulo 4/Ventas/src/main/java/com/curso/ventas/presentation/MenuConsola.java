package com.curso.ventas.presentation;

import java.util.Scanner;

import com.curso.ventas.model.Producto;
import com.curso.ventas.model.ResultadoVenta;
import com.curso.ventas.service.ProductoService;

public class MenuConsola {

    private final Scanner scanner;
    private final ProductoService Service;

    public MenuConsola(ProductoService service) {
        this.scanner = new Scanner(System.in);
        this.Service = service;
    }
    
    public void iniciar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> listarProductos();
                case 3 -> buscarProducto();
                case 4 -> actualizarProducto();
                case 5 -> eliminarProducto();
                case 6 -> realizarVenta();
                case 0 -> System.out.println("\n ¡Muchas gracias por usar el sistema de ventas!");
                default -> System.out.println("\n Opción inválida. Por favor, elige una opción válida.");
            }
        } while (opcion != 0);

        scanner.close(); 

    }

    private void mostrarMenu() {
        System.out.println("\n--- Menú de Gestión de Ventas ---");
        System.out.println("1. Agregar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Buscar producto");
        System.out.println("4. Actualizar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Realizar venta");
        System.out.println("0. Salir");
    }

    private void agregarProducto() {
        System.out.println("\n--- Agregar Producto ---");
        String nombre = leerTexto("Nombre del producto: ");
        double precio = leerDecimal("Precio del producto: ");
        int stock = leerEntero("Cantidad en stock: ");

        String resultado = Service.agregarProducto(nombre, precio, stock);
        if (resultado.equals("OK")) {
            System.out.println("\nProducto agregado exitosamente.");
        } else {
            System.out.println(resultado);
        }
    }

    private void listarProductos() {
        System.out.println("\n--- Lista de Productos ---");

        if (Service.estaVacio()) {
            System.out.println("No hay productos disponibles.");
            return;
        }

        for (Producto producto : Service.listarProductos()) {
            System.out.println(producto);
        }

        System.out.println("Total: " + Service.cantidadProductos() + " productos.");
    }

    private void buscarProducto() {
        System.out.println("\n--- Buscar Producto ---");
        int id = leerEntero("ID del producto a buscar: ");

        Producto producto = Service.buscarProducto(id);

        if (producto != null) {
            System.out.println("Producto encontrado:");
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void actualizarProducto() {
        System.out.println("\n--- Actualizar Producto ---");
        int id = leerEntero("ID del producto a actualizar: ");

        Producto actual = Service.buscarProducto(id);
        if (actual == null) {
            System.out.println("Producto no encontrado con el ID proporcionado.");
            return;
        }

        System.out.println("Producto actual: " + actual);
        String nombre = leerTexto("Nuevo nombre del producto: ");
        double precio = leerDecimal("Nuevo precio del producto: ");
        int stock = leerEntero("Nueva cantidad en stock: ");

        String resultado1 = Service.actualizarProducto(id, nombre, precio, stock);
        if (resultado1.equals("OK")) {
            System.out.println("Producto actualizado exitosamente.");
        } else {
            System.out.println(resultado1);
        }
    }

    private void eliminarProducto() {
        System.out.println("\n--- Eliminar Producto ---");
        int id = leerEntero("ID del producto a eliminar: ");

        Producto producto = Service.buscarProducto(id);
        if (producto == null) {
            System.out.println("Producto no encontrado con el ID proporcionado.");
            return;
        }

        System.out.println("Producto a eliminar: " + producto);
        String confirmar = leerTexto("¿Estás seguro de que deseas eliminar este producto? (s/n): ");
        if (!confirmar.equalsIgnoreCase("s")) {
            System.out.println("Operación cancelada.");
            return;
        }

        String resultado = Service.eliminarProducto(id);
        if (resultado.equals("OK")) {
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println(resultado);
        }
    }

    private void realizarVenta() {
        System.out.println("\n --- Realizar Venta ---");

        if (Service.estaVacio()) {
            System.out.println("No hay productos disponibles para la venta.");
            return;
        }

        listarProductos();
        int id = leerEntero("ID del producto a vender: ");
        Producto producto = Service.buscarProducto(id);
        if (producto == null) {
            System.out.println("Producto no encontrado con el ID proporcionado.");
            return;
        }

        System.out.println("Producto seleccionado: " + producto);
        int cantidad = leerEntero("Cantidad a vender: ");

        ResultadoVenta resultado = Service.venderProducto(id, cantidad);
        System.out.println(resultado.getMensaje());
        if (resultado.isExitoso()) {
            System.out.println("Total de la venta: $" + String.format("%.2f", resultado.getTotal()));
            System.out.println("Stock restante del producto: " + producto.getStock());
        }
    }

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número entero válido.");
            }
        }
    }

    private double leerDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número decimal válido.");
            }
        }
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }


}
