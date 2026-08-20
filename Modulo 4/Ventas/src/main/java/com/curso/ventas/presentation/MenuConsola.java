package com.curso.ventas.presentation;

import com.curso.ventas.model.Producto;
import com.curso.ventas.service.ProductoService;
import com.curso.ventas.model.ResultadoVenta;

import java.util.Scanner;

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

}
