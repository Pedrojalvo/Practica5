package util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GrafoTest {

    @Test
    public void pruebaCaminoMasCorto() {
        Grafo<Integer> grafo = new Grafo<>();
        grafo.agregarArista(1, 2);
        grafo.agregarArista(1, 5);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 4);
        grafo.agregarArista(5, 4);

        List<Integer> caminoEsperado = new ArrayList<>();
        caminoEsperado.add(1);
        caminoEsperado.add(5);
        caminoEsperado.add(4);

        assertEquals(caminoEsperado, grafo.caminoMasCorto(1, 4));
    }
}
