package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.models.Cliente;


public class ClienteServicio implements GestionCliente {

    private List<Cliente> clientes;

    public ClienteServicio() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void registrarCliente(Cliente cliente) {
        if (cliente == null) {
            System.out.println("ERROR: No se puede registrar un cliente nulo.");
            return;
        }
        if (buscarPorCorreo(cliente.getCorreo()) != null) {
            System.out.println("ERROR: Ya existe un cliente con el correo " + cliente.getCorreo());
            return;
        }

        clientes.add(cliente);
        System.out.println("Cliente registrado exitosamente.");
    }

     @Override
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } 

        for (Cliente cliente : clientes) {
            cliente.mostrarInformacion();
            System.out.println("-------------------------");
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

        if (cliente != null) {
            System.out.println("El cliente no existe. No se puede registrar la acción.");
            return;
        }
        
        cliente.agregarAccion(fecha, descripcion);
        System.out.println("Acción registrada exitosamente.");
    }

    
    
}
