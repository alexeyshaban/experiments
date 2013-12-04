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
		Node<T> prev = null, current = head;
		while (current != null) {
	        Node<T> next = current.next;
	        current.next = prev;
	        prev = current;
	        current = next;
        }
		return prev;
	}
	
	static <T> Node<T> invertRecursive(Node<T> head) {
		if (head == null || head.next == null) {
	        return head;
        }
		Node<T> remainder = invertRecursive(head.next);
		head.next.next = head;
		head.next = null;
		return remainder;
	}
}
