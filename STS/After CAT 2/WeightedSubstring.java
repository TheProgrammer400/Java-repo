import java.util.*;

class WeightedSubstring {
    // Function to count distinct substrings with weight sum <= K
    static int distinctSubString(String str, String weights, int k, int n) {
        // HashSet to store unique substrings
        HashSet<String> set = new HashSet<>();

        // Iterate over all substrings
        for (int i = 0; i < n; i++) {
            int sum = 0;       // sum of weights so far
            String s = "";     // current substring

            for (int j = i; j < n; j++) {
                // index of character P[j] in alphabet (0–25)
                int pos = str.charAt(j) - 'a';

                // add weight from Q
                sum += weights.charAt(pos) - '0';

                // add current character to the substring
                s += str.charAt(j);

                // if total weight is within limit, keep it
                if (sum <= k) {
                    set.add(s);
                } else {
                    break; 
                }
            }
        }

        // number of distinct substrings
        return set.size();
    }


    // MAIN
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string P: ");
        String str = scanner.nextLine();

        System.out.print("Enter string Q (same length as P): ");
        String weights = scanner.nextLine();

        System.out.print("Enter value of K: ");
        int k = scanner.nextInt();

        int n = str.length();

        System.out.println("Output: " + distinctSubString(str, weights, k, n));

        scanner.close();
    }
}
