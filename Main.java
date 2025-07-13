import java.io.*;
import java.util.*;

public class Main {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        try{
            File file1 = new File("person.txt");
            file1.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }

        int []arr = {1,2,3,4,5};
        int n = 5;

        try{
            FileWriter fileWriter = new FileWriter("person.txt");
            
            for(int i=0; i<n; i++){
                fileWriter.write(String.valueOf(arr[i]));
            }

            fileWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        try{
            File file2 = new File("person.txt");
            Scanner fileScan = new Scanner(file2);

            while (fileScan.hasNext()){
                String word = fileScan.next();
                int num = Integer.valueOf(word);
                System.out.println(word);
            }

            fileScan.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
