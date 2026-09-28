package org.agenda.models;
import org.agenda.exceptions.InvalidData;
import java.util.ArrayList;

public class Manager {
    private ArrayList<Contactos> contactos = new ArrayList<>();
    private int capacidadMaxima;
    // Crea una agenda con espacio para 10 contactos.
    public Manager() {
        this(10);
    }
    // Crea una agenda con la capacidad indicada.
    public Manager(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException(
                    "La capacidad debe ser mayor que cero"
            );
        }

        this.capacidadMaxima = capacidadMaxima;
    }
    public boolean agendaLlena() {
        return contactos.size() >= capacidadMaxima;
    }
    public void agregarContacto(String nombre, String apellido, Integer numero) throws InvalidData {
            for (Contactos c : contactos) {

                boolean mismoNombre = c.getNombre().equalsIgnoreCase(nombre);
                boolean mismoApellido = c.getApellido().equalsIgnoreCase(apellido);

                if (mismoNombre && mismoApellido) {

                    throw new InvalidData("El contacto " + nombre + " " + apellido + " ya se encuentra en la agenda.");
                }
            }
        if (agendaLlena()) {
            System.out.println(
                    "La agenda está llena. No se pueden agregar más contactos."
            );
            return;
        }


            Contactos nuevoContacto = new Agenda(nombre, apellido, numero);
            contactos.add(nuevoContacto);
            System.out.println("¡Contacto agregado con éxito!");
        }

        public void mostrarContactos() {
            if (contactos.isEmpty()) {
                System.out.println("La agenda está vacía.");
                return;
            }
            for (Contactos contacto : contactos) {
                contacto.showDetails();
            }

        }
    }

