package tree;

public class RBTree<K extends Comparable<K>, V> implements MapInterface <K, V> {


    private enum Color{
    	RED, BLACK
    };

    private Node root;     // root of the BST

    // BST helper node data type
    private class Node {
        private K key;           // key
        private V val;         // associated data
        private Node left, right;  // links to left and right subtrees
        private Color color;     // color of parent link
      

        public Node(K key, V val,Color color) {
            this.key = key;
            this.val = val;
            this.color = color;
           
        }


		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
        
    }
	
	
	
	
	
	
	@Override
	public void setValue(K key, V value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V getValue(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
