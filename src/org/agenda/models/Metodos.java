package org.agenda.models;
import java.util.ArrayList;
import java.util.List;

public class Metodos {
    private int capacidadMaxima;
    private List<Agenda> contactos;

    public Metodos() {
        this(10);
    }

    public Metodos(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            System.out.println("La capacidad debe ser mayor a 0.");
        }
        this.capacidadMaxima = capacidadMaxima;
        this.contactos = new ArrayList<>();
    }

    public boolean añadirContacto(Agenda c) {
        if (contactos.size() >= capacidadMaxima) {
            System.out.println("La agenda está llena. No se puede añadir el contacto.");
            return false;
        }
        if (contactos.contains(c)) {
            System.out.println("Ya existe un contacto con ese nombre y apellido.");
            return false;
        }
        contactos.add(c);
        System.out.println("Contacto añadido correctamente.");
        return true;
    }

}
