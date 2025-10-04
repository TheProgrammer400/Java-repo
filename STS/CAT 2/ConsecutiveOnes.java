import java.util.*;

public class ConsecutiveOnes {
    public static int maxConsecutiveOnes(int []arr, int k){
        int numFlips = 0;
        int left = 0;
        int max = 0;

        for(int right = 0; right<arr.length; right++){
            if (arr[right] == 0){
                numFlips++;
            }

            while (numFlips > k){
                if (arr[left] == 0){
                    numFlips--;
                }

                left++;
            }

            max = Math.max(max, right-left+1);
        }

        return max;
    }
    
    public static void main(String []args){
        int[] arr = {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0};
        int k = 2;

        int result = maxConsecutiveOnes(arr, k);
        System.out.println(result);
    }
}
