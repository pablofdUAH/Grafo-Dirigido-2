public class Main {
    public static void main(String[] args) {
        Grafo<String, String> grafo = new Grafo<>();

        // Nodos
        grafo.addNodo("A", 1);
        grafo.addNodo("B", 2);
        grafo.addNodo("C", 3);
        grafo.addNodo("D", 4);

        // Aristas: grafo cíclico A → B → C → A y también C → D
        grafo.addArista(1, 2, "A-B", 100);
        grafo.addArista(2, 3, "B-C", 101);
        grafo.addArista(3, 1, "C-A", 102); // forma un ciclo
        grafo.addArista(3, 4, "C-D", 103);

        // Buscar caminos de A a D
        ListaDoblementeEnlazada<ListaDoblementeEnlazada<Nodo<String>>> caminos = grafo.encontrarCaminosEntre(1, 4);

        System.out.println("Caminos desde A hasta D:");
        for (ListaDoblementeEnlazada<Nodo<String>> camino : caminos) {
            for (Nodo<String> nodo : camino) {
                System.out.print(nodo.getDato() + " ");
            }
            System.out.println();
        }
    }
}


