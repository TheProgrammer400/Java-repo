import java.util.*;

public class KaratsubaAlgo {

    // Function to multiply two numbers using Karatsuba algorithm
    public static int karatsuba(int x, int y) {
        // Base case: if either number has only one digit
        if (x < 10 || y < 10) {
            return x * y;
        }

        // Step 1: Find the number of digits in the larger number
        int m = Math.max(getNumDigits(x), getNumDigits(y));
        int halfM = m / 2;

        // Step 2: Split the numbers into two halves
        int powerOf10 = (int) Math.pow(10, halfM);

        int a = x / powerOf10; // higher part of x
        int b = x % powerOf10; // lower part of x
        int c = y / powerOf10; // higher part of y
        int d = y % powerOf10; // lower part of y

        // Step 3: Recursively calculate three products
        int ac = karatsuba(a, c);
        int bd = karatsuba(b, d);
        int abcd = karatsuba(a + b, c + d);

        // Step 4: Combine the results
        int result = ac * (int) Math.pow(10, 2 * halfM)
                    + (abcd - ac - bd) * powerOf10
                    + bd;

        return result;
    }

    // Helper function to count digits in a number
    private static int getNumDigits(int x) {
        if (x == 0) {
            return 1;
        }
        int count = 0;
        while (x > 0) {
            count++;
            x /= 10;
        }
        return count;
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        int x = sc.nextInt();

        System.out.print("Enter number 2: ");
        int y = sc.nextInt();

        int product = karatsuba(x, y);

        System.out.println(x + " * " + y + " = " + product);
    }
}
