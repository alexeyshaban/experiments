package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SerializeBST {
	
	static List<Integer> serialize(Node root) {
		List<Integer> result = new ArrayList<>();
		serialize(root, result);
		return result;
	}

	private static void serialize(Node root, List<Integer> result) {
	    if (root == null) {
	        return;
        }
	    result.add(root.value);
	    serialize(root.left, result);
	    serialize(root.right, result);
    }
	
	static Node deserialize(List<Integer> list) {
		return deserialize(list.listIterator(), Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static Node deserialize(ListIterator<Integer> it, int minValue,
            int maxValue) {
	    if (!it.hasNext()) {
	        return null;
        }
	    int value = it.next();
	    Node current = null;
	    if (minValue < value && value < maxValue) {
	        current = new Node(value);
	        current.left = deserialize(it, minValue, value);
	        current.right = deserialize(it, value, maxValue);
        } else {
        	it.previous();
        }
	    return current;
    }
}
