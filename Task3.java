
import java.util.Scanner;

// Student Node
class StudentNode {
    int studentID;
    String studentName;

    StudentNode left;
    StudentNode right;

    StudentNode(int id, String name) {
        studentID = id;
        studentName = name;
        left = null;
        right = null;
    }
}

// Student Binary Search Tree
class StudentBST {

    StudentNode root;

    // Insert student record
    StudentNode insert(StudentNode current, int id, String name) {

        if (current == null) {
            return new StudentNode(id, name);
        }

        if (id < current.studentID) {
            current.left = insert(current.left, id, name);
        }
        else if (id > current.studentID) {
            current.right = insert(current.right, id, name);
        }
        else {
            System.out.println("Student ID already exists!");
        }

        return current;
    }

    // Search student by ID
    StudentNode search(StudentNode current, int id) {

        if (current == null || current.studentID == id) {
            return current;
        }

        if (id < current.studentID) {
            return search(current.left, id);
        }
        else {
            return search(current.right, id);
        }
    }

    // Find minimum node
    StudentNode findMin(StudentNode current) {

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // Delete student record
    StudentNode delete(StudentNode current, int id) {

        if (current == null) {
            return null;
        }

        if (id < current.studentID) {
            current.left = delete(current.left, id);
        }
        else if (id > current.studentID) {
            current.right = delete(current.right, id);
        }
        else {

            // Node has no child
            if (current.left == null && current.right == null) {
                return null;
            }

            // Node has only right child
            if (current.left == null) {
                return current.right;
            }

            // Node has only left child
            if (current.right == null) {
                return current.left;
            }

            // Node has two children
            StudentNode successor = findMin(current.right);

            current.studentID = successor.studentID;
            current.studentName = successor.studentName;

            current.right = delete(current.right, successor.studentID);
        }

        return current;
    }

    // Display records in ascending order
    void display(StudentNode current) {

        if (current == null) {
            return;
        }

        display(current.left);

        System.out.println("Student ID: " + current.studentID
                + " | Name: " + current.studentName);

        display(current.right);
    }

    // Count total student records
    int count(StudentNode current) {

        if (current == null) {
            return 0;
        }

        return 1 + count(current.left) + count(current.right);
    }
}

// Main Class
public class Task3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentBST bst = new StudentBST();

        int choice;

        do {
            System.out.println("\n===== STUDENT RECORD MANAGEMENT SYSTEM =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Search Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Count Total Students");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    if (bst.search(bst.root, id) != null) {
                        System.out.println("Student ID already exists!");
                    }
                    else {
                        bst.root = bst.insert(bst.root, id, name);
                        System.out.println("Student inserted successfully!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Student ID to search: ");
                    int searchID = sc.nextInt();

                    StudentNode found = bst.search(bst.root, searchID);

                    if (found != null) {
                        System.out.println("Student Found!");
                        System.out.println("Student ID: " + found.studentID);
                        System.out.println("Student Name: " + found.studentName);
                    }
                    else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteID = sc.nextInt();

                    if (bst.search(bst.root, deleteID) != null) {
                        bst.root = bst.delete(bst.root, deleteID);
                        System.out.println("Student deleted successfully!");
                    }
                    else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    if (bst.root == null) {
                        System.out.println("No student records available.");
                    }
                    else {
                        System.out.println("\nStudent Records (Ascending Order):");
                        bst.display(bst.root);
                    }
                    break;

                case 5:
                    System.out.println("Total Student Records: "
                            + bst.count(bst.root));
                    break;

                case 6:
                    System.out.println("Exiting Student Management System...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
