package tree;

import java.util.Stack;

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

	public void insert(int id, double dd) {
		Node newNode = new Node(id, dd);
		if (root == null)
			root = newNode;
		else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (id < current.iData) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public void traverse(int traverseType) {
		switch (traverseType) {
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
		if (localRoot != null) {
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	private void inOrder(Node localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);

		}
	}

	private void postOrder(Node localRoot) {
		if (localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
		}
	}

	public void displayTree() {
		Stack<Node> globalStack = new Stack<Node>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("...............................................");
		while(isRowEmpty == false){
			Stack<Node> localStack = new Stack<Node>();
			isRowEmpty = true;
			for(int j =0 ; j < nBlanks; j++)
				System.out.println(" ");
			while(globalStack.isEmpty() == false){
				Node temp = globalStack.pop();
				if(temp != null){
					System.out.print(temp.iData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if(temp.leftChild != null || temp.rightChild != null)
						isRowEmpty = false;
				}else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j =0 ; j < nBlanks*2 - 2; j++)
					System.out.print(" ");
			}
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		} System.out.println("...............................................");
	}

	public boolean delete(int key) {
		// ZAK£ADAMY ¯E DRZEWO NIE JEST PUSTE
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		while (current.iData != key) { // SZUKANIE WEZ£A
			parent = current;
			if (key < current.iData) { // CZY W LEWO
				isLeftChild = true;
				current = current.leftChild;
			} else { // CZY W PRAWO
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null)
				return false;
		}
		// ZNALEZIONO WEZEL DO USUNIECIA
		// JESLI NIE MA POTOMKOW, USUWAMY WEZEL
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root)
				root = null;
			else if (isLeftChild)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}
		// JESLI BRAK PRAWEGO POTOMKA ZASTEPUJEMY WEZEL LEWYM PODDRZEWEM
		else if (current.rightChild == null)
			if (current == root)
				root = current.leftChild;
			else if (isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		// JESLI BRAK LEWEGO POTOMKA ZASTEPUJEMY WEZEL PRAWYM PODDRZEWEM
		else if (current.leftChild == null)
			if (current == root)
				root = current.rightChild;
			else if (isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		// WEZEL MA DWA POTOMKI ZASTEPUJE SIE GO JEGO NASTEPNIKIEM
		else {
			// OKRESLENIE NASTEPNIKA USUWANEGO WEZLA
			Node successor = getSuccessor(current);
			// £ACZY SIE RODZICA WEZLA CURRENT Z SUCCESSOR
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			// DOLACZENIE NASTEPNIKA DO WEZLA CURRENT JAKO LEWEGO POTOMKA
			successor.leftChild = current.leftChild;
		}
		return true;
	}

	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		// JESLI NASTEPNIK NIE JEST PRAWYM POTOMKIEM
		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

}
