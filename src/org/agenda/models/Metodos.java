package org.agenda.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Metodos {
    private int capacidadMaxima;
    private List<Agenda> contactos;

    public Metodos() {
        this(10);
    }

    public Metodos(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            System.out.println("La capacidad debe ser mayor a 0.");
            capacidadMaxima = 10;
        }
        this.capacidadMaxima = capacidadMaxima;
        this.contactos = new ArrayList<>();
    }

    public boolean añadirContacto(Agenda c) {
        if (contactos.size() >= capacidadMaxima) {
            System.out.println("La agenda está llena. No se puede añadir el contacto.");
            return false;
        }
        if (existeContacto(c.getNombre(), c.getApellido())) {
            System.out.println("Ya existe un contacto con ese nombre y apellido.");
            return false;
        }
        contactos.add(c);
        System.out.println("Contacto añadido correctamente.");
        return true;
    }
    public boolean existeContacto(String nombre, String apellido) {
        for (Agenda contacto : contactos) {
            boolean mismoNombre = contacto.getNombre().equalsIgnoreCase(nombre);
            boolean mismoApellido = contacto.getApellido().equalsIgnoreCase(apellido);
            if (mismoNombre && mismoApellido) {
                return true;
            }
        }
        return false;
    }

    public void buscarYMostrarContacto(String nombre, String apellido) {
        for (Agenda contacto : contactos) {
            boolean mismoNombre = contacto.getNombre().equalsIgnoreCase(nombre);
            boolean mismoApellido = contacto.getApellido().equalsIgnoreCase(apellido);
            if (mismoNombre && mismoApellido) {
                System.out.println("¡El contacto existe en la agenda!");
                contacto.showDetails();
                return;
            }
        }
        System.out.println("El contacto " + nombre + " " + apellido + " NO existe en la agenda.");
    }
    public List<Agenda> getContactos() {
        return contactos;
    }
}
