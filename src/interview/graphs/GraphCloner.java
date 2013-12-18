package interview.graphs;

import java.util.Stack;

public class GraphCloner {

    /**
     * Initializes a new graph that is a deep copy of <tt>G</tt>.
     * @param G the graph to copy
     */
    public static Graph cloneInternal(Graph src) {
        Graph g = new Graph(src.V);
        g.E = src.E;
        for (int v = 0; v < src.V; v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : src.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                g.adj[v].add(w);
            }
        }
        return g;
    }
    
    public static Graph cloneDFS(Graph src) {
    	Graph g = new Graph(src.V);
    	if (src.E > 0) {
    		boolean[] visited = new boolean[src.V];
    		for (int i = 0; i < visited.length; i++) {
				if (!visited[i]) {
					clone(src, g, i, visited);
				}
			}
		}
    	return g;
    }

	private static void clone(Graph from, Graph to, int v, boolean[] visited) {
		if (!visited[v]) {
			visited[v] = true;
			for (int w : from.adj(v)) {
				if (!to.adj[v].contains(w)) { // optimize?
					to.addEdge(v, w);
				}
				clone(from, to, w, visited);
			}
		}
		
	}
}
