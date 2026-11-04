
class Node2 {
    int data;
    Node2 left;
    Node2 right;

    Node2(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class BinarySearchTree2 {
    Node2 root;

    // Insert a value into BST
    Node2 insert(Node2 current, int value) {

        if (current == null) {
            return new Node2(value);
        }

        if (value < current.data) {
            current.left = insert(current.left, value);
        }
        else if (value > current.data) {
            current.right = insert(current.right, value);
        }

        return current;
    }

    // Search for a value
    boolean search(Node2 current, int value) {

        if (current == null) {
            return false;
        }

        if (current.data == value) {
            return true;
        }

        if (value < current.data) {
            return search(current.left, value);
        }
        else {
            return search(current.right, value);
        }
    }

    // Find the smallest node in a subtree
    Node2 findMinNode(Node2 current) {

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // Delete a node from BST
    Node2 delete(Node2 current, int value) {

        if (current == null) {
            return null;
        }

        if (value < current.data) {
            current.left = delete(current.left, value);
        }
        else if (value > current.data) {
            current.right = delete(current.right, value);
        }
        else {

            // Case 1: Node has no child (leaf node)
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: Node has only right child
            if (current.left == null) {
                return current.right;
            }

            // Case 2: Node has only left child
            if (current.right == null) {
                return current.left;
            }

            // Case 3: Node has two children
            Node2 successor = findMinNode(current.right);

            current.data = successor.data;

            current.right = delete(current.right, successor.data);
        }

        return current;
    }

    // Display inorder traversal
    void inorder(Node2 current) {

        if (current == null) {
            return;
        }

        inorder(current.left);
        System.out.print(current.data + " ");
        inorder(current.right);
    }
}

// Main class
public class Task2 {

    public static void main(String[] args) {

        BinarySearchTree2 bst = new BinarySearchTree2();

        // Insert the same values used in Task 1
        int[] values = {45, 25, 65, 15, 35, 55, 75, 10, 20};

        for (int value : values) {
            bst.root = bst.insert(bst.root, value);
        }

        // Search operation
        System.out.println("Searching Operations:");

        System.out.println("Search 35: " +
                (bst.search(bst.root, 35) ? "Found" : "Not Found"));

        System.out.println("Search 100: " +
                (bst.search(bst.root, 100) ? "Found" : "Not Found"));

        // Delete leaf node 10
        System.out.println("\nDeleting Leaf Node: 10");
        bst.root = bst.delete(bst.root, 10);

        System.out.println("Inorder after deleting 10:");
        bst.inorder(bst.root);

        // Delete node 25, which now has one child
        System.out.println("\n\nDeleting Node with One Child: 25");
        bst.root = bst.delete(bst.root, 25);

        System.out.println("Inorder after deleting 25:");
        bst.inorder(bst.root);

        // Delete root node 45, which has two children
        System.out.println("\n\nDeleting Node with Two Children: 45");
        bst.root = bst.delete(bst.root, 45);

        System.out.println("Inorder after deleting 45:");
        bst.inorder(bst.root);

        System.out.println("\n\nTask 2 Completed Successfully!");
    }
}
