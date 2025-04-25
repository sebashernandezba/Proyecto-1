import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorCSV {
    private static final String ARCHIVO = "contactos.csv";

    public static void exportar(List<Contacto> contactos) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO))) {
            for (Contacto c : contactos) {
                pw.println(c.toCSV());
            }
            System.out.println("Contactos exportados correctamente a " + ARCHIVO);
        } catch (IOException e) {
            System.out.println("Error al exportar contactos.");
        }
    }

    public static List<Contacto> importar() {
        List<Contacto> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 8) {
                    int id = Integer.parseInt(datos[0]);
                    lista.add(new Contacto(id, datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[7]));
                }
            }
            System.out.println("Contactos importados correctamente desde " + ARCHIVO);
        } catch (IOException e) {
            System.out.println("No se pudo importar. Asegúrate de que el archivo exista.");
        }
        return lista;
    }

    public static int generarNuevoId(List<Contacto> contactos) {
        int max = 0;
        for (Contacto c : contactos) {
            if (c.getId() > max) max = c.getId();
        }
        return max + 1;
    }
}