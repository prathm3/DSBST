
public class Node {
	Node right;
	 int value;
	 Node left;
	
	public Node(int value) {
		left = null;
		right= null;
		this.value= value;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}
	
}
