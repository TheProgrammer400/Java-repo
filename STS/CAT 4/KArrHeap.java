import java.util.*;

class KArrHeap {

    public static void restoreDown(int[] arr, int n, int index, int k){

        while(true){

            int maxIndex = index;

            // check all k children directly
            for(int i = 1; i <= k; i++){
                int child = k * index + i;

                if(child < n && arr[child] > arr[maxIndex]){
                    maxIndex = child;
                }
            }

            if(maxIndex == index){
                break;
            }

            swap(arr, index, maxIndex);
            index = maxIndex;
        }
    }

    public static void restoreUp(int[] arr, int index, int k){

        while(index > 0){

            int parent = (index - 1) / k;

            if (arr[index] > arr[parent]){
                swap(arr, index, parent);
                index = parent;
            } else{
                break;
            }
        }
    }

    public static void buildHeap(int[] arr, int n, int k){
        for(int i = (n - 1) / k; i >= 0; i--){
            restoreDown(arr, n, i, k);
        }
    }

    public static void insert(int[] arr, int n, int k, int elem){
        arr[n] = elem;   // 💀 FIX: was arr[n-1]
        restoreUp(arr, n, k);
    }

    public static int extractMax(int[] arr, int n, int k){
        int max = arr[0];
        arr[0] = arr[n - 1];
        restoreDown(arr, n - 1, 0, k);
        return max;
    }

    // 🔥 OPTIMIZED (no extra child array)

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){

        int[] arr = {4, 5, 6, 7, 8, 9, 10};
        int n = 7;
        int k = 3;

        buildHeap(arr, n, k);

        System.out.println("Built Heap:");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }

        int element = 3;
        insert(arr, n, k, element);
        n++;

        System.out.println("\nHeap after insertion:");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nExtracted max: " + extractMax(arr, n, k));
        n--;

        System.out.println("Heap after extract max:");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}