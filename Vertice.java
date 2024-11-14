import java.util.ArrayList;

public class Vertice{

    private String id;
    int x;
    int y;
    private ArrayList <Aresta> adj;


    public Vertice(String id, int x, int y){
        this.id = id;
        this.x = x;
        this.y = y;
        this.adj = new ArrayList <Aresta>();
    }

      public void addAdj(Aresta e) {
            adj.add(e);
            System.out.println(adj.size());
        }

    public String getId(){
        return this.id;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public ArrayList <Aresta> getArestas(){
        return adj;
    }

}