package interview.graphs;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GraphClonerTest {

	@Test
	public void test() throws Exception {
		try (BufferedReader r = new BufferedReader(new InputStreamReader(
				new URL("http://algs4.cs.princeton.edu/41undirected/tinyG.txt")
						.openStream()))) {
			Graph G = GraphReader.read(r);
			System.out.println(G);
			
			Graph clone = GraphCloner.cloneInternal(G);
			checkClone(G, clone);
			
			clone = GraphCloner.cloneDFS(G);
			checkClone(G, clone);

		}
	}

	private void checkClone(Graph G, Graph clone) {
		assertEquals(G.V, clone.V);
		assertEquals(G.E, clone.E);
		for (int i = 0; i < G.V; i++) {
			Object[] expected = G.adj[i].toArray();
			Object[] actual = clone.adj[i].toArray();
			Arrays.sort(expected);
			Arrays.sort(actual);
			assertArrayEquals(expected, actual);
		}
	}

}
