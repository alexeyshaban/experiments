package interview.trees;

import static org.junit.Assert.assertEquals;
import interview.collections.Entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BSTFromListTest {

	@Test
    public void test() throws Exception {
		Entry<Integer> first = new Entry<>(1);
		first.next(2).next(3).next(4).next(5).next(6).next(7).next(8);
		Node root = new BSTFromList(first).build(0, 7);
		
		System.out.println(root);
		assertEquals(new Node(4,
				new Node(2, new Node(1), new Node(3)),
				new Node(6, new Node(5), new Node(7, null, new Node(8)))), root);
    }
}
