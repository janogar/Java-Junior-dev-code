package com.example.app;

import java.util.Scanner;
import com.example.models.Cliente;
import com.example.models.ClienteBasico;
import com.example.models.ClientePremium;
import com.example.models.ClienteEmpresarial;
import com.example.services.ClienteServicio;

/**
 * Clase principal del sistema de gestión de clientes.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ClienteServicio servicio = new ClienteServicio();

        int opcion = 0;
        int contadorId = 1;

        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE CLIENTES ===");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente por correo");
            System.out.println("4. Registrar acción en historial");
            System.out.println("5. Mostrar historial de cliente");
            System.out.println("6. Calcular descuento");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Correo: ");
                        String correo = scanner.nextLine();

                        if (nombre.isBlank() || correo.isBlank()) {
                            System.out.println("Error: nombre y correo son obligatorios.");
                            break;
                        }

                        System.out.println("Tipo de cliente:");
                        System.out.println("1. Básico");
                        System.out.println("2. Premium");
                        System.out.println("3. Empresarial");
                        System.out.print("Seleccione tipo: ");
                        int tipo = Integer.parseInt(scanner.nextLine());

                        Cliente cliente;

                        if (tipo == 1) {
                            cliente = new ClienteBasico(contadorId, nombre, correo);
                        } else if (tipo == 2) {
                            cliente = new ClientePremium(contadorId, nombre, correo);
                        } else if (tipo == 3) {
                            cliente = new ClienteEmpresarial(contadorId, nombre, correo);
                        } else {
                            System.out.println("Tipo de cliente inválido.");
                            break;
                        }

                        servicio.registrarCliente(cliente);
                        contadorId++;
                        break;

                    case 2:
                        servicio.listarClientes();
                        break;

                    case 3:
                        System.out.print("Ingrese correo a buscar: ");
                        String correoBusqueda = scanner.nextLine();

                        Cliente encontrado = servicio.buscarPorCorreo(correoBusqueda);

                        if (encontrado != null) {
                            encontrado.mostrarInformacion();
                        } else {
                            System.out.println("Cliente no encontrado.");
                        }
                        break;

                    case 4:
                        System.out.print("Correo del cliente: ");
                        String correoAccion = scanner.nextLine();

                        System.out.print("Fecha: ");
                        String fecha = scanner.nextLine();

                        System.out.print("Descripción de la acción: ");
                        String descripcion = scanner.nextLine();

                        if (descripcion.isBlank()) {
                            System.out.println("Error: la descripción no puede estar vacía.");
                            break;
                        }

                        servicio.registrarAccion(correoAccion, fecha, descripcion);
                        break;

                    case 5:
                        System.out.print("Correo del cliente: ");
                        String correoHistorial = scanner.nextLine();

                        Cliente clienteHistorial = servicio.buscarPorCorreo(correoHistorial);

                        if (clienteHistorial != null) {
                            clienteHistorial.mostrarHistorial();
                        } else {
                            System.out.println("Cliente no encontrado.");
                        }
                        break;

                    case 6:
                        System.out.print("Correo del cliente: ");
                        String correoDescuento = scanner.nextLine();

                        Cliente clienteDescuento = servicio.buscarPorCorreo(correoDescuento);

                        if (clienteDescuento == null) {
                            System.out.println("Cliente no encontrado.");
                            break;
                        }

                        System.out.print("Valor de la compra: ");
                        double valorCompra = Double.parseDouble(scanner.nextLine());

                        if (valorCompra <= 0) {
                            System.out.println("Error: el valor debe ser mayor que cero.");
                            break;
                        }

                        double descuento = clienteDescuento.calcularDescuento(valorCompra);
                        double total = valorCompra - descuento;

                        System.out.println("Tipo de cliente: " + clienteDescuento.obtenerTipoCliente());
                        System.out.println("Valor compra: $" + valorCompra);
                        System.out.println("Descuento: $" + descuento);
                        System.out.println("Total a pagar: $" + total);
                        break;

                    case 7:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número válido.");
            }

        } while (opcion != 7);

        scanner.close();
    }
}
