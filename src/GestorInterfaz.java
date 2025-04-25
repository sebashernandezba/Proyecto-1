import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GestorInterfaz {
    private static final Scanner sc = new Scanner(System.in);
    private static final SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

    public static Contacto crearContacto(List<Contacto> contactos) {
        int id = GestorCSV.generarNuevoId(contactos);

        System.out.println("Ingrese nombre (solo letras): ");
        String nombre = validarSoloLetras();

        System.out.println("Ingrese apellido (solo letras): ");
        String apellido = validarSoloLetras();

        System.out.println("Ingrese apodo (letras o números): ");
        String apodo = validarAlfanumerico();

        System.out.println("Ingrese telefono (8 dígitos): ");
        String telefono = validarTelefono();

        System.out.println("Ingrese email: ");
        String email = sc.nextLine();

        System.out.println("Ingrese direccion: ");
        String direccion = sc.nextLine();

        System.out.println("Ingrese fecha de nacimiento (DD-MM-AAAA): ");
        String fechaNacimiento = validarFecha();

        return new Contacto(id, nombre, apellido, apodo, telefono, email, direccion, fechaNacimiento);
    }

    public static void actualizarContacto(List<Contacto> contactos, int id) {
        for (Contacto c : contactos) {
            if (c.getId() == id) {
                System.out.println("Actualizando contacto: " + c.getNombre() + " " + c.getApellido());

                System.out.println("Nuevo nombre (Enter para mantener): ");
                String nuevo = sc.nextLine();
                if (!nuevo.isEmpty()) c.setNombre(nuevo);

                System.out.println("Nuevo apellido: ");
                nuevo = sc.nextLine();
                if (!nuevo.isEmpty()) c.setApellido(nuevo);

                System.out.println("Nuevo apodo: ");
                nuevo = sc.nextLine();
                if (!nuevo.isEmpty()) c.setApodo(nuevo);

                System.out.println("Nuevo teléfono: ");
                nuevo = sc.nextLine();
                if (!nuevo.isEmpty()) c.setTelefono(nuevo);

                System.out.println("Nuevo email: ");
                nuevo = sc.nextLine();
                if (!nuevo.isEmpty()) c.setEmail(nuevo);

                System.out.println("Nueva direccion: ");
                nuevo = sc.nextLine();
                if (!nuevo.isEmpty()) c.setDireccion(nuevo);

                System.out.println("Nueva fecha de nacimiento (DD-MM-AAAA): ");
                nuevo = sc.nextLine();
                if (!nuevo.isEmpty()) c.setFechaNacimiento(nuevo);

                System.out.println("Contacto actualizado.");
                return;
            }
        }
        System.out.println("No se encontro el contacto.");
    }

    public static void buscarPorCampo(List<Contacto> contactos, String campo, String valor) {
        boolean encontrado = false;
        for (Contacto c : contactos) {
            if (campo.equalsIgnoreCase("nombre") && c.getNombre().equalsIgnoreCase(valor) ||
                    campo.equalsIgnoreCase("apellido") && c.getApellido().equalsIgnoreCase(valor) ||
                    campo.equalsIgnoreCase("apodo") && c.getApodo().equalsIgnoreCase(valor) ||
                    campo.equalsIgnoreCase("telefono") && c.getTelefono().equalsIgnoreCase(valor)) {
                System.out.println(c);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No se encontro coincidencia.");
    }

    // VALIDACIONES
    private static String validarSoloLetras() {
        while (true) {
            String input = sc.nextLine();
            if (input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) return input;
            System.out.println("Solo letras. Intente de nuevo:");
        }
    }

    private static String validarAlfanumerico() {
        while (true) {
            String input = sc.nextLine();
            if (input.matches("[a-zA-Z0-9]+")) return input;
            System.out.println("Solo letras o números. Intente de nuevo:");
        }
    }

    private static String validarTelefono() {
        while (true) {
            String input = sc.nextLine();
            if (input.matches("\\d{8}")) return input;
            System.out.println("Debe contener 8 digitos numericos:");
        }
    }

    private static String validarFecha() {
        while (true) {
            String fecha = sc.nextLine();
            try {
                Date nacimiento = formatoFecha.parse(fecha);
                Date hoy = new Date();
                if (!nacimiento.after(hoy)) return fecha;
                System.out.println("La fecha no puede ser en el futuro.");
            } catch (ParseException e) {
                System.out.println("Formato invalido. Use DD-MM-AAAA:");
            }
        }
    }
}