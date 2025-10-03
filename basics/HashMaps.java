package basics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HashMaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a HashMap
        HashMap<String, Integer> map = new HashMap<>();
        map.put("China", 150);  // Add key-value pairs
        map.put("India", 100);

        // Print the map
        System.out.println(map);

        // Update value for the key "India"
        map.put("India", 200);
        System.out.println(map);

        // Check if a key exists
        if (map.containsKey("India")) {
            System.out.println("It is present");
        } else {
            System.out.println("It's not present");
        }

        // Get value associated with a key
        int value = map.get("India");
        System.out.println(value);

        // Iterate through entries in the map
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // Iterate through keys in the map
        Set<String> keys = map.keySet();
        
        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }

        // Remove a key-value pair
        map.remove("China");
        System.out.println(map);

        scanner.close();
    }
}
