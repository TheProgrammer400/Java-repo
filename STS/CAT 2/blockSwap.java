import java.util.*;

public class blockSwap {
    public static void rotateToLeft(int []arr, int n, int k){
        if (n == 0 || k == 0){
            return ;
        }

        k = k % n; // if k > n

        int []temp = new int[k];

        for(int i=0; i<k; i++){
            temp[i] = arr[i]; // copy the block into temp
        }

        for(int i=k; i<n; i++){
            arr[i-k] = arr[i]; // shift the elements in the main array by k positions
        }

        for(int i=n-k; i<n; i++){
            arr[i] = temp[i-(n-k)]; // append temp at the end of the main array
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;

        rotateToLeft(arr, n, k);

        System.out.println("After rotating the elements to the left:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
