package datastructures;
class Node {
    int key;
    Node left;
    Node right;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

class BST {
    Node root;

    public BST() {
        this.root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.key) {
            return true;
        } else if (key < root.key) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversalRec(root);
    }

    private void inOrderTraversalRec(Node root) {
        if (root != null) {
            inOrderTraversalRec(root.left);
            System.out.print(root.key + " ");
            inOrderTraversalRec(root.right);
        }
    }

    public void preOrderTraversal() {
        preOrderTraversalRec(root);
    }

    private void preOrderTraversalRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrderTraversalRec(root.left);
            preOrderTraversalRec(root.right);
        }
    }

    public void postOrderTraversal() {
        postOrderTraversalRec(root);
    }

    private void postOrderTraversalRec(Node root) {
        if (root != null) {
            postOrderTraversalRec(root.left);
            postOrderTraversalRec(root.right);
            System.out.print(root.key + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();

        // Insert some elements into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Perform in-order traversal to print the elements in sorted order
        System.out.println("In-order traversal:");
        bst.inOrderTraversal();
        System.out.println();

        // Perform pre-order traversal
        System.out.println("Pre-order traversal:");
        bst.preOrderTraversal();
        System.out.println();

        // Perform post-order traversal
        System.out.println("Post-order traversal:");
        bst.postOrderTraversal();
        System.out.println();
    }
}
