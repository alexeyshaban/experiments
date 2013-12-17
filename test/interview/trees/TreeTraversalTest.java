package interview.trees;

import static org.junit.Assert.assertArrayEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TreeTraversalTest {

	@Test
    public void inOrderIterative() throws Exception {
		Node root = createTree();
		ListVisitor v = new ListVisitor();
		TreeTraversal.inOrderIterative(root, v);
		assertArrayEquals(new Integer[] {4, 3, 6, 5, 7, 2, 1, 8, 9}, v.result.toArray());
    }
	
	@Test
    public void preOrderIterative() throws Exception {
		Node root = createTree();
		ListVisitor v = new ListVisitor();
		TreeTraversal.preOrderIterative(root, v);
		assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, v.result.toArray());
		
		v = new ListVisitor();
		TreeTraversal.preOrderIterativeLikeRecursion(root, v);
		assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, v.result.toArray());
    }

	@Test
    public void postOrderIterative() throws Exception {
		Node root = createTree();
		ListVisitor v = new ListVisitor();
		TreeTraversal.postOrderIterative(root, v);
		assertArrayEquals(new Integer[] {4, 6, 7, 5, 3, 2, 9, 8, 1}, v.result.toArray());
    }
	
	private Node createTree() {
		return new Node(1, 
				new Node(2, 
						new Node(3, new Node(4), new Node(5, new Node(6), new Node(7))),
						null), 
				new Node(8, null, new Node(9)));
	}

	static class ListVisitor implements TreeTraversal.Visitor {
		List<Integer> result = new LinkedList<Integer>();
		@Override
		public void visit(Node node) {
			result.add(node.value);
		}
	}
}
