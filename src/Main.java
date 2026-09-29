import org.agenda.exceptions.InvalidData;
import org.agenda.models.Contactos;
import org.agenda.models.Agenda;
import org.agenda.models.Metodos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Metodos agenda = new Metodos(); // Tamaño por defecto (10)
        int opcion;

        do {
            System.out.println("\n========== AGENDA TELEFÓNICA ==========");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Verificar si existe contacto");
            System.out.println("3. Listar contactos");
            System.out.println("4. Buscar contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Modificar teléfono");
            System.out.println("7. Comprobar si está llena");
            System.out.println("8. Ver espacios libres");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1 -> crearContacto(scanner, agenda);
//                    case 2 -> existeContacto(scanner, agenda);
//                    case 3 -> agenda.listarContactos();
//                    case 4 -> buscarContacto(scanner, agenda);
//                    case 5 -> eliminarContacto(scanner, agenda);
//                    case 6 -> modificarTelefono(scanner, agenda);
//                    case 7 -> {
//                        if (agenda.agendaLlena()) {
//                            System.out.println("⚠️ La agenda está llena.");
//                        } else {
//                            System.out.println("La agenda aún tiene espacio disponible.");
//                        }
//                    }
//                    case 8 -> agenda.espacioLibres();
                    case 0 -> System.out.println("Saliendo de la agenda...");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
                opcion = -1;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void crearContacto(Scanner scanner, Metodos agenda) {
        try {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();

            Agenda c = new Agenda(nombre, apellido, telefono);
            agenda.añadirContacto(c);
        } catch (InvalidData e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}

