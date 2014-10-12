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
		Node newNode = new Node(id, dd);
		if(root == null)
			root = newNode;
		else{
			Node current = root;
			Node parent;
			while(true){
				parent = current;
				if(id < current.iData){
					current = current.leftChild;
					if(current == null){
						parent.leftChild = newNode;
						return;
					}
				}else{
					current = current.rightChild;
					if(current == null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public void traverse(int traverseType) {
		switch(traverseType){
		case 1:
			System.out.println("Trawersowanie w porz¹dku 'preorder': ");
			preOrder(root);
			break;
		case 2:
			System.out.println("Trawersowanie w porz¹dku 'inorderd': ");
			inOrder(root);
			break;
		case 3:
			System.out.println("Trawersowanie w porz¹dku 'postorder");
			postOrder(root);
			break;
		
		}
	}

	private void preOrder(Node localRoot) {
		if(localRoot != null){
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	
	private void inOrder(Node localRoot) {
		if(localRoot != null){
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
			
		}
	}
	
	private void postOrder(Node localRoot){
		if(localRoot != null){
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
		}
	}

}
