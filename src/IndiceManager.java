import java.util.List;

public class IndiceManager {
    public static void mostrarIndicesBST(List<Contacto> contactos) {
        ArbolBST arbol = new ArbolBST();
        for (Contacto c : contactos) {
            arbol.insertar(c.getId());
        }
        System.out.println("Recorrido por niveles (BST):");
        System.out.println(arbol.recorridoNivel());
    }

    public static void mostrarIndicesAVL(List<Contacto> contactos) {
        ArbolAVL arbol = new ArbolAVL();
        for (Contacto c : contactos) {
            arbol.insertar(c.getId());
        }
        System.out.println("Recorrido por niveles (AVL):");
        System.out.println(arbol.recorridoNivel());
    }
}