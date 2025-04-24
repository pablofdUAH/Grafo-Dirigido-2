public class Nodo<D> {
    private D dato;
    private int ID;

    ListaDoblementeEnlazada<Arista> salida = new ListaDoblementeEnlazada<>();
    ListaDoblementeEnlazada<Arista> entrada = new ListaDoblementeEnlazada<>();

    public Nodo(D dato, int ID) {
        this.dato = dato;
        this.ID = ID;
        this.salida = new ListaDoblementeEnlazada<>();
        this.entrada = new ListaDoblementeEnlazada<>();
    }

    public int getID() {
        return ID;
    }

    public D getDato() {
        return dato;
    }
}
