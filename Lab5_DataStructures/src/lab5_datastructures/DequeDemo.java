/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5_datastructures;

/**
 *
 * @author Qayam
 */

public class DequeDemo {
    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public DequeDemo(int capacity) {
        this.capacity = capacity;
        this.deque = new int[capacity];
        this.front = -1;
        this.rear = 0;
        this.size = 0;
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull()  { return size == capacity; }

    public void insertFront(int value) {
        if (isFull()) { System.out.println("Deque is full."); return; }
        if (front == -1) { front = 0; rear = 0; }
        else front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        size++;
        System.out.println("Inserted at front: " + value);
    }

    public void insertRear(int value) {
        if (isFull()) { System.out.println("Deque is full."); return; }
        if (front == -1) { front = 0; rear = 0; }
        else rear = (rear + 1) % capacity;
        deque[rear] = value;
        size++;
        System.out.println("Inserted at rear: " + value);
    }

    public void deleteFront() {
        if (isEmpty()) { System.out.println("Deque is empty."); return; }
        System.out.println("Deleted from front: " + deque[front]);
        if (front == rear) { front = -1; rear = -1; }
        else front = (front + 1) % capacity;
        size--;
    }

    public void deleteRear() {
        if (isEmpty()) { System.out.println("Deque is empty."); return; }
        System.out.println("Deleted from rear: " + deque[rear]);
        if (front == rear) { front = -1; rear = -1; }
        else rear = (rear - 1 + capacity) % capacity;
        size--;
    }

    public void display() {
        if (isEmpty()) { System.out.println("Deque is empty."); return; }
        System.out.print("Deque: ");
        for (int i = 0; i < size; i++) {
            System.out.print(deque[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DequeDemo dq = new DequeDemo(5);
        dq.insertFront(10);
        dq.insertRear(20);
        dq.insertFront(5);
        dq.insertRear(30);
        dq.display();
        dq.deleteFront();
        dq.deleteRear();
        dq.display();
    }
}