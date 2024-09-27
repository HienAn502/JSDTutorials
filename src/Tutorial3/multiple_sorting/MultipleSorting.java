package Tutorial3.multiple_sorting;

import java.util.Arrays;
import java.util.Random;

class SelectionSortRunnable implements Runnable {
    private int[] array;
    public SelectionSortRunnable(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        int size = array.length;

        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;

            for (int i = step + 1; i < size; i++) {

                // To sort in descending order, change > to < in this line.
                // Select the minimum element in each loop.
                if (array[i] < array[min_idx]) {
                    min_idx = i;
                }
            }

            // put min at the correct position
            int temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;
        }
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("Selection sort finished.");
        System.out.println("Selection sort took " + (endTime - startTime) + " ms.");
    }
}

class BubbleSortRunnable implements Runnable {
    private int[] array;
    public BubbleSortRunnable(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();

        int size = array.length;

        // loop to access each array element
        for (int i = 0; i < size - 1; i++)

            // loop to compare array elements
            for (int j = 0; j < size - i - 1; j++)

                // compare two adjacent elements
                // change > to < to sort in descending order
                if (array[j] > array[j + 1]) {

                    // swapping occurs if elements
                    // are not in the intended order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("Bubble sort finished.");
        System.out.println("Bubble sort took " + (endTime - startTime) + " ms.");
    }
}

class InsertionSortRunnable implements Runnable {
    private int[] array;
    public InsertionSortRunnable(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        int size = array.length;

        for (int step = 1; step < size; step++) {
            int key = array[step];
            int j = step - 1;

            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            // For descending order, change key<array[j] to key>array[j].
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }

            // Place key at after the element just smaller than it.
            array[j + 1] = key;
        }

        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("Insertion sort finished.");
        System.out.println("Insertion sort took " + (endTime - startTime) + " ms.");
    }
}

public class MultipleSorting {
    public static int[] generateRandomArray(int size, int start, int end) {
        Random rd = new Random(); // creating Random object
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rd.nextInt(end - start + 1) + start;
        }
        return arr.clone();
    }
    public static void main(String[] args) {
        int[] initialArray = generateRandomArray(1000, 1, 10000);
        System.out.println("Initial array: " + Arrays.toString(initialArray));

        Thread threadSelectionSort = new Thread(new SelectionSortRunnable(initialArray));
        Thread threadBubbleSort = new Thread(new BubbleSortRunnable(initialArray));
        Thread threadInsertionSort = new Thread(new InsertionSortRunnable(initialArray));

        threadSelectionSort.start();
        threadBubbleSort.start();
        threadInsertionSort.start();

        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of available processors: " + processors);
    }
}
