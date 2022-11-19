import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Dmitrii Khokhlov
 * @version 2.1
 *          Structure of my program:
 *          1) Creating Linked and Array integer lists
 *          2) Creating an array of dimensions
 *          3) Times Functions
 *          4) Support functions
 * @see test#test_add_first(LinkedList, ArrayList, int[])
 * @see test#test_add_middle(LinkedList, ArrayList, int[])
 * @see test#test_add_last(LinkedList, ArrayList, int[])
 * @see test#test_get_first(LinkedList, ArrayList, int[])
 * @see test#test_get_middle(LinkedList, ArrayList, int[])
 * @see test#test_get_last(LinkedList, ArrayList, int[])
 * @see test#test_delete_first(LinkedList, ArrayList, int[])
 * @see test#test_delete_middle(LinkedList, ArrayList, int[])
 * @see test#test_delete_last(LinkedList, ArrayList, int[])
 * @see test#test_sort(LinkedList, ArrayList, int[])
 * @see test#test_clear(LinkedList, ArrayList, int[])
 */
public class test {
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> Linked = new LinkedList<>();
        ArrayList<Integer> Array = new ArrayList<>();

        // You can delete or add any size(after 350.000 Linked list may break!)
        int[] count = IntStream.of(10, 100, 1000, 10000, 100000).toArray();

        test_add_first(Linked, Array, count);
        test_add_middle(Linked, Array, count);
        test_add_last(Linked, Array, count);

        test_get_first(Linked, Array, count);
        test_get_middle(Linked, Array, count);
        test_get_last(Linked, Array, count);

        test_delete_first(Linked, Array, count);
        test_delete_middle(Linked, Array, count);
        test_delete_last(Linked, Array, count);

