package basics;
import java.util.Scanner;

public class CheckInteger {
    public static Boolean isInteger(String n) throws NumberFormatException{
        try{
            Integer.parseInt(n);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        if (isInteger("23")){
            System.out.println("Is an integer");
        } else {
            System.out.println("not an integer");
        }

        scan.close();
    }
}
