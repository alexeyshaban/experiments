package interview.collections;

import java.util.Stack;

public class StackBasedQueue<T> {

	Stack<T> newest = new Stack<>();
	Stack<T> oldest = new Stack<>();
	
	StackBasedQueue<T> enqueue(T t) {
		newest.push(t);
		return this;
	}
	
	T dequeue() {
		if (!oldest.isEmpty()) {
			return oldest.pop();
		}
		while (!newest.isEmpty()) {
			oldest.push(newest.pop());
		}
		return oldest.pop();
	}
}
