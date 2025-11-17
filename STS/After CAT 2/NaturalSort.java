import java.util.*;
import java.util.regex.*;

class NaturalOrderComparator implements Comparator<String> {
    public static final Pattern pattern = Pattern.compile("(\\D*)(\\d*)");

    @Override
    public int compare(String s1, String s2){
        Matcher m1 = pattern.matcher(s1);
        Matcher m2 = pattern.matcher(s2);

        while (m1.find() && m2.find()) {
            // Compare non-digit text
            int textCompare = m1.group(1).compareTo(m2.group(1));

            if (textCompare != 0){
                return textCompare;
            }

            // Compare numeric parts
            String num1 = m1.group(2);
            String num2 = m2.group(2);

            // If both have no number, skip
            if (num1.isEmpty() && num2.isEmpty()){
                continue;
            }

            int n1, n2;

            if (num1.isEmpty()) {
                n1 = 0;
            } else {
                n1 = Integer.parseInt(num1);
            }

            if (num2.isEmpty()) {
                n2 = 0;
            } else {
                n2 = Integer.parseInt(num2);
            }


            if (n1 != n2){
                return n1 - n2;
            }
        }

        // Fallback lexicographical
        return s1.compareTo(s2);
    }
}

public class NaturalSort{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // consume newline

        List<String> list = new ArrayList<>();

        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }

        Collections.sort(list, new NaturalOrderComparator());

        System.out.println("Natural Sorted Order:");

        for (String s : list) {
            System.out.println(s);
        }

        scanner.close();
    }
}

