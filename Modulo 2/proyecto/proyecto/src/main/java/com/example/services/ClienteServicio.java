package com.example.services;

import java.util.ArrayList;
import java.util.List;
import com.example.models.Cliente;

/**
 * Servicio encargado de gestionar las operaciones del sistema de clientes.
 */
public class ClienteServicio implements GestionCliente {

    private List<Cliente> clientes;

    public ClienteServicio() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void registrarCliente(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Error: el cliente no puede ser nulo.");
            return;
        }

        if (buscarPorCorreo(cliente.getCorreo()) != null) {
            System.out.println("Error: ya existe un cliente con ese correo.");
            return;
        }

        clientes.add(cliente);
        System.out.println("Cliente registrado correctamente.");
    }

    @Override
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (Cliente cliente : clientes) {
            cliente.mostrarInformacion();
            System.out.println("----------------------");
        }
    }

    @Override
    public Cliente buscarPorCorreo(String correo) {
        for (Cliente cliente : clientes) {
            if (cliente.getCorreo().equalsIgnoreCase(correo)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void registrarAccion(String correo, String fecha, String descripcion) {
        Cliente cliente = buscarPorCorreo(correo);

        if (cliente == null) {
            System.out.println("No se encontró un cliente con ese correo.");
            return;
        }

        cliente.agregarAccion(fecha, descripcion);
        System.out.println("Acción registrada correctamente.");
    }
}
