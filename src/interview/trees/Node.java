package interview.trees;

public class Node {
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