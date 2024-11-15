import java.util.*;

public class Djikstra {

    private Grafo grafo;

    public Djikstra(Grafo grafo) {
        this.grafo = grafo;
    }

    public Map<Vertice, Integer> executar(Vertice origem) {
        // Mapeia a menor distância para cada vértice a partir da origem
        Map<Vertice, Integer> distancias = new HashMap<>();
        // Mapeia o vértice anterior no caminho mais curto
        Map<Vertice, Vertice> anteriores = new HashMap<>();
        // Conjunto de vértices ainda não processados
        PriorityQueue<VerticeDistancia> fila = new PriorityQueue<>(Comparator.comparingInt(VerticeDistancia::getDistancia));

        // Inicializa as distâncias
        for (Vertice v : grafo.vertices) {
            distancias.put(v, Integer.MAX_VALUE);
        }
        distancias.put(origem, 0);

        fila.add(new VerticeDistancia(origem, 0));

        while (!fila.isEmpty()) {
            VerticeDistancia vd = fila.poll();
            Vertice u = vd.getVertice();

            for (Aresta aresta : u.getArestas()) {
                Vertice v = aresta.getDestino();
                int peso = calcularPeso(u, v); // Aqui você pode adicionar uma lógica para calcular o peso

                int novaDistancia = distancias.get(u) + peso;
                if (novaDistancia < distancias.get(v)) {
                    distancias.put(v, novaDistancia);
                    anteriores.put(v, u);

                    fila.add(new VerticeDistancia(v, novaDistancia));
                }
            }
        }

        return distancias;
    }

    private int calcularPeso(Vertice origem, Vertice destino) {
        //Calculando o peso por distância euclidiana
        int dx = destino.getX() - origem.getX();
        int dy = destino.getY() - origem.getY();
        
        return (int) Math.sqrt(dx * dx + dy * dy);
    }

    private class VerticeDistancia {
        private Vertice vertice;
        private int distancia;

        public VerticeDistancia(Vertice vertice, int distancia) {
            this.vertice = vertice;
            this.distancia = distancia;
        }

        public Vertice getVertice() {
            return vertice;
        }

        public int getDistancia() {
            return distancia;
        }
    }
}
