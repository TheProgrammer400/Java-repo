import java.util.*;
 
public class BinaryPalindrome {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int n = scan.nextInt();

        String binaryNum = Integer.toBinaryString(n);
        String reverseBinaryNum = new StringBuilder(binaryNum).reverse().toString();

        if (binaryNum.equals(reverseBinaryNum)){
            System.out.println("Binary palindrome");
        } else {
            System.out.println("Not a binary palindrome");
        }

        scan.close();
    }
}
