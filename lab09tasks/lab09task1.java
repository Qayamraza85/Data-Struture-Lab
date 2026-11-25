public class lab09task1 {

    static int SIZE = 7;
    static int[] table = new int[SIZE];
    static boolean[] occupied = new boolean[SIZE];

    static int totalCollisions = 0;

    // Hash Function
    static int hash(int key) {
        return key % SIZE;
    }

    // Insert using Linear Probing
    static void insert(int key) {

        int index = hash(key);

        for (int i = 0; i < SIZE; i++) {

            int newIndex = (index + i) % SIZE;

            if (!occupied[newIndex]) {

                table[newIndex] = key;
                occupied[newIndex] = true;

                System.out.println(
                    "Inserted " + key +
                    " at index " + newIndex
                );

                return;

            } else {

                totalCollisions++;

                System.out.println(
                    "Collision for " + key +
                    " at index " + newIndex
                );
            }
        }

        System.out.println("Hash Table is Full!");
    }

    // Search a key
    static boolean search(int key) {

        int index = hash(key);

        for (int i = 0; i < SIZE; i++) {

            int newIndex = (index + i) % SIZE;

            if (!occupied[newIndex]) {
                return false;
            }

            if (table[newIndex] == key) {
                return true;
            }
        }

        return false;
    }

    // Display Hash Table
    static void display() {

        System.out.println("\nFinal Hash Table:");

        for (int i = 0; i < SIZE; i++) {

            if (occupied[i]) {
                System.out.println(
                    "Index " + i + " : " + table[i]
                );
            } else {
                System.out.println(
                    "Index " + i + " : EMPTY"
                );
            }
        }
    }

    // Main Method
    public static void main(String[] args) {

        int[] keys = {14, 21, 8, 15, 22};

        System.out.println("Linear Probing");

        // Insert keys
        for (int key : keys) {
            insert(key);
        }

        // Display table
        display();

        // Display collisions
        System.out.println(
            "\nTotal Collisions: " + totalCollisions
        );

        // Search keys
        System.out.println("\nSearching Keys:");

        System.out.println(
            "Search 15: " +
            (search(15) ? "Found" : "Not Found")
        );

        System.out.println(
            "Search 99: " +
            (search(99) ? "Found" : "Not Found")
        );
    }
}
