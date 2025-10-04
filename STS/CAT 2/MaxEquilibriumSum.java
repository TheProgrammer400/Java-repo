import java.util.*;

public class MaxEquilibriumSum {
    public static int findMaxEquilibriumSum(int[] arr, int n) {
        int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // Right sum = total sum - left sum - current element
            int rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum) {
                result = Math.max(result, leftSum); // equilibrium sum
            }

            leftSum += arr[i];
        }

        if(result == Integer.MIN_VALUE){
            return -1; // no equilibrium found
        } else {
            return result; // return the equilibrium sum
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter size of the array: ");
        int n = s.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements of the array:");

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int maxEquilibriumSum = findMaxEquilibriumSum(arr, n);
        
        if (maxEquilibriumSum == -1) {
            System.out.println("No equilibrium point found.");
        } else {
            System.out.println("Maximum equilibrium sum = " + maxEquilibriumSum);
        }
    }
}
