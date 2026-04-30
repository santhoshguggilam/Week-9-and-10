import java.util.Scanner;

public class CharArrayComparison {

    // Method 1: Convert String to char array WITHOUT toCharArray()
    public static char[] convertUsingCharAt(String str) {

        char[] arr = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        return arr;
    }

    // Method 2: Compare two char arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    // Helper method to print array
    public static void printArray(char[] arr) {
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String text = scanner.next();

        // User-defined conversion
        char[] userArray = convertUsingCharAt(text);

        // Built-in conversion
        char[] builtInArray = text.toCharArray();

        // Compare arrays
        boolean result = compareCharArrays(userArray, builtInArray);

        // Display results
        System.out.print("User-defined char array: ");
        printArray(userArray);

        System.out.print("Built-in char array: ");
        printArray(builtInArray);

        System.out.println("Both arrays are equal: " + result);

        scanner.close();
    }
}