        test_sort(Linked, Array, count);
        test_clear(Linked, Array, count);
    }

    /**
     * Structure of test functions:
     * 
     * @param Linked - LinkedList
     * @param Array  - ArrayList
     * @param count  - massive of dimensions
     * @see test#printResult(long, long)
     */
    public static void test_add_first(LinkedList<Integer> Linked, ArrayList<Integer> Array, int[] count) {
        long LinkedTime = 0, ArrayTime = 0; // Operatiomn time
        long startTime, stopTime; // Time start and finish operation

        System.out.println("_________________________________________");
        System.out.println("ADD FIRST elements:\n Linked    Array");

        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i] + ":\n ");

            startTime = System.nanoTime(); //
            for (int j = 0; j < count[i]; j++)
                Linked.addFirst(j);
            stopTime = System.nanoTime();
            Linked.clear(); // After operations we need to clear lists (except for delete functions)

            LinkedTime = stopTime - startTime; // Calculation of total working time
            System.out.print(LinkedTime + " - ");

            startTime = System.nanoTime();
            for (int j = 0; j < count[i]; j++)
                Array.add(0, j);
            stopTime = System.nanoTime();
            Array.clear();

            ArrayTime = stopTime - startTime;
            System.out.print(ArrayTime + "\n");

            printResult(LinkedTime, ArrayTime);
        }
        System.out.println("_________________________________________");
    }

    public static void test_add_middle(LinkedList<Integer> Linked, ArrayList<Integer> Array, int[] count) {
        long LinkedTime = 0, ArrayTime = 0;
        long startTime, stopTime;

        System.out.println("_________________________________________");
        System.out.println("ADD MIDDLE elements:\n Linked    Array");

        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i] + ":\n ");

            startTime = System.nanoTime();
            for (int j = 0; j < count[i]; j++)
                Linked.add((j / 2), j);
            stopTime = System.nanoTime();
            Linked.clear();

            LinkedTime = stopTime - startTime;
            System.out.print(LinkedTime + " - ");

            startTime = System.nanoTime();
            for (int j = 0; j < count[i]; j++)
                Array.add((j / 2), j);
            stopTime = System.nanoTime();
            Array.clear();

            ArrayTime = stopTime - startTime;
            System.out.print(ArrayTime + "\n");

            printResult(LinkedTime, ArrayTime);
        }
        System.out.println("_________________________________________");
    }

    public static void test_add_last(LinkedList<Integer> Linked, ArrayList<Integer> Array, int[] count) {
        long LinkedTime = 0, ArrayTime = 0;
        long startTime, stopTime;

        System.out.println("_________________________________________");
        System.out.println("ADD LAST elements:\n Linked    Array");

        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i] + ":\n ");

            startTime = System.nanoTime();
            for (int j = 0; j < count[i]; j++)
                Linked.add(j, j);
            stopTime = System.nanoTime();
            Linked.clear();

            LinkedTime = stopTime - startTime;
            System.out.print(LinkedTime + " - ");

            startTime = System.nanoTime();
            for (int j = 0; j < count[i]; j++)
                Array.add(j, j);
            stopTime = System.nanoTime();
            Array.clear();

            ArrayTime = stopTime - startTime;
            System.out.print(ArrayTime + "\n");

            printResult(LinkedTime, ArrayTime);
        }
        System.out.println("_________________________________________");
    }

    /**
     * @see test#fill(LinkedList, ArrayList, int)
     */
    public static void test_get_first(LinkedList<Integer> Linked, ArrayList<Integer> Array, int[] count) {
        long LinkedTime = 0, ArrayTime = 0;
        long startTime, stopTime;

        System.out.println("_________________________________________");
        System.out.println("GET FIRST elements:\n Linked - Array");

        for (int i = 0; i < count.length; i++) {
            fill(Linked, Array, count[i]); // Before the operations we need to fill lists(except add operations)
            System.out.print(count[i] + ":\n ");

            startTime = System.nanoTime();
            for (int j = 0; j < count[i]; j++)
                Linked.getFirst();
            stopTime = System.nanoTime();
            Linked.clear();

            LinkedTime = stopTime - startTime;
            System.out.print(LinkedTime + " - ");

            startTime = System.nanoTime();
            for (int j = 0; j < count[i]; j++)
                Array.get(0);
            stopTime = System.nanoTime();
            Array.clear();

            ArrayTime = stopTime - startTime;
            System.out.print(ArrayTime + "\n");

            printResult(LinkedTime, ArrayTime);
        }
        System.out.println("_________________________________________");
    }

    public static void test_get_middle(LinkedList<Integer> Linked, ArrayList<Integer> Array, int[] count) {
        long LinkedTime = 0, ArrayTime = 0;
        long startTime, stopTime;

        System.out.println("_________________________________________");
        System.out.println("GET MIDDLE elements:\n Linked - Array");

        for (int i = 0; i < count.length; i++) {
            fill(Linked, Array, count[i]);
            System.out.print(count[i] + ":\n ");

            startTime = System.nanoTime();
            for (int j = 0; j < count[i]; j++)
                Linked.get((j / 2));
            stopTime = System.nanoTime();
            Linked.clear();

            LinkedTime = stopTime - startTime;
            System.out.print(LinkedTime + " - ");

            startTime = System.nanoTime();
            for (int j = count[i]; j > 0; j--)
                Array.get(j / 2);
            stopTime = System.nanoTime();
            Array.clear();

            ArrayTime = stopTime - startTime;
            System.out.print(ArrayTime + "\n");

            printResult(LinkedTime, ArrayTime);
        }
        System.out.println("_________________________________________");
    }

    public static void test_get_last(LinkedList<Integer> Linked, ArrayList<Integer> Array, int[] count) {
        long LinkedTime = 0, ArrayTime = 0;
        long startTime, stopTime;

        System.out.println("_________________________________________");
        System.out.println("GET LAST elements:\n Linked - Array");

        for (int i = 0; i < count.length; i++) {
            fill(Linked, Array, count[i]);
            System.out.print(count[i] + ":\n ");

            startTime = System.nanoTime();
            for (int j = count[i]; j > 0; j--)
                Linked.getLast();
            stopTime = System.nanoTime();
            Linked.clear();

            LinkedTime = stopTime - startTime;
            System.out.print(LinkedTime + " - ");

            startTime = System.nanoTime();
            for (int j = count[i]; j > 0; j--)
                Array.get(j - 1);
            stopTime = System.nanoTime();
            Array.clear();

            ArrayTime = stopTime - startTime;
            System.out.print(ArrayTime + "\n");

            printResult(LinkedTime, ArrayTime);
        }
        System.out.println("_________________________________________");
    }

    public static void test_delete_first(LinkedList<Integer> Linked, ArrayList<Integer> Array, int[] count) {
        long LinkedTime = 0, ArrayTime = 0;
        long startTime, stopTime;

        System.out.println("_________________________________________");
        System.out.println("REMOVE FIRST elements:\n Linked - Array");

        for (int i = 0; i < count.length; i++) {
            fill(Linked, Array, count[i]);
            System.out.print(count[i] + ":\n ");

            startTime = System.nanoTime();
            for (int j = 0; j < count[i]; j++)
                Linked.remove(0);
            stopTime = System.nanoTime();
            Linked.clear();

            LinkedTime = stopTime - startTime;
            System.out.print(LinkedTime + " - ");

            startTime = System.nanoTime();
            for (int j = 0; j < count[i]; j++)
                Array.remove(0);
            stopTime = System.nanoTime();
            Array.clear();

            ArrayTime = stopTime - startTime;
            System.out.print(ArrayTime + "\n");

            printResult(LinkedTime, ArrayTime);
        }
        System.out.println("_________________________________________");
    }

    public static void test_delete_middle(LinkedList<Integer> Linked, ArrayList<Integer> Array, int[] count) {
        long LinkedTime = 0, ArrayTime = 0;
        long startTime, stopTime;

        System.out.println("_________________________________________");
        System.out.println("REMOVE middle elements:\n Linked - Array");

        for (int i = 0; i < count.length; i++) {
            fill(Linked, Array, count[i]);
            System.out.print(count[i] + ":\n ");

            startTime = System.nanoTime();
            for (int j = count[i]; j > 0; j--)
                Linked.remove((j / 2));
            stopTime = System.nanoTime();
            Linked.clear();

            LinkedTime = stopTime - startTime;
            System.out.print(LinkedTime + " - ");

            startTime = System.nanoTime();
            for (int j = count[i]; j > 0; j--)
                Array.remove(j / 2);
            stopTime = System.nanoTime();
            Array.clear();

            ArrayTime = stopTime - startTime;
            System.out.print(ArrayTime + "\n");

            printResult(LinkedTime, ArrayTime);
        }
        System.out.println("_________________________________________");
    }

    public static void test_delete_last(LinkedList<Integer> Linked, ArrayList<Integer> Array, int[] count) {
        long LinkedTime = 0, ArrayTime = 0;
        long startTime, stopTime;

        System.out.println("_________________________________________");
        System.out.println("REMOVE LAST elements:\n Linked - Array");

        for (int i = 0; i < count.length; i++) {
            fill(Linked, Array, count[i]);
            System.out.print(count[i] + ":\n ");

            startTime = System.nanoTime();
            for (int j = count[i]; j > 0; j--)
                Linked.remove(j - 1);
            stopTime = System.nanoTime();
            Linked.clear();

            LinkedTime = stopTime - startTime;
            System.out.print(LinkedTime + " - ");

            startTime = System.nanoTime();
            for (int j = count[i]; j > 0; j--)
                Array.remove(j - 1);
            stopTime = System.nanoTime();
            Array.clear();

            ArrayTime = stopTime - startTime;
            System.out.print(ArrayTime + "\n");

            printResult(LinkedTime, ArrayTime);
        }
        System.out.println("_________________________________________");
    }

    public static void test_clear(LinkedList<Integer> Linked, ArrayList<Integer> Array, int[] count) {
        long LinkedTime = 0, ArrayTime = 0;
        long startTime, stopTime;

        System.out.println("_________________________________________");
        System.out.println("CLEAR elements:\n Linked - Array");

        for (int i = 0; i < count.length; i++) {
            fill(Linked, Array, count[i]);
            System.out.print(count[i] + ":\n ");

            startTime = System.nanoTime();
            Linked.clear();

            stopTime = System.nanoTime();

            LinkedTime = stopTime - startTime;
            System.out.print(LinkedTime + " - ");

            startTime = System.nanoTime();
            Array.clear();
            stopTime = System.nanoTime();

            ArrayTime = stopTime - startTime;
            System.out.print(ArrayTime + "\n");

            printResult(LinkedTime, ArrayTime);
        }
        System.out.println("_________________________________________");
    }

    public static void test_sort(LinkedList<Integer> Linked, ArrayList<Integer> Array, int[] count) {
        long LinkedTime = 0, ArrayTime = 0;
        long startTime, stopTime;

        System.out.println("_________________________________________");
        System.out.println("SORT elements:\n Linked - Array");

        for (int i = 0; i < count.length; i++) {
            fill(Linked, Array, count[i]);
            System.out.print(count[i] + ":\n ");

            startTime = System.nanoTime();
            Collections.sort(Linked);

            stopTime = System.nanoTime();

            LinkedTime = stopTime - startTime;
            System.out.print(LinkedTime + " - ");

            startTime = System.nanoTime();
            Array.clear();
            stopTime = System.nanoTime();

            ArrayTime = stopTime - startTime;
            System.out.print(ArrayTime + "\n");

            printResult(LinkedTime, ArrayTime);
        }
        System.out.println("_________________________________________");
    }

    /**
     * The same random filling lists
     */
    public static void fill(LinkedList<Integer> Linked, ArrayList<Integer> Array, int count) {
        int number = 0;
        Random randNum = new Random();

        for (int i = 0; i < count; i++) {
            number = randNum.nextInt();

            Linked.add(number);
            Array.add(number);
        }
    }

    /**
     * Print result of test
     * 
     * @param LinkedTime - Linked list operation time
     * @param ArrayTime  - Array list operation time
     */
    public static void printResult(long LinkedTime, long ArrayTime) {
        if (LinkedTime == ArrayTime)
            System.out.println("They are equals!");
        else {
            if (LinkedTime - ArrayTime < 0)
                System.out.print("Linked ");
            else if (LinkedTime - ArrayTime > 0)
                System.out.print("Array ");
            System.out.println("is faster!");
        }

    }
}
