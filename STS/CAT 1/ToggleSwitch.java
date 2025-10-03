package STS;

import java.util.*;

public class ToggleSwitch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of switches: ");
        int n = scan.nextInt();

        System.out.println("Switches that are ON at the end:");
        
        for (int i = 1; i * i <= n; i++) {
            System.out.print((i * i) + " ");
        }
    }
}
