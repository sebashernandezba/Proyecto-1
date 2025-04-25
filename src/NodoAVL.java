public class NodoAVL {
    public int id;
    public NodoAVL izquierda, derecha;
    public int altura;

    public NodoAVL(int id) {
        this.id = id;
        altura = 1;
    }
}