import java.util.Scanner;

class JosephusAlgo {

    // Iterative Josephus function
    public static int josephus(int n, int k) {
        int index = 0;

        for (int i = 1; i <= n; i++) {
            index = (index + k) % i;
        }

        return index + 1;  // Convert 0-based index to 1-based position
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of people (N): ");
        int n = sc.nextInt();

        System.out.print("Enter step count (k): ");
        int k = sc.nextInt();

        int safePosition = josephus(n, k);

        System.out.println("The safe position is: " + safePosition);
        sc.close();
    }
}
