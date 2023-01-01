
public class BST {
	Node root;
	
	public BST() {
		root = null;
	}
	public void insert(int value) {
		root = insertValue(value, root);
		
		/*
		 * if(root == null) { root = new Node(value); }else { Node it = root; Node itp =
		 * null; while(it != null) { itp= it; if(it.value < value) { it =it.right; }else
		 * if(value < it.value) { it = it.left; } } it = new Node(value); if(it.value
		 * <itp.value) { itp.left = it; }else if(it.value > itp.value) { itp.right = it;
		 * }
		 */
		}
	
	public Node insertValue(int value, Node curroot) {
		
		if(curroot == null) {
			curroot = new Node(value);
			return curroot;
		}
		
		if(value > curroot.value) {
			curroot.right = insertValue(value, curroot.right);
		}else if(value < curroot.value) {
			curroot.left = insertValue(value, curroot.left);
		}
		return curroot;
	}
	
	
	public void preOrder() {
		 preOrderValues(root);
	}
	
	
	private void preOrderValues(Node currRoot) {
			// TODO Auto-generated method stub
		if(currRoot != null) {
			System.out.println(currRoot.value +",");
			preOrderValues(currRoot.left );
			preOrderValues(currRoot.right );
			
	}
	}
	public void inOrder() {
			 inOrderValues(root);
		}
		

	private void inOrderValues(Node currRoot) {
		if(currRoot != null) {
			inOrderValues(currRoot.left );
			System.out.println(currRoot.value +",");
			inOrderValues(currRoot.right );
			
	}	
	}
	public void postOrder() {	
		 postOrderValues(root);
	}
	

	private void postOrderValues(Node currRoot) {
		if(currRoot != null) {
			postOrderValues(currRoot.left );
			postOrderValues(currRoot.right );
			System.out.println(currRoot.value +",");
		
		}	
	}
	public void smallestValue() {
		
		if(root != null) {
			Node it = root;
			while(it.left != null) {
				it = it.left;
			}
			System.out.println(it.value);
		}else
			System.out.println("BST EMpty");
	}
	public void largestValue() {
		
		if(root != null) {
			Node it = root;
			while(it.right != null) {
				it = it.right;
			}
			System.out.println(it.value);
		}else
			System.out.println("BST EMpty");
	}
	public void search(int value) {
		Boolean isInBst = searchValue(value, root);
		if(isInBst) {
			System.out.println("It is in Bst");
		}else
			System.out.println("Not in Bst");
	}
	
	private Boolean searchValue(int value, Node currRoot) {
		if(currRoot == null) {
			return false;
		}else {
			if(currRoot.value == value) {
				return true;
			}else if(currRoot.value > value) {
				return searchValue(value, currRoot.left);
			}else {
				return searchValue(value, currRoot.right);
			}
		}
		
	}
	
	public void printPathTo(int value) {
		Boolean isInBst = printPathToValues(value, root);
		if(isInBst) {
			System.out.println("It is in Bst");
		}else
			System.out.println("Not in Bst");
	}
	private Boolean printPathToValues(int value, Node currRoot) {
		if(currRoot != null) {
			if(currRoot.value == value) {
				return true;
			}else if(currRoot.value > value) {
				return printPathToValues(value, currRoot.left);
			}else {
				return printPathToValues(value, currRoot.right);
			}
		}
		return false;
		
	}
	
	public void deleteNode(int value) {
		deleteNodvalues(value, root);
	}
	private Node deleteNodvalues(int value, Node currNode) {
		if(currNode == null) {
			return null;
		}else if(currNode.value < value) {
			currNode.right = deleteNodvalues(value, currNode.right);
		}else if(value < currNode.value) {
			currNode.left = deleteNodvalues(value, currNode.left);
		}else {
			if(currNode.left == null && currNode.right == null) {
				currNode = null;
				return null;
			}else if(currNode.left != null && currNode.right ==null) {
				return currNode.left;
			}else if(currNode.left == null && currNode.right != null) {
				return currNode.right;
			}else {
				currNode.value = minValueInRightTree(currNode.right);
				currNode.right = deleteNodvalues(currNode.value, currNode.right);
			}
			
			
		}
		return currNode;
	}
	private int minValueInRightTree(Node currNode) {
		int minValue = currNode.value;
		while(currNode.left != null) {
			minValue = currNode.value;
			currNode = currNode.left;
		}
		return minValue;
	}
}
