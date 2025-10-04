import java.util.*;

public class LexicographicalString {
    static final int MAX_CHAR = 26;

    // Function to count frequency of each character
    static void countFreq(String str, int[] freq) {
        for(int i = 0; i < str.length(); i++){
            freq[str.charAt(i) - 'a']++;
        }
    }

    // Function to check if palindrome can be formed
    static boolean canMakePalindrome(int[] freq, int len) {
        int countOdd = 0;

        for(int i = 0; i < MAX_CHAR; i++){
            if(freq[i] % 2 != 0){
                countOdd++;
            }
        }

        if(len % 2 == 0){ // even length → no odd count allowed
            return countOdd == 0;
        } else { // odd length → only one odd count allowed
            return countOdd == 1;
        }
    }

    // Find character with odd frequency and reduce its count by 1
    static String findOddAndReduce(int[] freq) {
        for(int i = 0; i < MAX_CHAR; i++){
            if(freq[i] % 2 != 0){
                freq[i]--; // reduce by 1 to make it even
                return "" + (char)(i + 'a');
            }
        }
        return ""; // no odd-frequency char
    }

    // Function to construct lexicographically smallest palindrome
    static String findPalindromicString(String str) {
        int len = str.length();
        int[] freq = new int[MAX_CHAR];

        countFreq(str, freq);

        if(!canMakePalindrome(freq, len)){
            return "No Palindromic String";
        }

        String oddChar = findOddAndReduce(freq);
        StringBuilder front = new StringBuilder();
        StringBuilder rear = new StringBuilder();

        // Build half of the palindrome in lexicographic order
        for(int i = 0; i < MAX_CHAR; i++){
            if(freq[i] > 0){
                char ch = (char)(i + 'a');
                int halfCount = freq[i] / 2;
                for(int j = 0; j < halfCount; j++){
                    front.append(ch);
                }
            }
        }

        // rear = reverse of front
        rear = new StringBuilder(front).reverse();  
        return front.toString() + oddChar + rear.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = scanner.nextLine().toLowerCase();
        System.out.println(findPalindromicString(str));
        scanner.close();
    }
}
