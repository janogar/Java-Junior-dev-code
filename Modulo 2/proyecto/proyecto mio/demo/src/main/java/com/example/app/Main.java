package com.example.app;

import java.util.Scanner;

import com.example.models.Cliente;
import com.example.models.ClienteBasico;
import com.example.models.ClienteEmpresarial;
import com.example.models.ClientePremium;
import com.example.service.ClienteServicio;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteServicio servicio = new ClienteServicio();

        int opcion = 0;
        int contadorId = 1;

        do { 
            System.out.println("*** Bienvenido a esta SUPER Aplicacion de mis estudiantes de Java ***");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente por correo");
            System.out.println("4. Registrar acción para un cliente");
            System.out.println("5. Mostrar historial del cliente");
            System.out.println("6. Calcular descuento para un cliente");
            System.out.println("7. Salir");

            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre del cliente: ");
                        String nombre = scanner.nextLine();

                        System.out.println("Correo del cliente: ");
                        String correo = scanner.nextLine();

                        if (nombre.isBlank() || correo.isBlank()) {
                            System.out.println("ERROR: El nombre y el correo no pueden estar vacíos.");
                            break;
                        }

                        System.out.println("Tipo de cliente: ");
                        System.out.println("1. Cliente Básico");
                        System.out.println("2. Cliente Premium");
                        System.out.println("3. Cliente Empresarial");
                        System.out.println("Seleccione el tipo de cliente: ");
                        int tipoCliente = Integer.parseInt(scanner.nextLine());

                        Cliente cliente;

                        if (tipoCliente == 1) {
                            cliente = new ClienteBasico(contadorId, nombre, correo);
                        } else if (tipoCliente == 2) {
                            cliente = new ClientePremium(contadorId, nombre, correo);
                        } else if (tipoCliente == 3) {
                            cliente = new ClienteEmpresarial(contadorId, nombre, correo);
                        } else {
                            System.out.println("ERROR: Tipo de cliente inválido.");
                            break;
                        }

                        servicio.registrarCliente(cliente);
                        contadorId++;
                        break;


                    case 2:
                        servicio.listarClientes();
                        break;

                    case 3:
                        System.out.print("Ingrese el correo del cliente a buscar: ");
                        String correoBusqueda = scanner.nextLine();
                        Cliente clienteEncontrado = servicio.buscarPorCorreo(correoBusqueda);
                        if (clienteEncontrado != null) {
                            clienteEncontrado.mostrarInformacion();
                        } else {
                            System.out.println("ERROR: Cliente no encontrado.");
                        }

                    case 4:
                        System.out.println("Ingrese el correo del cliente para registrar una acción: ");
                        String correoAccion = scanner.nextLine();

                        System.out.println("Fecha:");
                        String fecha = scanner.nextLine();

                        System.out.println("Descripción de la acción del cliente: ");
                        String descripcion = scanner.nextLine();


                        if (descripcion.isBlank()) {
                            System.out.println("ERROR: La descripción no pueden estar vacías.");
                        }

                        servicio.registrarAccion(correoAccion, fecha, descripcion);
                        break;

                    case 5:
                        System.out.println("Ingrese el correo del cliente para mostrar su historial: ");
                        String correoHistorial = scanner.nextLine();
                        
                        Cliente clienteHistorial = servicio.buscarPorCorreo(correoHistorial);
                        if (clienteHistorial != null) {
                            clienteHistorial.mostrarHistorial();
                        } else {
                            System.out.println("ERROR: Cliente no existe.");
                        }
                        break;

                    case 6:
                        System.out.println("Ingrese el correo del cliente para calcular su descuento: ");
                        String correoDescuento = scanner.nextLine();

                        Cliente clienteDescuento = servicio.buscarPorCorreo(correoDescuento);
                        
                        if (clienteDescuento == null) {
                            System.out.println("ERROR: Cliente no existe.");
                            break;
                        }

                        System.out.println("ingrese el monto de la compra: ");
                        double montoCompra = Double.parseDouble(scanner.nextLine());

                        if (montoCompra <= 0) {
                            System.out.println("ERROR: El monto de la compra debe ser mayor a 0.");
                            break;
                        }

                        double descuento = clienteDescuento.calcularDescuento(montoCompra);
                        double montoFinal = montoCompra - descuento;
                        System.out.println("tipo de cliente: " + clienteDescuento.obtenerTipoCliente());
                        System.out.println("Monto de la compra: " + montoCompra);
                        System.out.println("Descuento: " + descuento);
                        System.out.println("Monto final: " + montoFinal);

                        break;

                    case 7:
                        System.out.println("Saliendo de la aplicación...");
                        break;

                    default:
                        System.out.println("ERROR: Opción inválida. Por favor, seleccione una opción válida.");
                        break;
                } 

            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingrese un número válido.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}