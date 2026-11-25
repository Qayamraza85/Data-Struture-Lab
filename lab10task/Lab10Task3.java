public class Lab10Task3 {

    // Patient Class
    static class Patient {

        String name;
        int priority;

        Patient(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }
    }

    // Min Heap Class
    static class MinHeap {

        Patient[] heap;
        int size;
        int capacity;

        // Constructor
        MinHeap(int capacity) {
            this.capacity = capacity;
            heap = new Patient[capacity];
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

        // Swap patients
        void swap(int i, int j) {
            Patient temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        // Insert patient
        void insert(Patient patient) {

            if (size == capacity) {
                System.out.println("Queue is full!");
                return;
            }

            heap[size] = patient;
            int current = size;
            size++;

            // Heapify Up
            while (current > 0 &&
                   heap[current].priority <
                   heap[parent(current)].priority) {

                swap(current, parent(current));
                current = parent(current);
            }
        }

        // View next patient
        Patient peek() {

            if (size == 0) {
                throw new IllegalStateException("Queue is empty");
            }

            return heap[0];
        }

        // Heapify Down
        void heapifyDown(int i) {

            int smallest = i;

            int left = leftChild(i);
            int right = rightChild(i);

            if (left < size &&
                heap[left].priority <
                heap[smallest].priority) {

                smallest = left;
            }

            if (right < size &&
                heap[right].priority <
                heap[smallest].priority) {

                smallest = right;
            }

            if (smallest != i) {

                swap(i, smallest);

                heapifyDown(smallest);
            }
        }

        // Extract most urgent patient
        Patient extractMin() {

            if (size == 0) {
                throw new IllegalStateException("Queue is empty");
            }

            Patient min = heap[0];

            heap[0] = heap[size - 1];
            size--;

            if (size > 0) {
                heapifyDown(0);
            }

            return min;
        }

        // Display all waiting patients
        void display() {

            if (size == 0) {
                System.out.println("No patients waiting.");
                return;
            }

            for (int i = 0; i < size; i++) {

                System.out.println(
                    "Patient: " + heap[i].name +
                    " | Priority: " + heap[i].priority
                );
            }
        }
    }

    // Main Method
    public static void main(String[] args) {

        MinHeap queue = new MinHeap(10);

        System.out.println(
            "===== HOSPITAL EMERGENCY QUEUE ====="
        );

        // Insert patients
        queue.insert(new Patient("Ali", 3));
        queue.insert(new Patient("Sara", 1));
        queue.insert(new Patient("Bilal", 4));
        queue.insert(new Patient("Ayesha", 2));
        queue.insert(new Patient("Usman", 5));

        // Display next patient
        System.out.println("\nNext Patient to be Treated:");

        Patient next = queue.peek();

        System.out.println(
            next.name + " | Priority: " + next.priority
        );

        // Treat first patient
        System.out.println("\n===== TREATING PATIENTS =====");

        Patient first = queue.extractMin();

        System.out.println(
            "Treated: " + first.name +
            " | Priority: " + first.priority
        );

        // Treat second patient
        Patient second = queue.extractMin();

        System.out.println(
            "Treated: " + second.name +
            " | Priority: " + second.priority
        );

        // Display remaining patients
        System.out.println("\n===== REMAINING PATIENTS =====");

        queue.display();
    }
}
