package interview.graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    int V;
    int E;
    List<Integer>[] adj;
    
    @SuppressWarnings("unchecked")
	public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }


    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges \n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append('\n');
        }
        return s.toString();
    }
}