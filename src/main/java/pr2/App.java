package pr2;

import util.Grafo;

public class App {
    public static void main(String[] args) {
        Grafo<Integer> grafo = new Grafo<>();
        grafo.agregarArista(1, 2);
        grafo.agregarArista(1, 5);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 4);
        grafo.agregarArista(5, 4);

        Integer inicio = 1;
        Integer fin = 4;

        System.out.println("Camino más corto desde el vértice " + inicio + " al vértice " + fin + ":");
        System.out.println(grafo.caminoMasCorto(inicio, fin));
    }
}

