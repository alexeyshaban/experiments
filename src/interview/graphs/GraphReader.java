package interview.graphs;

import java.io.BufferedReader;
import java.io.IOException;

class GraphReader {

    static Graph read(BufferedReader r) throws NumberFormatException, IOException {
    	Graph G = new Graph(Integer.valueOf(r.readLine()));
    	int e = Integer.valueOf(r.readLine());
        for (int i = 0; i < e; i++) {
        	System.out.println(i);
        	String[] l = r.readLine().split(" ");
            G.addEdge(Integer.valueOf(l[0]), Integer.valueOf(l[1]));
        }
        return G;
    }
}
