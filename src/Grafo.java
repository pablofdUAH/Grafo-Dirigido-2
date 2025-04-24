import java.util.*;
public class Grafo<D,DA> {
    ListaDoblementeEnlazada<Nodo<D>> vertices = new ListaDoblementeEnlazada<>();
    ListaDoblementeEnlazada<Arista<DA,D>> aristas = new ListaDoblementeEnlazada<>();

    void addNodo(D dato, int id){
        Nodo<D> nodo = new Nodo<>(dato, id);
        vertices.add(nodo);
    }
    boolean addArista(int origenId,int destinoId,DA anotacion,int ID){
        Nodo<D> origen = getNodo(origenId);
        Nodo<D> destino = getNodo(destinoId);
        if(origen != null && destino != null)
            {Arista<DA,D> arista = new Arista<>(origen,destino,anotacion,ID);
            aristas.add(arista);
        return true;}
        else{return false;}
    }
    public Nodo<D> getNodo(int id) {
        Iterador<Nodo<D>> ite = new IteradorDoblementeEnlazada<>(vertices);
        while(ite.hasNext()){
            Nodo<D> actual = ite.next();
            if (actual.getID() == id){
                return actual;
            }
        }
        return null;
    }
    public ListaDoblementeEnlazada<Arista<DA, D>> getAristasEntre(int origenId, int destinoId) {
        Nodo<D> origen = getNodo(origenId);
        Nodo<D> destino = getNodo(destinoId);

        if(origen != null && destino != null) {
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
        return null;
    }
    public ListaDoblementeEnlazada<Nodo<D>> getVecinos(int id) {
        Nodo<D> nodo = getNodo(id);
        ListaDoblementeEnlazada<Nodo<D>> vecinos = new ListaDoblementeEnlazada<>();
        if (nodo != null) {
            Iterador<Arista> ite = new IteradorDoblementeEnlazada<>(nodo.salida);
            while (ite.hasNext()) {
                Arista<DA, D> arista = ite.next();
                vecinos.add(arista.destino);
            }
        }
        return vecinos;
    }
    public boolean existeCaminoEntre(int origenId, int destinoId) {
        Nodo<D> origen = getNodo(origenId);
        Nodo<D> destino = getNodo(destinoId);
        if (origen == null || destino == null) return false;

        ListaDoblementeEnlazada<Nodo<D>> visitados = new ListaDoblementeEnlazada<>();
        return recuExisteCamino(origen, destino, visitados);
    }

    private boolean recuExisteCamino(Nodo<D> actual, Nodo<D> destino, ListaDoblementeEnlazada<Nodo<D>> visitados) {
        if (actual == null || destino == null) {
            System.out.println("Uno de los nodos no existe.");
            return false;
        }
        if (actual == destino) return true;
        visitados.add(actual);

        Iterador<Arista> ite = new IteradorDoblementeEnlazada<>(actual.salida);
        while (ite.hasNext()) {
            Nodo<D> vecino = ite.next().destino;
            if (!visitados.contains(vecino)) {
                if (recuExisteCamino(vecino, destino, visitados)) return true;
            }
        }
        return false;
    }


}
