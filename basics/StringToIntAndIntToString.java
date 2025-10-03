package basics;
import java.util.Scanner;

public class StringToIntAndIntToString {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String word = scan.next();

        int n = Integer.parseInt(word);
        System.out.printf("Converted integer: %d\n", n);      

        scan.close();
    }
}
