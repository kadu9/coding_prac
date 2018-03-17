package graph;

import java.util.LinkedList;

/**
 * Adjcency List representation for the graph
 */
public class Graph {
    int v;
    LinkedList<Integer> adjList[];

    Graph(int v){
        this.v = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w){
        adjList[v].add(w);
    }

    void removeEdge(int v,int w){
        adjList[v].remove(w);
    }

    public int graphSize(){
        return this.v;
    }
}
