import java.util.*;

public class ChineseRemainder {
    public static int findMinX(int num[], int rem[], int k){
        int x = 1; // start checking from 1

        while (true) {
            int j;

            for (j = 0; j < k; j++){
                if (x % num[j] != rem[j]) {
                    break; // fails for this modulus, try next x
                }
            }

            if (j == k){
                return x; // x satisfies all congruences
            }

            x++;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of congruence relations: ");

        int size = scan.nextInt();

        int a[] = new int[size]; // remainders
        int m[] = new int[size]; // moduli

        System.out.println("Enter the values of remainders (a): ");

        for (int i = 0; i < size; i++) {
            a[i] = scan.nextInt();
        }

        System.out.println("Enter the values of moduli (m): ");

        for (int i = 0; i < size; i++) {
            m[i] = scan.nextInt();
        }

        int x = findMinX(m, a, size);

        System.out.println("Smallest value of x that satisfies all congruences: " + x);
        scan.close();
    }
}
