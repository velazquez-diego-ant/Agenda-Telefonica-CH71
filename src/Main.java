import org.agenda.exceptions.InvalidData;
import org.agenda.models.Contactos;
import org.agenda.models.Manager;
import org.agenda.models.Agenda;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Pruebo agrego contacto
        Manager miAgenda = new Manager();
        try {
            miAgenda.agregarContacto("Andres", "Carrizosa", 55896358);
            miAgenda.agregarContacto("Andres", "Carrizosa", 55896358);
        }catch (InvalidData e){
            System.out.println("Problemas al crear contacto " + e.getMessage());
        }
        miAgenda.mostrarContactos();
        }

    }

