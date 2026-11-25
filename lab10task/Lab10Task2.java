
public class Lab10Task2 {

    static class MaxHeap {

        int[] heap;
        int size;
        int capacity;

        // Constructor
        MaxHeap(int capacity) {
            this.capacity = capacity;
            heap = new int[capacity];
            size = 0;
        }

        // Parent index
        int parent(int i) {
            return (i - 1) / 2;
        }

        // Left child index
        int leftChild(int i) {
            return 2 * i + 1;
        }

        // Right child index
        int rightChild(int i) {
            return 2 * i + 2;
        }

        // Swap two elements
        void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        // Insert element into Max Heap
        void insert(int value) {

            if (size == capacity) {
                System.out.println("Max Heap is full!");
                return;
            }

            heap[size] = value;
            int current = size;
            size++;

            // Heapify Up
            while (current > 0 &&
                   heap[current] > heap[parent(current)]) {

                swap(current, parent(current));
                current = parent(current);
            }
        }

        // View maximum element
        int peek() {

            if (size == 0) {
                throw new IllegalStateException("Heap is empty");
            }

            return heap[0];
        }

        // Restore Max Heap after deletion
        void heapifyDown(int i) {

            int largest = i;

            int left = leftChild(i);
            int right = rightChild(i);

            if (left < size &&
                heap[left] > heap[largest]) {

                largest = left;
            }

            if (right < size &&
                heap[right] > heap[largest]) {

                largest = right;
            }

            if (largest != i) {

                swap(i, largest);

                heapifyDown(largest);
            }
        }

        // Remove maximum element
        int extractMax() {

            if (size == 0) {
                throw new IllegalStateException("Heap is empty");
            }

            int max = heap[0];

            heap[0] = heap[size - 1];
            size--;

            if (size > 0) {
                heapifyDown(0);
            }

            return max;
        }

        // Display Heap
        void display() {

            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }

            System.out.println();
        }

        // Return current size
        int getSize() {
            return size;
        }
    }

    // Main Method
    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap(10);

        int[] scores = {65, 92, 78, 85, 99, 70, 88};

        System.out.println("===== MAX HEAP =====");

        // Insert all scores
        for (int score : scores) {
            maxHeap.insert(score);
        }

        // Display Max Heap
        System.out.print("\nMax Heap Elements: ");
        maxHeap.display();

        // Peek highest score
        System.out.println(
            "Highest Score (Peek): " + maxHeap.peek()
        );

        // Extract Top 3 scores
        System.out.println("\n===== TOP 3 SCORES =====");

        System.out.println(
            "1st Highest Score: " + maxHeap.extractMax()
        );

        System.out.println(
            "2nd Highest Score: " + maxHeap.extractMax()
        );

        System.out.println(
            "3rd Highest Score: " + maxHeap.extractMax()
        );

        // Display remaining Heap
        System.out.print("\nRemaining Heap Elements: ");
        maxHeap.display();

        // Final size
        System.out.println(
            "Final Heap Size: " + maxHeap.getSize()
        );
    }
}
