package may18;

import java.util.concurrent.ThreadLocalRandom;

public class Treap {
    private Node root;

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root = root.add(value);
        }
    }

    public void remove(int value) {
        root = root.remove(value);
    }

    private class Node {
        private int value;
        private int priority;

        private Node leftChild;
        private Node rightChild;

        private Node(int value) {
            this.value = value;
            this.priority = ThreadLocalRandom.current().nextInt();
        }

        private Node(int value, int priority, Node leftChild, Node rightChild) {
            this.value = value;
            this.priority = priority;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        private Node merge(Node left, Node right) {
            if (left == null) return right;
            if (right == null) return left;

            if (left.priority > right.priority) {
                Node newR = merge(left.rightChild, right);
                return new Node(left.value, left.priority, left.leftChild, newR);
            } else {
                Node newL = merge(left, right.leftChild);
                return new Node(right.value, right.priority, newL, right.rightChild);
            }
        }

        private Node[] split(int value, Node left, Node right) {
            Node newNode = null;
            if (this.value <= value) {
                if (rightChild == null) {
                    right = null;
                } else {
                    Node[] nodes = rightChild.split(value, newNode, right);

                    right = nodes[1];
                    newNode = nodes[0];

                }
                left = new Node(this.value, priority, leftChild, newNode);
            } else {
                if (leftChild == null) {
                    left = null;
                } else {
                    Node[] nodes = leftChild.split(value, left, newNode);
                    left = nodes[0];
                    newNode = nodes[1];
                }
                right = new Node(this.value, priority, newNode, rightChild);
            }
            return new Node[]{left,right};
        }

        private Node add(int value) {
            Node[] nodes = split(value, null, null);

            Node left = nodes[0];
            Node right = nodes[1];
            Node node = new Node(value);
            return merge(merge(left, node), right);
        }

        private Node remove(int value) {
            Node[] nodes = split(value - 1, null, null);

            Node left = nodes[0];
            Node right = nodes[1];
            nodes = right.split(value, null, right);
            right = nodes[1];

            return merge(left, right);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (value != node.value) return false;
            if (priority != node.priority) return false;
            if (leftChild != null ? !leftChild.equals(node.leftChild) : node.leftChild != null) return false;
            return rightChild != null ? rightChild.equals(node.rightChild) : node.rightChild == null;
        }

        @Override
        public int hashCode() {
            int result = value;
            result = 31 * result + priority;
            result = 31 * result + (leftChild != null ? leftChild.hashCode() : 0);
            result = 31 * result + (rightChild != null ? rightChild.hashCode() : 0);
            return result;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Treap treap = (Treap) o;

        return root != null ? root.equals(treap.root) : treap.root == null;
    }

    @Override
    public int hashCode() {
        return root != null ? root.hashCode() : 0;
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Эмиль лох");
        }
    }
}