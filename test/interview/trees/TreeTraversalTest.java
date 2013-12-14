package interview.trees;

import static org.junit.Assert.*;
import interview.trees.TreeTraversal;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TreeTraversalTest {

	@Test
    public void inOrderIterative() throws Exception {
		Node root = createTree();
		List<Integer> list = TreeTraversal.inOrderIterative(root);
		assertArrayEquals(new Integer[] {4, 3, 6, 5, 7, 2, 1, 8, 9}, list.toArray());
    }
	
	@Test
    public void preOrderIterative() throws Exception {
		Node root = createTree();
		List<Integer> list = TreeTraversal.preOrderIterative(root);
		assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, list.toArray());
		list = TreeTraversal.preOrderIterativeStackOnly(root);
		assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, list.toArray());
    }
	
	private Node createTree() {
		return new Node(1, 
				new Node(2, 
						new Node(3, new Node(4), new Node(5, new Node(6), new Node(7))),
						null), 
				new Node(8, null, new Node(9)));
	}

}
