/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5_datastructures;

/**
 *
 * @author Qayam
 */

import java.util.Scanner;

public class Lab5Menu {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== DATA STRUCTURES LAB 5 =====");
            System.out.println("1. Circular Queue");
            System.out.println("2. Priority Queue");
            System.out.println("3. Deque");
            System.out.println("4. Infix to Postfix");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: circularQueueMenu(); break;
                case 2: priorityQueueMenu(); break;
                case 3: dequeMenu();        break;
                case 4: infixToPostfixMenu(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    // ---------- Circular Queue ----------
    static void circularQueueMenu() {
        CircularQueue cq = new CircularQueue(5);
        int ch;
        do {
            System.out.println("\n--- Circular Queue (capacity 5) ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Back to main menu");
            System.out.print("Choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    cq.enqueue(sc.nextInt());
                    break;
                case 2: cq.dequeue(); break;
                case 3: 
                    int p = cq.peek();
                    if (p != -1) System.out.println("Front: " + p);
                    break;
                case 4: cq.display(); break;
                case 5: break;
                default: System.out.println("Invalid.");
            }
        } while (ch != 5);
    }

    // ---------- Priority Queue ----------
    static void priorityQueueMenu() {
        PriorityQueueDemo pq = new PriorityQueueDemo(10);
        int ch;
        do {
            System.out.println("\n--- Priority Queue ---");
            System.out.println("1. Insert");
            System.out.println("2. Remove (highest priority)");
            System.out.println("3. Display");
            System.out.println("4. Back to main menu");
            System.out.print("Choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    int v = sc.nextInt();
                    System.out.print("Enter priority (lower = higher priority): ");
                    int pr = sc.nextInt();
                    pq.insert(v, pr);
                    break;
                case 2: pq.remove(); break;
                case 3: pq.display(); break;
                case 4: break;
                default: System.out.println("Invalid.");
            }
        } while (ch != 4);
    }

    // ---------- Deque ----------
    static void dequeMenu() {
        DequeDemo dq = new DequeDemo(5);
        int ch;
        do {
            System.out.println("\n--- Deque (capacity 5) ---");
            System.out.println("1. Insert Front");
            System.out.println("2. Insert Rear");
            System.out.println("3. Delete Front");
            System.out.println("4. Delete Rear");
            System.out.println("5. Display");
            System.out.println("6. Back to main menu");
            System.out.print("Choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    dq.insertFront(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    dq.insertRear(sc.nextInt());
                    break;
                case 3: dq.deleteFront(); break;
                case 4: dq.deleteRear(); break;
                case 5: dq.display(); break;
                case 6: break;
                default: System.out.println("Invalid.");
            }
        } while (ch != 6);
    }

    // ---------- Infix to Postfix ----------
    static void infixToPostfixMenu() {
        System.out.print("\nEnter Infix Expression: ");
        String infix = sc.nextLine();
        String postfix = InfixToPostfix.infixToPostfix(infix);
        System.out.println("Infix Expression:  " + infix);
        System.out.println("Postfix Expression: " + postfix);
    }
}
