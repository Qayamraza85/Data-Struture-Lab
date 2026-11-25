public class lab09task3 {

    static final int SIZE = 7;

    // Hash Entry Class
    static class HashEntry {
        int key;
        String value;
        boolean isDeleted;

        HashEntry(int key, String value) {
            this.key = key;
            this.value = value;
            this.isDeleted = false;
        }
    }

    // Hash Table
    static HashEntry[] table = new HashEntry[SIZE];

    // First Hash Function
    static int h1(int key) {
        return key % SIZE;
    }

    // Second Hash Function
    static int h2(int key) {
        return 5 - (key % 5);
    }

    // Insert using Double Hashing
    static void insert(int key, String value) {

        int firstDeleted = -1;

        for (int i = 0; i < SIZE; i++) {

            int index = (h1(key) + i * h2(key)) % SIZE;

            if (table[index] == null) {

                int position = (firstDeleted != -1)
                        ? firstDeleted : index;

                table[position] = new HashEntry(key, value);

                System.out.println(
                    "Inserted (" + key + ", " + value +
                    ") at index " + position
                );

                return;

            } else if (table[index].isDeleted) {

                if (firstDeleted == -1) {
                    firstDeleted = index;
                }

            } else if (table[index].key == key) {

                table[index].value = value;
                System.out.println("Key already exists. Value updated.");
                return;
            }
        }

        if (firstDeleted != -1) {
            table[firstDeleted] = new HashEntry(key, value);

            System.out.println(
                "Inserted (" + key + ", " + value +
                ") at index " + firstDeleted
            );

        } else {
            System.out.println("Hash Table is Full!");
        }
    }

    // Search a key
    static String search(int key) {

        for (int i = 0; i < SIZE; i++) {

            int index = (h1(key) + i * h2(key)) % SIZE;

            if (table[index] == null) {
                return null;
            }

            if (!table[index].isDeleted &&
                table[index].key == key) {

                return table[index].value;
            }
        }

        return null;
    }

    // Delete using Tombstone
    static boolean delete(int key) {

        for (int i = 0; i < SIZE; i++) {

            int index = (h1(key) + i * h2(key)) % SIZE;

            if (table[index] == null) {
                return false;
            }

            if (!table[index].isDeleted &&
                table[index].key == key) {

                table[index].isDeleted = true;

                return true;
            }
        }

        return false;
    }

    // Display Hash Table
    static void display() {

        System.out.println("\nHash Table:");

        for (int i = 0; i < SIZE; i++) {

            if (table[i] == null) {

                System.out.println(
                    "Index " + i + " : EMPTY"
                );

            } else if (table[i].isDeleted) {

                System.out.println(
                    "Index " + i + " : DELETED"
                );

            } else {

                System.out.println(
                    "Index " + i + " : (" +
                    table[i].key + ", " +
                    table[i].value + ")"
                );
            }
        }
    }

    // Main Method
    public static void main(String[] args) {

        System.out.println("===== DOUBLE HASHING =====");

        // Insert key-value pairs
        insert(12, "Ali");
        insert(19, "Sara");
        insert(26, "Bilal");
        insert(5, "Hina");

        // Display before deletion
        System.out.println("\nBefore Deletion:");
        display();

        // Delete key 19
        System.out.println("\nDeleting Key 19:");

        if (delete(19)) {
            System.out.println("Key 19 deleted successfully.");
        } else {
            System.out.println("Key 19 not found.");
        }

        // Display after deletion
        System.out.println("\nAfter Deletion:");
        display();

        // Search key 26
        System.out.println("\nSearching Key 26:");

        String result = search(26);

        if (result != null) {
            System.out.println(
                "Key 26 Found! Value: " + result
            );
        } else {
            System.out.println("Key 26 Not Found!");
        }
    }
}
