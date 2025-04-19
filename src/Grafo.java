import java.util.*;
public class Grafo<D,DA> {
    ListaDoblementeEnlazada<Nodo<D>> vertices = new ListaDoblementeEnlazada<>();
    ListaDoblementeEnlazada<Arista<DA,D>> aristas = new ListaDoblementeEnlazada<>();

    void addNodo(D dato, int id){
        Nodo<D> nodo = new Nodo<>(dato, id);
        vertices.add(nodo);
    }
    void addArista(Nodo<D> origen,Nodo<D> destino,DA anotacion,int ID){
        Arista<DA,D> arista = new Arista<>(origen,destino,anotacion,ID);
        aristas.add(arista);
    }
    public Nodo<D> getNodo(int id) {
        Iterador<Nodo<D>> ite = new IteradorDoblementeEnlazada<>(vertices);
        while(ite.hasNext()){
            Nodo<D> actual = ite.next();
            if (actual.getID() == id){
                return actual;
            }
        }
        return null;// o lanzar una excepción si prefieres
    }
    public ListaDoblementeEnlazada<Arista<DA, D>> getAristasEntre(Nodo<D> origen, Nodo<D> destino) {
        ListaDoblementeEnlazada<Arista<DA, D>> resultado = new ListaDoblementeEnlazada<>();
        Iterador<Arista<DA, D>> ite = new IteradorDoblementeEnlazada<>(aristas);

        while (ite.hasNext()) {
            Arista<DA, D> arista = ite.next();
            if (arista.origen == origen && arista.destino == destino) {
                resultado.add(arista);
            }
        }

        return resultado;
    }

}
