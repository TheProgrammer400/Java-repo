package basics;
public class StringBuilderExample {
    public static void main(String[] args) {
        // Create a StringBuilder
        StringBuilder sb = new StringBuilder("Hello");

        // Append text
        sb.append(" World");
        System.out.println("After append: " + sb);

        // Insert text
        sb.insert(6, "Java ");
        System.out.println("After insert: " + sb);

        // Replace text
        sb.replace(6, 10, "Beautiful");
        System.out.println("After replace: " + sb);

        // Delete text
        sb.delete(6, 15);
        System.out.println("After delete: " + sb);

        // Reverse the string
        sb.reverse();
        System.out.println("After reverse: " + sb);

        // Get length and capacity
        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());
    }
}
