package org.agenda.models;
import org.agenda.exceptions.InvalidData;
import java.util.ArrayList;

public class Manager {
    private ArrayList<Contactos> contactos;
    private int capacidadMaxima;

    public Manager(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.contactos = new ArrayList<>();
    }
    public void agregarContacto(String nombre, String apellido, Integer numero) throws InvalidData {
            for (Contactos c : contactos) {

                boolean mismoNombre = c.getNombre().equalsIgnoreCase(nombre);
                boolean mismoApellido = c.getApellido().equalsIgnoreCase(apellido);

                if (mismoNombre && mismoApellido) {

                    throw new InvalidData("El contacto " + nombre + " " + apellido + " ya se encuentra en la agenda.");
                }
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

        public int espacioLibres() {
           return capacidadMaxima - contactos.size();
    }


    }

