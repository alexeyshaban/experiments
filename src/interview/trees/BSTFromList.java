package interview.trees;

import interview.collections.Entry;

public class BSTFromList {
	
	private Entry<Integer> e;
	
	protected BSTFromList(Entry<Integer> e) {
		this.e = e;
	}


	Node build(int lo, int hi) {
		if (lo > hi || e == null) {
			return null;
		}
		int mid = lo + (hi - lo) / 2;
		Node left = build(lo, mid - 1);
		Node current = new Node(e.value);
		current.left = left;
		e = e.next;
		current.right = build(mid + 1, hi);
		return current;
	}
}
