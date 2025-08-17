package STS;

import java.util.*;

public class SimpleSieve {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        
        boolean []arr = new boolean[n+1];
        
        for(int i=2; i<=n; i++){
            arr[i] = true;
        }
        
        for(int i=2; i<=Math.sqrt(n); i++){
            if (arr[i]){
                for(int j=i*i; j<=n; j = j + i){
                    arr[j] = false;
                }
            }
        }
        
        for(int i=2; i<=n; i++){
            if (arr[i]){
                System.out.printf("%d ", i);
            }
        }
    }
}

// Time-complexity : O(n log log n)
// space-complexity: O(n)
