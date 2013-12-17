package interview.trees;

import java.util.Stack;

public class TreeTraversal {
	
	interface Visitor {
		void visit(Node node);
	}

	static void inOrderIterative(Node node, Visitor v) {
		Stack<Node> s = new Stack<>();
		while (!s.isEmpty() || node != null) {
			if (node != null) {
				s.push(node);
				node = node.left;
			} else {
				node = s.pop();
				v.visit(node);
				node = node.right;
			}
		}
	}
	
	static void preOrderIterative(Node node, Visitor v) {
		Stack<Node> s = new Stack<>();
		while (!s.isEmpty() || node != null) {
			if (node != null) {
				v.visit(node);
				s.push(node);
				node = node.left;
			} else {
				node = s.pop().right;
			}
		}
	}
	
	static void preOrderIterativeLikeRecursion(Node node, Visitor v) {
		Stack<Node> s = new Stack<>();
		s.push(node);
		while (!s.isEmpty()) {
			Node current = s.pop();
			v.visit(current);
			if (current.right != null) {
				s.push(current.right);
			}
			if (current.left != null) {
				s.push(current.left);
			}
		}
	}
	

	static void postOrderIterative(Node node, Visitor v) {
		Stack<Node> s = new Stack<>();
		Node lastVisited = null;
		while (!s.isEmpty() || node != null) {
			if (node != null) {
				s.push(node);
				node = node.left;
			} else {
				Node peek = s.peek();
				if (peek.right != null && peek.right != lastVisited) {
					node = peek.right;
				} else {
					s.pop();
					v.visit(peek);
					lastVisited = peek;
				}
			}
		}
	}
}
