package may11;

import java.util.ArrayList;
import java.util.List;

public class MyTree {
    private Node root;

    public MyTree() {
    }

    public MyTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean add(int parentValue, int childValue) {
        Node parent = findDepth(parentValue);
        return parent.setChild(new Node(childValue));
    }

    public Node findDepth(int value) {
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(root);
        return findDepth(value, nodeList);
    }

    private Node findDepth(int value, List<Node> parentsList) {
        for (Node node : parentsList) {
            if (node.value == value) return node;

            Node recurseNode = findDepth(value, node.child);
            if (recurseNode == null) {
                continue;
            } else {
                return recurseNode;
            }
        }

        return null;
    }

    public Node findBreadth(int value) {
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(root);
        return findBreadth(value, nodeList);
    }

    private Node findBreadth(int value, List<Node> parentsList) {
        List<Node> childrenList = new ArrayList<>();

        if (parentsList == null || parentsList.isEmpty()) {
            return null;
        }
        for (Node node : parentsList) {
            if (node.value == value) {
                return node;
            }

            childrenList.addAll(node.child);
        }
        return findBreadth(value, childrenList);
    }

    public static class Node {
        private int value;
        private List<Node> child;

        public Node() {
            child = new ArrayList<>();
        }

        public Node(int value) {
            this();
            this.value = value;
        }

        public Node(int value, List<Node> childrens) {
            this.value = value;
            this.child = childrens;
        }

        public boolean setChild(Node child) {
            return this.child.add(child);
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
