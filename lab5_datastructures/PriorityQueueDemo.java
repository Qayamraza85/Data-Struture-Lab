/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5_datastructures;

/**
 *
 * @author Qayam
 */ 

class PQElement {
    int value;
    int priority;

    PQElement(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}

public class PriorityQueueDemo {
    private PQElement[] heap;
    private int size;
    private int capacity;

    public PriorityQueueDemo(int capacity) {
        this.capacity = capacity;
        this.heap = new PQElement[capacity];
        this.size = 0;
    }

    // Lower priority number = higher priority
    public void insert(int value, int priority) {
        if (size == capacity) {
            System.out.println("Priority Queue is full.");
            return;
        }
        PQElement newElement = new PQElement(value, priority);
        heap[size] = newElement;
        int i = size;
        size++;

        // Bubble up (min-heap by priority)
        while (i > 0 && heap[(i - 1) / 2].priority > heap[i].priority) {
            PQElement temp = heap[i];
            heap[i] = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
        System.out.println("Inserted: value=" + value + ", priority=" + priority);
    }

    public PQElement remove() {
        if (size == 0) {
            System.out.println("Priority Queue is empty.");
            return null;
        }
        PQElement removed = heap[0];
        heap[0] = heap[size - 1];
        size--;

        // Bubble down
        int i = 0;
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && heap[left].priority < heap[smallest].priority)
                smallest = left;
            if (right < size && heap[right].priority < heap[smallest].priority)
                smallest = right;

            if (smallest == i) break;

            PQElement temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            i = smallest;
        }
        System.out.println("Removed: value=" + removed.value + ", priority=" + removed.priority);
        return removed;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Priority Queue is empty.");
            return;
        }
        System.out.println("Priority Queue elements (value[priority]):");
        // Display in priority order (copy & sort for readability)
        PQElement[] copy = new PQElement[size];
        System.arraycopy(heap, 0, copy, 0, size);
        java.util.Arrays.sort(copy, (a, b) -> a.priority - b.priority);
        for (PQElement e : copy) {
            System.out.println("  " + e.value + " [" + e.priority + "]");
        }
    }

    public static void main(String[] args) {
        PriorityQueueDemo pq = new PriorityQueueDemo(10);
        pq.insert(10, 3);
        pq.insert(20, 1);
        pq.insert(30, 2);
        pq.insert(40, 1);
        pq.display();
        System.out.println("--- Removing by priority ---");
        pq.remove();
        pq.remove();
        pq.display();
    }
}
