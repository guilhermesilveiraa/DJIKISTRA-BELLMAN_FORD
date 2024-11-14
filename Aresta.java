public class Aresta{
    
    private Vertice origem;
    private Vertice destino;
    
    public Aresta(Vertice origem, Vertice destino){
        this.origem = origem;
        this.destino = destino;
    }

    public Vertice getOrigem(){
        return this.origem;
    }

    public Vertice getDestino(){
        return this.destino;
    }

}