import java.util.List;
import java.util.ArrayList;

public class Grafo {

    List<Vertice> vertices;
    List<Aresta> arestas;

    public Grafo() {
        vertices = new ArrayList<Vertice>();
        arestas = new ArrayList<Aresta>();
    }

    public Vertice addVertice(Vertice v) {
        v = new Vertice(v.getId(), v.getX(), v.getY());
        vertices.add(v);
        return v;
    }

    public Aresta addAresta(Vertice origem, Vertice destino) {
        Aresta e = new Aresta(origem, destino);
        arestas.add(e);
        return e;
    }

    public String arestasToString(){
        String s = "";
        for(Aresta a: arestas){
            s += "{" + a.getDestino().getId() +" , " +a.getOrigem().getId() + "}";
        }
        return s;
    }

    public String toString() {
        String r = "";

        for (Vertice u : vertices) {
            r+= String.format("%s (%d,%d) -> ", u.getId(), u.getX(), u.getY());
            //r += u.getId() + " " + u.getX() +" -> ";

            for (Aresta e : u.getArestas()) {
                Vertice v = e.getDestino();
                r += v.getId() + ", ";
            }

            r += "\n";

        }

        return r;
    }

    public void ligarArestas(){
        for(Vertice v : vertices){
            for(Aresta a : arestas){
                if(v.getId()==a.getOrigem().getId()){
                    v.getArestas().add(a);
                }
            }
        }
    }
}