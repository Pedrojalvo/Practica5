package util;

import java.util.*;

public class Grafo<V> {
    private Map<V, Set<V>> listaDeAdyacencia = new HashMap<>();

    public void agregarArista(V origen, V destino) {
        listaDeAdyacencia.computeIfAbsent(origen, k -> new HashSet<>()).add(destino);
        listaDeAdyacencia.computeIfAbsent(destino, k -> new HashSet<>()).add(origen);
    }

    public List<V> caminoMasCorto(V inicio, V fin) {
        Map<V, V> padre = new HashMap<>();
        Queue<V> cola = new LinkedList<>();
        Set<V> visitados = new HashSet<>();

        cola.offer(inicio);
        visitados.add(inicio);
        boolean encontrado = false;

        while (!cola.isEmpty() && !encontrado) {
            V actual = cola.poll();
            for (V vecino : listaDeAdyacencia.getOrDefault(actual, Collections.emptySet())) {
                if (!visitados.contains(vecino)) {
                    cola.offer(vecino);
                    visitados.add(vecino);
                    padre.put(vecino, actual);
                    if (vecino.equals(fin)) {
                        encontrado = true;
                        break;
                    }
                }
            }
        }

        List<V> camino = new ArrayList<>();
        V actual = fin;
        while (actual != null) {
            camino.add(actual);
            actual = padre.get(actual);
        }
        Collections.reverse(camino);
        return camino.size() > 1 ? camino : Collections.emptyList();
    }
}
