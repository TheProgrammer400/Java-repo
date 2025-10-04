import java.util.*;

public class HourGlassSum {
    public static int findMaxSum(int [][]arr, int rows, int cols){
        int maxSum = Integer.MIN_VALUE;
        
        for(int i=0; i<rows-2; i++){
            for(int j=0; j<cols-2; j++){
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];

                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3, 0, 0},
            {0, 0, 0, 0, 0},
            {2, 1, 4, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 1, 0}
        };

        int row = mat.length;
        int col = mat[0].length;

        int result = findMaxSum(mat, row, col);
        System.out.println("Maximum sum of hourglass = " + result);
    }
}
