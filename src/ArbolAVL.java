import java.util.LinkedList;
import java.util.Queue;

public class ArbolAVL {
    private NodoAVL raiz;

    private int altura(NodoAVL n) {
        return n == null ? 0 : n.altura;
    }

    private int balance(NodoAVL n) {
        return n == null ? 0 : altura(n.izquierda) - altura(n.derecha);
    }

    private NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.izquierda;
        y.izquierda = x.derecha;
        x.derecha = y;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
        return x;
    }

    private NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.derecha;
        x.derecha = y.izquierda;
        y.izquierda = x;
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        return y;
    }

    public void insertar(int id) {
        raiz = insertarRec(raiz, id);
    }

    private NodoAVL insertarRec(NodoAVL nodo, int id) {
        if (nodo == null) return new NodoAVL(id);
        if (id < nodo.id) nodo.izquierda = insertarRec(nodo.izquierda, id);
        else if (id > nodo.id) nodo.derecha = insertarRec(nodo.derecha, id);
        else return nodo;

        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));
        int balance = balance(nodo);

        if (balance > 1 && id < nodo.izquierda.id) return rotarDerecha(nodo);
        if (balance < -1 && id > nodo.derecha.id) return rotarIzquierda(nodo);
        if (balance > 1 && id > nodo.izquierda.id) {
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }
        if (balance < -1 && id < nodo.derecha.id) {
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    public String recorridoNivel() {
        StringBuilder sb = new StringBuilder();
        if (raiz == null) return "";
        Queue<NodoAVL> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            NodoAVL actual = cola.poll();
            sb.append(actual.id).append("\n");
            if (actual.izquierda != null) cola.add(actual.izquierda);
            if (actual.derecha != null) cola.add(actual.derecha);
        }
        return sb.toString();
    }
}