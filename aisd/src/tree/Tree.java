package tree;

public class Tree {

	private Node root;

	public Tree() {
		root = null;
	}

	public Node find(int key) {
		Node current = root;
		while (current.iData != key) {
			if (key < current.iData)
				current = current.leftChild;
			else
				current = current.rightChild;
			if (current == null)
				return null;
		}
		return current;
	}
	
	public void insert(int id, double dd){
		
	}
	
	public void traverse(int traverseType){
		
	}
	private void preOrder(Node localRoot){
		
	}

}
