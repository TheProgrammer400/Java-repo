import java.util.*;

public class Main{
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

    public static void segmentedSieve(int low, int high){
        int limit = (int) Math.sqrt(high);

        ArrayList<Integer> primes = simpleSieve(limit);

        boolean []isPrime = new boolean[high - low + 1];
        Arrays.fill(isPrime, true);

        for(int prime: primes){
            int firstMultiple = Math.max(prime * prime, ((low + prime - 1) / prime) * prime);

            for(int i=firstMultiple; i<=high; i = i + prime){
                isPrime[i-low] = false;
            }
        }

    }
    public static void main(String[] args){
        
    }
}