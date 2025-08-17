package STS;

import java.util.*;

public class EulerPhi{
    public static int eular(int n){
        int result = n;

        for(int i=2; i<=Math.sqrt(n); i++){
            if (n % i == 0){
                while (n % i == 0){
                    n = n / i;
                }

                result = result - result / i;
            }
        }

        if (n > 1){
            result = result - result / n;
        }
        
        return result;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        System.out.printf("%d is the phi's value", eular(n));
        scan.close();
    }
}