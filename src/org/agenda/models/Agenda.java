package org.agenda.models;
import org.agenda.exceptions.InvalidData;
public class Agenda extends Contactos{
    public Agenda(String nombre, String apellido, Integer numero) throws InvalidData {
        super(nombre, apellido, numero);
    }

    @Override
    public void showDetails() {
        System.out.println("----- Detalles de los contactos -----");
        System.out.println("Nombre " + getNombre());
        System.out.println("Apellido " + getApellido());
        System.out.println("Numero " + getNumero());
    }
}
