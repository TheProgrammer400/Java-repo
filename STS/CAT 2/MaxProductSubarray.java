import java.util.*;

public class MaxProductSubarray {
    public static int findMaxSum(int []arr, int n){
        int maxSoFar = arr[0];
        int minSoFar = arr[0];
        int result = arr[0];

        for(int i=1; i<n; i++){ 
            int curr = arr[i];

            int tempMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            int tempMin = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));

            maxSoFar = tempMax;
            minSoFar = tempMin;

            result = Math.max(maxSoFar, result);
        }

        return result;
    }

    public static void main(String []args){
        int []arr = {4, 6, -2, -5, 4};
        int result = findMaxSum(arr, arr.length);

        System.out.println(result);
    }
}
