
class Node {
    int data;
    Node left;
    Node right;

    // Constructor
    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class BinarySearchTree {
    Node root;

    // Insert a new value into BST
    Node insert(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.data) {
            current.left = insert(current.left, value);
        } 
        else if (value > current.data) {
            current.right = insert(current.right, value);
        }

        return current;
    }

    // Inorder: Left, Root, Right
    void inorder(Node current) {

        if (current == null) {
            return;
        }

        inorder(current.left);
        System.out.print(current.data + " ");
        inorder(current.right);
    }

    // Preorder: Root, Left, Right
    void preorder(Node current) {

        if (current == null) {
            return;
        }

        System.out.print(current.data + " ");
        preorder(current.left);
        preorder(current.right);
    }

    // Postorder: Left, Right, Root
    void postorder(Node current) {

        if (current == null) {
            return;
        }

        postorder(current.left);
        postorder(current.right);
        System.out.print(current.data + " ");
    }

    // Find minimum value
    int findMin() {

        Node current = root;

        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    // Find maximum value
    int findMax() {

        Node current = root;

        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }
}

// Main class
public class Task1 {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        // Values to insert into BST
        int[] values = {45, 25, 65, 15, 35, 55, 75, 10, 20};

        // Insert all values
        for (int value : values) {
            bst.root = bst.insert(bst.root, value);
        }

        // Display inorder traversal
        System.out.println("Inorder Traversal:");
        bst.inorder(bst.root);

        // Display preorder traversal
        System.out.println("\n\nPreorder Traversal:");
        bst.preorder(bst.root);

        // Display postorder traversal
        System.out.println("\n\nPostorder Traversal:");
        bst.postorder(bst.root);

        // Display minimum and maximum
        System.out.println("\n\nMinimum Value: " + bst.findMin());
        System.out.println("Maximum Value: " + bst.findMax());
    }
}
