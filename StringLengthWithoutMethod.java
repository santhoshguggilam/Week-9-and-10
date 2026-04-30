import java.util.Scanner;

public class StringLengthWithoutMethod {

    // Method to find length without using length()
    public static int findLength(String str) {

        int count = 0;

        try {
            // Infinite loop
            while (true) {
                str.charAt(count); // Access character
                count++;           // Increment count
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception occurs when index exceeds string length
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String text = scanner.next();

        // User-defined method
        int customLength = findLength(text);

        // Built-in method
        int actualLength = text.length();

        // Display results
        System.out.println("Length (without using length()): " + customLength);
        System.out.println("Length (using built-in length()): " + actualLength);

        scanner.close();
    }
}