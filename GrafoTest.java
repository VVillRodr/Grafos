import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrafoTest {

    @Test
    public void testAdicionarVertice() {
        Grafo grafo = new Grafo();
        assertTrue(grafo.adicionarVertice(1));
        assertTrue(grafo.adicionarVertice(2));
        assertFalse(grafo.adicionarVertice(1)); // tentativa de adicionar vértice repetido
        assertFalse(grafo.adicionarVertice(-1));// tentativa de adicionar vértices negativos
        assertFalse(grafo.adicionarVertice(-2));
    }

    @Test
    public void testAdicionarAresta() {
        Grafo grafo = new Grafo();
        grafo.adicionarVertice(1);
        grafo.adicionarVertice(2);
        grafo.adicionarVertice(3);

        assertTrue(grafo.adicionarAresta(1, 2));
        assertTrue(grafo.adicionarAresta(2, 3));
        assertTrue(grafo.adicionarAresta(1, 3));
        
        assertTrue(grafo.adicionarAresta(1, 4)); // tentativa de adicionar aresta com vértice inexistente
        assertFalse(grafo.adicionarAresta(-1, 2));
        assertFalse(grafo.adicionarAresta(-1, -2));
        assertFalse(grafo.adicionarAresta(1, -2));// tentativa de adicionar aresta com vértice negativo
    }

    @Test
    public void testSaoVizinhos() {
        Grafo grafo = new Grafo();
        grafo.adicionarVertice(1);
        grafo.adicionarVertice(2);
        grafo.adicionarVertice(3);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 3);

        assertTrue(grafo.saoVizinhos(1, 2));
        assertTrue(grafo.saoVizinhos(2, 3));
        assertFalse(grafo.saoVizinhos(1, 3));
        assertFalse(grafo.saoVizinhos(1, 4)); // tentativa de verificar vizinhança com vértice inexistente
    }

    @Test
    public void testListaVizinhos() {
        Grafo grafo = new Grafo();
        grafo.adicionarVertice(1);
        grafo.adicionarVertice(2);
        grafo.adicionarVertice(3);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 3);

        
        assertTrue(grafo.listarVizinhos(1).contains(2));
        assertFalse(grafo.listarVizinhos(1).contains(3));
        assertFalse(grafo.listarVizinhos(1).contains(4)); // tentativa de obter lista de vizinhos de vértice inexistente
    }
}