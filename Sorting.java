import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the array size: ");
            int arraySize = scanner.nextInt();

            if (arraySize <= 0) {
                System.out.println("Please enter a positive integer for the array size.");
                return;
            }

            writeRandomNumbers(arraySize);
            int[] numbers = readRandomNumbers(arraySize);

            long mergeStartTime = System.nanoTime();
            mergeSort(Arrays.copyOf(numbers, numbers.length), 0, numbers.length - 1);
            long mergeEndTime = System.nanoTime();

            long quickStartTime = System.nanoTime();
            quickSort(numbers, 0, numbers.length - 1);
            long quickEndTime = System.nanoTime();

            System.out.println("Time taken for sorting an array of size " + arraySize + ":");
            System.out.println("Merge Sort: " + (mergeEndTime - mergeStartTime) / 1_000_000 + " ms");
            System.out.println("Quick Sort: " + (quickEndTime - quickStartTime) / 1_000_000 + " ms");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // FILE OPERATIONS
    public static void writeRandomNumbers(int n) {
        try (FileWriter writer = new FileWriter("numbers.txt")) {
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                int multiplier = random.nextInt(10);
                writer.write(i * multiplier + " ");
            }
        } catch (Exception e) {
            System.err.println("Error writing random numbers: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static int[] readRandomNumbers(int n) {
        try (Scanner scanner = new Scanner(new File("numbers.txt"))) {
            int[] numbers = new int[n];
            for (int i = 0; i < n && scanner.hasNextInt(); i++) {
                numbers[i] = scanner.nextInt();
            }
            return numbers;
        } catch (Exception e) {
            System.err.println("Error reading random numbers: " + e.getMessage());
            e.printStackTrace();
            return new int[]{};
        }
    }

    // MERGE SORT
    public static int[] mergeTwoSides(int[] left, int[] right) {
        int[] sorted = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                sorted[k++] = left[i++];
            } else {
                sorted[k++] = right[j++];
            }
        }
        while (i < left.length) {
            sorted[k++] = left[i++];
        }
        while (j < right.length) {
            sorted[k++] = right[j++];
        }
        return sorted;
    }

    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            int[] leftSorted = Arrays.copyOfRange(array, start, middle + 1);
            int[] rightSorted = Arrays.copyOfRange(array, middle + 1, end + 1);

            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);

            int[] merged = mergeTwoSides(leftSorted, rightSorted);
            System.arraycopy(merged, 0, array, start, merged.length);
        }
    }

    // QUICK SORT
    public static int split(int[] array, int start, int end) {
        int lastElement = array[end];
        int currentIndex = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] <= lastElement) {
                currentIndex++;
                int temp = array[currentIndex];
                array[currentIndex] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[currentIndex + 1];
        array[currentIndex + 1] = array[end];
        array[end] = temp;
        return currentIndex + 1;
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int splitIndex = split(array, start, end);
            quickSort(array, start, splitIndex - 1);
            quickSort(array, splitIndex + 1, end);
        }
    }
}