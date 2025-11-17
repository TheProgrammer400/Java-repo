public class Maneuvering{
    public static long factorial(long n){
        if (n == 0 || n == 1){
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    // function to compute nCr using long
    public static long nCr(long n, long r){
        return factorial(n) / (factorial(r) * factorial(n-r));
    }

    // total paths in m x n grid
    public static long countPaths(int m, int n) {
        long N = m + n - 2;     // total steps
        long R = m - 1;         // choose (m-1) downs
        return nCr(N, R);
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        System.out.println("Total paths = " + countPaths(m, n));
    }
}
