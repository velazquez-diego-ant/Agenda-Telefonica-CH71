
package org.agenda.models;
import org.agenda.exceptions.InvalidData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Agenda extends Contactos implements Comparable<Agenda> {
    private String telefono;

    public Agenda(String nombre, String apellido, String telefono) throws InvalidData {
        super(nombre, apellido);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public void showDetails() {
        System.out.println(getNombre() + "|" + getApellido() + "|" + telefono);
    }

    @Override
    public int compareTo(Agenda agenda) {
        int cmp = this.getApellido().compareToIgnoreCase(agenda.getApellido());
        if (cmp != 0) return cmp;
        return this.getNombre().compareToIgnoreCase(agenda.getNombre());
    }
}



// Metodo para agregar contactos a la lista
//    public void agregarContacto(String nombre, String apellido, Integer numero) throws InvalidData {
//        for (Contactos c : listaContactos) {
//            boolean mismoNombre = c.getNombre().equalsIgnoreCase(nombre);
//            boolean mismoApellido = c.getApellido().equalsIgnoreCase(apellido);
//
//            if (mismoNombre && mismoApellido) {
//                throw new InvalidData("El contacto " + nombre + " " + apellido + " ya se encuentra en la agenda.");
//            }
//        }
//
//        Se instancia a sí misma (Agenda) porque es la única clase concreta disponible
//        Contactos nuevoContacto = new Contactos(nombre, apellido, numero);
//        listaContactos.add(nuevoContacto);
//        System.out.println("¡Contacto agregado con éxito!");
//    }
//
//    public ArrayList<Contactos> getListaContactos() {
//        return listaContactos;
//    }
//
//    public void mostrarContactos() {
//        if (listaContactos.isEmpty()) {
//            System.out.println("La agenda está vacía.");
//            return;
//        }
//        for (Contactos c : listaContactos) {
//            c.showDetails();
//        }
//    }
