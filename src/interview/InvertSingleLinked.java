package interview;

public class InvertSingleLinked {

	static <T> Entry<T> invert(Entry<T> head) {
		Entry<T> prev = null, current = head;
		while (current != null) {
	        Entry<T> next = current.next;
	        current.next = prev;
	        prev = current;
	        current = next;
        }
		return prev;
	}
	
	static <T> Entry<T> invertRecursive(Entry<T> head) {
		if (head == null || head.next == null) {
	        return head;
        }
		Entry<T> remainder = invertRecursive(head.next);
		head.next.next = head;
		head.next = null;
		return remainder;
	}
}
