public class Lab10Task1 {

    static class MinHeap {

        int[] heap;
        int size;
        int capacity;

        // Constructor
        MinHeap(int capacity) {
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

        // Insert element into Min Heap
        void insert(int value) {

            if (size == capacity) {
                System.out.println("Heap is full!");
                return;
            }

            heap[size] = value;
            int current = size;
            size++;

            // Heapify Up
            while (current > 0 &&
                   heap[current] < heap[parent(current)]) {

                swap(current, parent(current));
                current = parent(current);
            }
        }

        // View smallest element
        int peek() {

            if (size == 0) {
                throw new IllegalStateException("Heap is empty");
            }

            return heap[0];
        }

        // Restore Min Heap after deletion
        void heapifyDown(int i) {

            int smallest = i;

            int left = leftChild(i);
            int right = rightChild(i);

            if (left < size &&
                heap[left] < heap[smallest]) {

                smallest = left;
            }

            if (right < size &&
                heap[right] < heap[smallest]) {

                smallest = right;
            }

            if (smallest != i) {

                swap(i, smallest);

                heapifyDown(smallest);
            }
        }

        // Remove smallest element
        int extractMin() {

            if (size == 0) {
                throw new IllegalStateException("Heap is empty");
            }

            int min = heap[0];

            heap[0] = heap[size - 1];
            size--;

            if (size > 0) {
                heapifyDown(0);
            }

            return min;
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

        MinHeap minHeap = new MinHeap(10);

        int[] values = {40, 15, 30, 10, 50, 20, 25};

        System.out.println("===== MIN HEAP =====");

        // Insert all values
        for (int value : values) {
            minHeap.insert(value);
        }

        // Display Heap
        System.out.print("\nMin Heap Elements: ");
        minHeap.display();

        // Peek smallest element
        System.out.println(
            "Minimum Element (Peek): " + minHeap.peek()
        );

        // First extraction
        System.out.println(
            "\nExtracted Min: " + minHeap.extractMin()
        );

        System.out.print("Heap After First Extraction: ");
        minHeap.display();

        // Second extraction
        System.out.println(
            "\nExtracted Min: " + minHeap.extractMin()
        );

        System.out.print("Heap After Second Extraction: ");
        minHeap.display();

        // Final size
        System.out.println(
            "\nFinal Heap Size: " + minHeap.getSize()
        );
    }
}
