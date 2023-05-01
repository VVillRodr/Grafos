import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
    private Map<Integer, List<Integer>> listaAdjacencia;

    public Grafo() {
        this.listaAdjacencia = new HashMap<>();
    }

    public boolean adicionarVertice(int vertice) {
        if (!this.listaAdjacencia.containsKey(vertice) && vertice >= 0) {
            this.listaAdjacencia.put(vertice, new ArrayList<>());
            return true;
        }
        else
            return false;
    }

    public boolean adicionarAresta(int origem, int destino) {
        if(origem < 0 || destino < 0)
            return false;
        else{
            adicionarVertice(origem);
            adicionarVertice(destino);
            this.listaAdjacencia.get(origem).add(destino);
            return true;
        }
        
    }

    public boolean saoVizinhos(int vertice1, int vertice2) {
        if (this.listaAdjacencia.containsKey(vertice1) && this.listaAdjacencia.containsKey(vertice2)) {
            return this.listaAdjacencia.get(vertice1).contains(vertice2);
        }
        return false;
    }
    
    public void imprimirGrafo() {
    for (int vertice : this.listaAdjacencia.keySet()) {
            System.out.print(vertice + " -> ");
            for (int vizinho : this.listaAdjacencia.get(vertice)) {
                System.out.print(vizinho + " ");
            }
            System.out.println();
        }
    }
    
    public List<Integer> listarVizinhos(int vertice) {
        if (this.listaAdjacencia.containsKey(vertice)) {
            return this.listaAdjacencia.get(vertice);
        }
        return null;
    }
}