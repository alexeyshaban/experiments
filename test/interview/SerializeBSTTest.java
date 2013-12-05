package interview;

import static org.junit.Assert.*;

import java.util.List;

import interview.SerializeBST.Node;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SerializeBSTTest {

	@Test
    public void test() throws Exception {
		Node root = new Node(10,
				new Node(5, null, new Node(7,
						new Node(6), new Node(8))), 
				new Node(20,
						new Node(11), new Node(25)));
		List<Integer> list = SerializeBST.serialize(root);
		Integer[] actuals = list.toArray(new Integer[]{});
		assertArrayEquals(new Integer[]{10, 5, 7, 6, 8, 20, 11, 25}, actuals);
		
		assertEquals(root, SerializeBST.deserialize(list));
    }
}
