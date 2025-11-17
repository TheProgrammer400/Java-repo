import java.util.*;

public class AliceApple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days Alice eats apples: ");
        int n = sc.nextInt();

        long originalApples = (long) Math.pow(2, n) - 1;
        
        System.out.println("Alice originally had " + originalApples + " apples.");
    }
}