import java.util.*;

public class LeadersInArray {
    public static ArrayList<Integer> findLeaders(int []arr, int n){
        int maxFromRight = arr[n-1];

        ArrayList<Integer> leaders = new ArrayList<>();
        leaders.add(maxFromRight); // last element is always a leader

        for(int i = n-2; i>=0; i--){
            if (maxFromRight < arr[i]){
                leaders.add(arr[i]);
                maxFromRight = arr[i];
            }
        }

        return leaders;
    }
    
    public static void main(String []args){
        int []arr = {1, 2, 12, 13, 0, 6};
        int n = arr.length;

        ArrayList<Integer> leaders = findLeaders(arr, n);

        for(int leader: leaders){
            System.out.println(leader);
        }
    }
}
