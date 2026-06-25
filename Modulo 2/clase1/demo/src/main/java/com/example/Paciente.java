package com.example;

public class Paciente {

    //Atributos

    String nombre;
    int edad;
    String historialMedico;
    int documentoIdentidad;

    public Paciente(String nombre, int edad, String historialMedico, int documentoIdentidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.historialMedico = historialMedico;
        this.documentoIdentidad = documentoIdentidad;
    }


    

    public String getNombre() {
        return nombre;
    }




    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




    public int getEdad() {
        return edad;
    }




    public void setEdad(int edad) {
        this.edad = edad;
    }




    public String getHistorialMedico() {
        return historialMedico;
    }




    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }




    public int getDocumentoIdentidad() {
        return documentoIdentidad;
    }




    public void setDocumentoIdentidad(int documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }




    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}