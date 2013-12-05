package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SerializeBST {
	
	static class Node {
		int value;
		Node left;
		Node right;
		public Node(int value) {
	        this.value = value;
        }
		
		public Node(int value, Node left, Node right) {
	        this.value = value;
	        this.left = left;
	        this.right = right;
        }

		@Override
        public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((left == null) ? 0 : left.hashCode());
	        result = prime * result + ((right == null) ? 0 : right.hashCode());
	        result = prime * result + value;
	        return result;
        }
		@Override
        public boolean equals(Object obj) {
	        if (this == obj)
		        return true;
	        if (obj == null)
		        return false;
	        if (getClass() != obj.getClass())
		        return false;
	        Node other = (Node) obj;
	        if (left == null) {
		        if (other.left != null)
			        return false;
	        } else if (!left.equals(other.left))
		        return false;
	        if (right == null) {
		        if (other.right != null)
			        return false;
	        } else if (!right.equals(other.right))
		        return false;
	        if (value != other.value)
		        return false;
	        return true;
        }
		@Override
		public String toString() {
		    return value + " [l = " + left + ", r = " + right + "]";
		}
	}

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
