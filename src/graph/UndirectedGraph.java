package graph;

public class UndirectedGraph {
    int v;
    Edge edges[];

    public class Edge{
        int src,dest;
    }

    UndirectedGraph(int v,int e){
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge();
        }
    }

}
