import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Contacto> contactos = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n--- CONTACTOS ---");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Actualizar contacto");
            System.out.println("4. Mostrar todos los contactos");
            System.out.println("5. Buscar contacto por campo");
            System.out.println("6. Exportar contactos a CSV");
            System.out.println("7. Importar contactos desde CSV");
            System.out.println("8. Mostrar indices BST y AVL");
            System.out.println("9. Salir");
            System.out.print("Seleccione opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> contactos.add(GestorInterfaz.crearContacto(contactos));
                case 2 -> {
                    System.out.print("Ingrese ID a eliminar: ");
                    int id = Integer.parseInt(sc.nextLine());
                    if (contactos.removeIf(c -> c.getId() == id))
                        System.out.println("Contacto eliminado.");
                    else
                        System.out.println("ID no encontrado.");
                }
                case 3 -> {
                    System.out.print("ID del contacto a actualizar: ");
                    int id = Integer.parseInt(sc.nextLine());
                    GestorInterfaz.actualizarContacto(contactos, id);
                }
                case 4 -> {
                    if (contactos.isEmpty()) System.out.println("No hay contactos.");
                    else contactos.forEach(System.out::println);
                }
                case 5 -> {
                    System.out.print("Campo (nombre, apellido, apodo, telefono): ");
                    String campo = sc.nextLine();
                    System.out.print("Valor a buscar: ");
                    String valor = sc.nextLine();
                    GestorInterfaz.buscarPorCampo(contactos, campo, valor);
                }
                case 6 -> GestorCSV.exportar(contactos);
                case 7 -> contactos.addAll(GestorCSV.importar());
                case 8 -> {
                    IndiceManager.mostrarIndicesBST(contactos);
                    IndiceManager.mostrarIndicesAVL(contactos);
                }
                case 9 -> System.out.println("Adios...");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 9);
    }
}