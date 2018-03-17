package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {

    /**
     * https://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
     * O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
     * @param s
     */
    public void bfs(Graph g,int s){
        boolean[] visited = new boolean[g.graphSize()];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        System.out.println("BFS");
        while(!q.isEmpty()){
            int temp = q.poll();
            visited[temp] = true;
            System.out.print(" "+temp);
            for (int i: g.adjList[temp]) {
                if(!visited[i]) q.add(i);
            }
        }
    }

    public void dfs(Graph g, int s){
        boolean[] visited = new boolean[g.graphSize()];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        System.out.println("\n DFS");
        while(!stack.isEmpty()){
            int temp = stack.pop();
            visited[temp] = true;
            System.out.print(" "+temp);
            for (int i :g.adjList[temp]){
                if(!visited[i]) stack.push(i);
            }
        }
    }



    void DFSUtil(Graph g,int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = g.adjList[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(g,n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(Graph g,int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[g.graphSize()];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(g,v, visited);
    }

    public boolean detectCycleDirectedGraph(Graph g, int s){
        boolean[] visited = new boolean[g.graphSize()];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while(!stack.isEmpty()){
            int temp = stack.pop();
            if (visited[temp]) return true;
            visited[temp] = true;
            for (int i: g.adjList[temp]){
                stack.push(i);
            }
        }
        return false;
    }

//    public void topologicalSort(Graph g, int s){
//        boolean[] visited = new boolean[g.graphSize()];
//        for (int i = 0; i < g.graphSize(); i++) {
//            visited[i]=false;
//        }
//        Stack<Integer> stack = new Stack<>();
//        stack.push(s);
//        System.out.println("Topological sort");
//
//        for (Integer ele: g.adjList[s])
//             {
//                 if(!visited[ele]){
//                     stack.push(ele);
//                 }
//
//        }
//        while(!stack.isEmpty()){
//            System.out.println(stack.pop());
//        }
//    }

    void topologicalSortUtil(Graph g,int v, boolean visited[],
                             Stack stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> it =g.adjList[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(g,i, visited, stack);
        }

        // Push current vertex to stack which stores result
        stack.push(new Integer(v));
    }

    /**
     * https://www.geeksforgeeks.org/topological-sorting/
     * @param g
     */

    void topologicalSort(Graph g)
    {
        Stack stack = new Stack();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[g.graphSize()];
        for (int i = 0; i < g.graphSize(); i++)
            visited[i] = false;

        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (int i = 0; i < g.graphSize(); i++)
            if (visited[i] == false)
                topologicalSortUtil(g,i, visited, stack);

        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }


    //todo
//    https://www.geeksforgeeks.org/find-paths-given-source-destination/
    public static void main(String args[]){
//        Graph g = new Graph(5);
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);

        //for topological sort
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

//        g1.addEdge(1, 0);
//        g1.addEdge(0, 2);
//        g1.addEdge(2, 0);
//        g1.addEdge(0, 3);
//        g1.addEdge(3, 4);


        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        GraphTraversal graphTraversal = new GraphTraversal();
//        graphTraversal.bfs(g1,2);
//        graphTraversal.dfs(g1,2);
        System.out.println();
//        graphTraversal.DFS(g,2);
//        System.out.println(graphTraversal.detectCycleDirectedGraph(g2,0));

      graphTraversal.topologicalSort(g);
    }
}
