import java.util.*;

public class EuclidsAlgo {
    public static int eucliAlgo(int x, int y){
        int remainder;

        while (y != 0){ // value of remainder is assigned to y, that's why y != 0
            remainder = x % y;
            x = y;
            y = remainder;
        }

        return x;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = scan.nextInt();
        int y = scan.nextInt();

        System.out.println(eucliAlgo(x, y));
    }
}
