package STS;

import java.util.*;

public class Strobo {
    public static boolean isStrobo(int n){
        String num = String.valueOf(n);

        Map<Character, Character> map = new HashMap<> ();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');

        int left = 0;
        int right = num.length() - 1;

        while (left <= right){
            char l = num.charAt(left);
            char r = num.charAt(right);

            if (!map.containsKey(l) || map.get(l) != r){
                return false;
            }

            left++;
            right--;

        }

        return true;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        if (isStrobo(n)){
            System.out.println("Number is Strobogrammatica");
        } else {
            System.out.println("Number ain't Strobogrammatic");
        }

        scan.close();
    }
}
