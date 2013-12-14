package interview;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {

	static List<Integer> inOrderIterative(Node root) {
		List<Integer> result = new LinkedList<>();
		Stack<Node> s = new Stack<>();
		Node current = root;
		while (true) {
			while (current != null) {
				s.push(current);
				current = current.left;
			}
			if (s.isEmpty()) {
				break;
			} else {
				current = s.pop();
				result.add(current.value);
				current = current.right;
			}
		}
		return result;
	}
	
	static List<Integer> preOrderIterative(Node root) {
		List<Integer> result = new LinkedList<>();
		Stack<Node> s = new Stack<>();
		Node current = root;
		while (true) {
			while (current != null) {
				result.add(current.value);
				if (current.right != null) {
					s.push(current.right);
				}
				current = current.left;
			}
			if (s.isEmpty()) {
				break;
			} else {
				current = s.pop();
			}
		}
		return result;
	}
	
	static List<Integer> preOrderIterativeStackOnly(Node root) {
		List<Integer> result = new LinkedList<>();
		Stack<Node> s = new Stack<>();
		s.push(root);
		while (!s.isEmpty()) {
			Node current = s.pop();
			result.add(current.value);
			if (current.right != null) {
				s.push(current.right);
			}
			if (current.left != null) {
				s.push(current.left);
			}
		}
		return result;
	}
}
