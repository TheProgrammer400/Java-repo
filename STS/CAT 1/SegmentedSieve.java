import java.util.*;

public class SegmentedSieve{
    static ArrayList<Integer> simpleSieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) primes.add(i);
        }
        
        return primes;
    }

    // Segmented Sieve: prints primes in range [low, high]
    static void segmentedSieve(int low, int high) {
        int limit = (int) Math.sqrt(high);
        ArrayList<Integer> primes = simpleSieve(limit);

        boolean[] isPrime = new boolean[high - low + 1];
        Arrays.fill(isPrime, true);

        for (int prime : primes) {
            int firstMultiple = Math.max(prime * prime, ((low + prime - 1) / prime) * prime);

            for (int j = firstMultiple; j <= high; j += prime) {
                isPrime[j - low] = false;
            }
        }

        for (int i = low; i <= high; i++) {
            if (i > 1 && isPrime[i - low]) {
                System.out.print(i + " ");
            }
        }
        
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter low and high: ");
        int low = scan.nextInt();
        int high = scan.nextInt();

        System.out.println("Primes between " + low + " and " + high + ":");
        segmentedSieve(low, high);

        scan.close();
    }
}
