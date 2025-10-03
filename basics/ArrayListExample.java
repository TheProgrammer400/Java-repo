import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {
    public static void main(String[] args) {
        // Create an ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        
        // Add elements to the ArrayList
        list.add(0);
        list.add(2);
        list.add(3);
        System.out.println("Initial list: " + list);
        
        // Access an element by index
        int element = list.get(2);
        System.out.println("Element at index 2: " + element);
        
        // Add an element at a specific index
        list.add(1, 1); // index, element to insert
        System.out.println("After adding 1 at index 1: " + list);
        
        // Update an element at a specific index
        list.set(0, 5);
        System.out.println("After setting index 0 to 5: " + list);
        
        // Remove an element by index
        list.remove(0);
        System.out.println("After removing element at index 0: " + list);
        
        // Get the size of the ArrayList
        int size = list.size();
        System.out.println("Size of the list: " + size);
        
        // Iterate through the ArrayList
        for (int i = 0; i < size; i++) {
            System.out.println("Element at index " + i + ": " + list.get(i));
        }
        
        // Find the index of an element
        int indexOf2 = list.indexOf(2);
        System.out.println("Index of element 2: " + indexOf2);
        
        // Sort the ArrayList
        Collections.sort(list);
        System.out.println("Sorted list: " + list);
        
        // Reverse the ArrayList
        Collections.reverse(list);
        System.out.println("Reversed list: " + list);
    }
}
