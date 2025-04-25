import java.util.LinkedList;
import java.util.Queue;

public class ArbolBST {
    private NodoBST raiz;

    public void insertar(int id) {
        raiz = insertarRec(raiz, id);
    }

    private NodoBST insertarRec(NodoBST nodo, int id) {
        if (nodo == null) return new NodoBST(id);
        if (id < nodo.id) nodo.izquierda = insertarRec(nodo.izquierda, id);
        else if (id > nodo.id) nodo.derecha = insertarRec(nodo.derecha, id);
        return nodo;
    }

    public String recorridoNivel() {
        StringBuilder sb = new StringBuilder();
        if (raiz == null) return "";
        Queue<NodoBST> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            NodoBST actual = cola.poll();
            sb.append(actual.id).append("\n");
            if (actual.izquierda != null) cola.add(actual.izquierda);
            if (actual.derecha != null) cola.add(actual.derecha);
        }
        return sb.toString();
    }
}