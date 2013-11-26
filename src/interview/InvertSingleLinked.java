package interview;

public class InvertSingleLinked {

	static class Node<T> {
		T value;
		Node<T> next;
		public Node(T value, Node<T> next) {
	        this.value = value;
	        this.next = next;
        }
		@Override
		public String toString() {
		    return "[" + value +  " ("+ next + ")]";
		}
		
	}

	static <T> Node<T> invert(Node<T> head) {
		if (head == null) {
	        return null;
        }
		Node<T> first = null, last = null;
		while (true) {
			Node<T> current = head, prev = null;
			while (current.next != null) {
	            prev = current;
	            current = current.next;
            }
			if (first == null) {
	            first = last = current;
            } else {
            	last.next = current;
            	last = current;
            }
			if (prev == null) {
	            return first;
            }
			prev.next = null;
			System.out.println(first);
		}
	}
}
