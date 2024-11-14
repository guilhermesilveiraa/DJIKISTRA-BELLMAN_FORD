# Repositório para estudos em grafos ⚪->⚪->⚪

Este repositório tem por objetivo firmar meus conhecimentos na matéria de grafos. Estou estudando pelo livro Projeto de Algoritmos do Nívio Ziviani

## DJIKISTRA

O algoritmo resolve o problema encontrar o caminho mínimo partindo de um vértice inicial até um vértice de destino, sua implantação é aplicável apenas em grafos com pesos positivos. Sua técnica consiste numa estratégia gulosa, pois durante sua execução o próximo vértice a ser explorado sempre é o que possui ligação através de uma aresta com o menor peso.

A complexidade total do algoritmo de Djikistra é O(V+E) log v.

### Pseudo-código
    
    Djikistra(Grafo G, VérticeInicial vi):
            Cria conjunto Q de não visitados
            Para cada vértice v de G
                  se v!= origem:
                     distancia[v] = infinito
                  anterior[v] = vi
                  insere v em Q
            Enquanto Q != vazio:
                 u = min(Q)
                 Para cada v de u:
                    alt = distancia[u] + peso(u,v)
                    se alt < dist[v]:
                      dist[v] = alt
                      prev[v] = u
            Retorna dist[], prev[]
                
            
