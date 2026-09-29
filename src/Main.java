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
            System.out.println("1. Añadir contacto: ");
            System.out.println("2. Verificar si existe contacto: ");
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
                    case 2 -> verificarContacto(scanner, agenda);
                    //case 3 -> agenda.listarContactos();
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
//1.añadir contacto
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
//2.Verificar contacto
    private static void verificarContacto(Scanner scanner, Metodos agenda) {
        System.out.print("Nombre a buscar: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido a buscar: ");
        String apellido = scanner.nextLine();

        agenda.buscarYMostrarContacto(nombre, apellido);
    }
    // 3. Listar Contactos
    private static void listarContactos(Metodos agenda) {
        agenda.listarContactosOrdenados();
    }

    // 4. Buscar Contacto
    private static void buscarContacto(Scanner scanner, Metodos agenda) {
        System.out.print("Nombre a buscar: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido a buscar: ");
        String apellido = scanner.nextLine();
        agenda.buscarYMostrarContacto(nombre, apellido);
    }

    // 5. Eliminar Contacto
    private static void eliminarContacto(Scanner scanner, Metodos agenda) {
        System.out.print("Nombre a eliminar: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido a eliminar: ");
        String apellido = scanner.nextLine();
        agenda.eliminarContacto(nombre, apellido);
    }

    // 6. Modificar teléfono
    private static void modificarTelefono(Scanner scanner, Metodos agenda) {
        System.out.print("Nombre del contacto: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido del contacto: ");
        String apellido = scanner.nextLine();
        System.out.print("Nuevo teléfono: ");
        String nuevoTelefono = scanner.nextLine();
        agenda.modificarTelefono(nombre, apellido, nuevoTelefono);
    }


}

