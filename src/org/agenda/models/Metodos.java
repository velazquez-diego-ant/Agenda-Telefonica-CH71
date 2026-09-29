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
    // 3. Listar contactos ordenados
    public void listarContactosOrdenados() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }

        // Creamos una copia para no alterar la lista original
        java.util.List<Agenda> ordenados = new java.util.ArrayList<>(contactos);
        java.util.Collections.sort(ordenados); // Usa el compareTo de la clase Agenda

        System.out.println("\n--- LISTA DE CONTACTOS ---");
        System.out.println("Nombre | Apellido | Teléfono");
        System.out.println("-------------------------------");
        for (Agenda contacto : ordenados) {
            contacto.showDetails();
        }
        System.out.println("-------------------------------");
        System.out.println("Total: " + contactos.size() + "/" + capacidadMaxima);
    }

    // 5. Eliminar contacto
    public boolean eliminarContacto(String nombre, String apellido) {
        Agenda contactoAEliminar = null;

        for (Agenda contacto : contactos) {
            boolean mismoNombre = contacto.getNombre().equalsIgnoreCase(nombre);
            boolean mismoApellido = contacto.getApellido().equalsIgnoreCase(apellido);
            if (mismoNombre && mismoApellido) {
                contactoAEliminar = contacto;
                break;
            }
        }

        if (contactoAEliminar != null) {
            contactos.remove(contactoAEliminar);
            System.out.println("✅ Contacto eliminado correctamente.");
            return true;
        } else {
            System.out.println("❌ No se encontró el contacto para eliminar.");
            return false;
        }
    }

    // 6. Modificar teléfono
    public boolean modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        for (Agenda contacto : contactos) {
            boolean mismoNombre = contacto.getNombre().equalsIgnoreCase(nombre);
            boolean mismoApellido = contacto.getApellido().equalsIgnoreCase(apellido);
            if (mismoNombre && mismoApellido) {
                contacto.setTelefono(nuevoTelefono);
                System.out.println("✅ Teléfono modificado correctamente.");
                System.out.print("Nuevo dato: ");
                contacto.showDetails();
                return true;
            }
        }
        System.out.println("❌ No se encontró el contacto para modificar.");
        return false;
    }

    // 7. Comprobar si está llena
    public boolean agendaLlena() {
        return contactos.size() >= capacidadMaxima;
    }

    // 8. Ver espacios libres
    public int espacioLibres() {
        int libres = capacidadMaxima - contactos.size();
        System.out.println("📊 Espacios libres: " + libres + " de " + capacidadMaxima);
        return libres;
    }
}
