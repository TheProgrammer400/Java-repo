import java.util.*;

public class NibbleSwap {
    public static int swapNibbles(int n){
        n = n & 0xFF;

        int swapNum = ((n & 0x0F << 4) | (n & 0xF0 >>> 4));
        return swapNum;
    }

    public static void main(String []args){
        int n = 45;
        int swapNum = swapNibbles(n);

        System.out.println(n);
    }
}
