import java.util.Scanner;

public class SubstringComparison {

    // Method to create substring using charAt()
    public static String substringUsingCharAt(String str, int start, int end) {

        String result = "";

        for (int i = start; i < end; i++) {
            result = result + str.charAt(i);
        }

        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareUsingCharAt(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String text = scanner.next();

        // Input indices
        System.out.print("Enter start index: ");
        int start = scanner.nextInt();

        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        // Validation check
        if (start < 0 || end > text.length() || start > end) {
            System.out.println("Invalid indices!");
            return;
        }

        // Substring using charAt()
        String subCharAt = substringUsingCharAt(text, start, end);

        // Substring using built-in method
        String subBuiltIn = text.substring(start, end);

        // Compare both results
        boolean result = compareUsingCharAt(subCharAt, subBuiltIn);

        // Display results
        System.out.println("Substring using charAt(): " + subCharAt);
        System.out.println("Substring using built-in substring(): " + subBuiltIn);
        System.out.println("Both substrings are equal: " + result);

        scanner.close();
    }
}