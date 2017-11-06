package may18;

/**
 * Code for studying purposes. Programming course. Kazan Federal University,
 * ITIS. http://study.istamendil.info/
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class Bst<T> {
    public static void main(String[] args) {
        Bst<String> tree = new Bst<>();
    }

    protected Node<T> root;

    public Bst() {
    }

    public Node getRoot() {
        return this.root;
    }

    public Node findByKey(int key) {
        if (this.getRoot() == null) {
            return null;
        }
        return findByKey(this.getRoot(), key);
    }

    public Node findMin() {
        if (this.getRoot() == null) {
            return null;
        }
        return findMin(this.getRoot());
    }

    // Or throw exception about key duplication
    public Node add(T value, int key) {
        Node<T> newNode = new Node<>(key, value);
        if (this.getRoot() == null) {
            this.root = newNode;
            return this.getRoot();
        } else {
            return addNode(this.getRoot(), newNode);
        }
    }

    public void remove(int k) {
        Node<T> x = root;
        Node<T> y = null;

        while (x != null) {
            if (k == x.getKey()) break;

            y = x;
            if (k < x.getKey()) x = x.left;
            else x = x.right;
        }
        if (x == null) return;

        if (x.right == null) {
            if (y == null) {
                root = x.left;
            } else {
                if (x == y.left) y.left = x.left;
                else y.right = x.left;
            }
        } else if (x.left == null) {
            if (y == null) {
                root = x.right;
            } else {
                if (x == y.right) y.right = x.right;
                else y.left = x.right;
            }
        } else {
            Node<T> leftMost = x.right;
            y = null;
            while (leftMost.left != null) {
                y = leftMost;
                leftMost = leftMost.left;
            }
            if (y != null) y.left = leftMost.right;
            else x.right = leftMost.right;

            x.key = leftMost.key;
            x.value = leftMost.value;
        }
    }

    protected static class Node<T> {

        protected int key;
        protected T value;

        protected Node<T> left;
        protected Node<T> right;

        public Node(int key, T value) {
            if (value == null) {
                throw new IllegalArgumentException("Value of a node can't be NULL.");
            }

            this.key = key;
            this.value = value;
        }

//ToDo: implement hashCode and equals

        public int getKey() {
            return key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            if (this.equals(left)) {
                throw new IllegalArgumentException("Can't add as child node to himself.");
            }
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            if (this.equals(left)) {
                throw new IllegalArgumentException("Can't add as child node to himself.");
            }
            this.right = right;
        }

        public T getValue() {
            return value;
        }
    }

    protected static Node findByKey(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (node.getKey() == key) {
            return node;
        } else if (node.getKey() > key) {
            return findByKey(node.getLeft(), key);
        } else {
            return findByKey(node.getRight(), key);
        }
    }

    protected static Node findMin(Node node) {
        if (node == null) {
            return null;
        }
        if (node.getLeft() != null) {
            return findMin(node.getLeft());
        } else {
            return node;
        }
    }

    protected static Node findMax(Node node) {
        if (node == null) {
            return null;
        }
        if (node.getRight() != null) {
            return findMax(node.getRight());
        } else {
            return node;
        }
    }

    protected static Node addNode(Node node, Node newNode) {
        if (node == null || newNode == null) {
            return null;
        }
        if (newNode.getKey() < node.getKey()) {
            if (node.getLeft() == null) {
                node.setLeft(newNode);
                return node;
            } else {
                return addNode(node.getLeft(), newNode);
            }
        } else if (newNode.getKey() > node.getKey()) {
            if (node.getRight() == null) {
                node.setRight(newNode);
                return node;
            } else {
                return addNode(node.getRight(), newNode);
            }
        } else {
            return null;// Return Null or throw exception about key duplication or add to Right
        }
    }

//ToDo: deletion
}
