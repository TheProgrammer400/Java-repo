import java.util.*;

public class QuickSort {

    // Swap function
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Partition function
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }

            while (arr[j] > pivot && j >= low) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, low, j);
        return j;
    }

    // QuickSort recursive function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }

    // Print function
    public static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    // Main function
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
        int size = arr.length;

        System.out.println("Sorted array:");
        quickSort(arr, 0, size - 1);
        printArray(arr);
    }
}
