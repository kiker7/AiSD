package rbtree;


public class RedBlackTree<K extends Comparable<K>, V> implements MapInterface<K, V> {

    private enum Color {

        RED, BLACK
    };
    private Node root;

    @Override
    public void setValue(K key, V value) {
        if (root == null) {
            root = new Node(key, value, Color.BLACK);
        }

        Node current = root;
        int cmp;
        while (current != null) {
            cmp = key.compareTo(current.key);
            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                current.val = value;
            }
        }

        current = new Node(key, value, Color.RED);

        if (isRed(current.right) && !isRed(current.left)) {
            current = rotateLeft(current);
        }
        if (isRed(current.left) && isRed(current.left.left)) {
            current = rotateRight(current);
        }
        if (isRed(current.left) && isRed(current.right)) {
            flipColors(current);
        }
    }

    @Override
    public V getValue(K key) {
        return get(root, key);
    }

    private class Node {

        private K key;
        private V val;
        private Node left, right;
        private Color color;

        public Node(K key, V val, Color color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }

        @Override
        public String toString() {
            return key.toString() + " " + ((color == Color.RED) ? "R" : "B");
        }

    }

    private V get(Node x, K key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.val;
            }
        }
        return null;
    }

    private Node rotateRight(Node h) {

        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = Color.RED;

        return x;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = Color.RED;

        return x;
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return (x.color == Color.RED);
    }

    private void flipColors(Node h) {
        h.color = (isRed(h)) ? Color.BLACK : Color.RED;
        h.left.color = (isRed(h.left)) ? Color.BLACK : Color.RED;
        h.right.color = (isRed(h.right)) ? Color.BLACK : Color.RED;
    }

    public boolean contains(K key) {
        return (get(root, key) != null);
    }

//    public void delete(K key) {
//        if (!contains(key)) {
//            System.err.println("symbol table does not contain " + key);
//            return;
//        }
//
//        // if both children of root are black, set root to red
//        if (!isRed(root.left) && !isRed(root.right)) {
//            root.color = Color.RED;
//        }
//
//        root = delete(root, key);
//        if (!(root == null)) {
//            root.color = Color.BLACK;
//        }
//        // assert check();
//    }
}
