package interview;

import java.util.Stack;

public class StackBasedQueue<T> {

	Stack<T> s = new Stack<>();
	
	StackBasedQueue<T> enqueue(T t) {
		s.push(t);
		return this;
	}
	
	T dequeue() {
		Stack<T> tmp = new Stack<>();
		while (!s.isEmpty()) {
			tmp.push(s.pop());
		}
		T result = tmp.pop();
		while (!tmp.isEmpty()) {
			s.push(tmp.pop());
		}
		return result;
	}
}
