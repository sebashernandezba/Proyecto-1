import java.io.*;
import java.util.List;

public class GeneradorArchivos {

    public static void guardarListaBinaria(String nombreArchivo, List<Contacto> lista) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            out.writeObject(lista);
            System.out.println("Archivo guardado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Contacto> cargarListaBinaria(String nombreArchivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (List<Contacto>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo cargar el archivo.");
            return null;
        }
    }
}