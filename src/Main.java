import org.agenda.exceptions.InvalidData;
import org.agenda.models.Contactos;

import org.agenda.models.Agenda;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Pruebo agrego contacto
        ArrayList<Contactos> contactos = new ArrayList<>();
        try {
            contactos.add(new Agenda("Andres", "Carrizosa", 55896352));
        }catch (InvalidData e){
            System.out.println("Problemas al crear contacto " + e.getMessage());
        }
        for (Contactos agenda: contactos){
            agenda.showDetails();
        }

    }
}
