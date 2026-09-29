package org.agenda.models;

import org.agenda.exceptions.InvalidData;

public abstract class  Contactos {

    protected String nombre;
    protected String apellido;

    public Contactos(String nombre, String apellido) throws InvalidData{
        if(nombre == null || (nombre.trim().isEmpty())) throw new InvalidData("El nombre no puede estar vacio");
        if(apellido == null || (apellido.trim().isEmpty())) throw new InvalidData("El apellido no puede estar vacio");
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public abstract void showDetails();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contactos contactos = (Contactos) o;
        return nombre.equalsIgnoreCase(contactos.nombre) &&
                apellido.equalsIgnoreCase(contactos.apellido);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(nombre.toLowerCase(), apellido.toLowerCase());
    }

}
