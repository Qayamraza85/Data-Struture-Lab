public class lab09task2 {

    static final int SIZE = 11;

    // First Hash Function
    static int h1(int key) {
        return key % SIZE;
    }

    // Second Hash Function
    static int h2(int key) {
        return 7 - (key % 7);
    }

    // Quadratic Probing Insertion
    static int insertQuadratic(int[] table, int key) {

        int base = h1(key);
        int probes = 0;

        for (int i = 0; i < SIZE; i++) {

            int index = (base + i * i) % SIZE;
            probes++;

            if (table[index] == -1) {

                table[index] = key;

                System.out.println(
                    "Inserted " + key +
                    " at index " + index
                );

                return probes;

            } else {

                System.out.println(
                    "Collision for " + key +
                    " at index " + index
                );
            }
        }

        System.out.println("Table is full!");
        return probes;
    }

    // Double Hashing Insertion
    static int insertDouble(int[] table, int key) {

        int base = h1(key);
        int step = h2(key);
        int probes = 0;

        for (int i = 0; i < SIZE; i++) {

            int index = (base + i * step) % SIZE;
            probes++;

            if (table[index] == -1) {

                table[index] = key;

                System.out.println(
                    "Inserted " + key +
                    " at index " + index
                );

                return probes;

            } else {

                System.out.println(
                    "Collision for " + key +
                    " at index " + index
                );
            }
        }

        System.out.println("Table is full!");
        return probes;
    }

    // Display Hash Table
    static void display(int[] table) {

        for (int i = 0; i < SIZE; i++) {

            if (table[i] == -1) {
                System.out.println(
                    "Index " + i + " : EMPTY"
                );
            } else {
                System.out.println(
                    "Index " + i + " : " + table[i]
                );
            }
        }
    }

    public static void main(String[] args) {

        int[] keys = {22, 33, 44, 11, 55};

        // Two fresh hash tables
        int[] quadraticTable = new int[SIZE];
        int[] doubleTable = new int[SIZE];

        // Initialize both tables as empty
        for (int i = 0; i < SIZE; i++) {
            quadraticTable[i] = -1;
            doubleTable[i] = -1;
        }

        int quadraticProbes = 0;
        int doubleProbes = 0;

        // Quadratic Probing
        System.out.println("===== QUADRATIC PROBING =====");

        for (int key : keys) {
            quadraticProbes +=
                insertQuadratic(quadraticTable, key);
        }

        System.out.println("\nQuadratic Hash Table:");
        display(quadraticTable);

        // Double Hashing
        System.out.println("\n===== DOUBLE HASHING =====");

        for (int key : keys) {
            doubleProbes +=
                insertDouble(doubleTable, key);
        }

        System.out.println("\nDouble Hashing Table:");
        display(doubleTable);

        // Comparison
        System.out.println("\n===== COMPARISON =====");

        System.out.println(
            "Quadratic Total Probes: " + quadraticProbes
        );

        System.out.println(
            "Double Hashing Total Probes: " + doubleProbes
        );

        System.out.println(
            "Quadratic Extra Probes: " +
            (quadraticProbes - keys.length)
        );

        System.out.println(
            "Double Hashing Extra Probes: " +
            (doubleProbes - keys.length)
        );
    }
}
