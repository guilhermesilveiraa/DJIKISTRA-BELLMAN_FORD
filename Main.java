import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Caminho para o arquivo com os dados das cidades
        String arquivoCidades = "cidades.txt";

        try {
            // Lendo o arquivo
            BufferedReader br = new BufferedReader(new FileReader(arquivoCidades));
            String linha;
            Map<String, Vertice> mapaCidades = new HashMap<>();

            // Lendo as cidades e suas coordenadas
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(" ");
                String nome = partes[0];
                int x = Integer.parseInt(partes[1]);
                int y = Integer.parseInt(partes[2]);

                // Criando vértice para cada cidade
                Vertice cidade = grafo.addVertice(new Vertice(nome, x, y));
                mapaCidades.put(nome, cidade);
            }

            br.close();

            // Conectando cidades manualmente (pode ser ajustado conforme necessidade)
            for (Vertice origem : grafo.vertices) {
                for (Vertice destino : grafo.vertices) {
                    if (!origem.equals(destino)) {
                        grafo.addAresta(origem, destino);
                    }
                }
            }

            grafo.ligarArestas();

            // Executando o algoritmo de Djikstra
            Djikstra djikstra = new Djikstra(grafo);

            // Usar a primeira cidade como origem
            Vertice origem = grafo.vertices.get(0);
            Map<Vertice, Integer> distancias = djikstra.executar(origem);

            // Exibindo as distâncias calculadas
            System.out.println("Distâncias a partir da cidade: " + origem.getId());
            for (Map.Entry<Vertice, Integer> entrada : distancias.entrySet()) {
                System.out.println(entrada.getKey().getId() + ": " + entrada.getValue());
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
