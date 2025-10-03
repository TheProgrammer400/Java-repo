package basics;
import java.util.Scanner;

public class CharToIntAndIntToChar {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the character: ");
        char letter = scan.next().charAt(0);

        // convert letter to its ASCII value
        int n = (int) letter;
        System.out.printf("ASCII value of %c is: %d\n", letter, n);

        // convert number to character

        char newLetter = (char) n;
        System.out.printf("Converted letter: %c\n", newLetter);
        

        scan.close();
    }
}
