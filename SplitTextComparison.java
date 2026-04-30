import java.util.Scanner;

public class SplitTextComparison {

    // Method 1: Find length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End of string reached
        }
        return count;
    }

    // Method 2: Split text using charAt()
    public static String[] splitUsingCharAt(String text) {

        int length = findLength(text);

        // Step 1: Count words (spaces + 1)
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Step 2: Store space indexes
        int[] spaceIndexes = new int[wordCount - 1];
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }

        // Step 3: Extract words
        String[] words = new String[wordCount];

        int start = 0;
        for (int i = 0; i < wordCount - 1; i++) {
            int end = spaceIndexes[i];

            String word = "";
            for (int j = start; j < end; j++) {
                word += text.charAt(j);
            }

            words[i] = word;
            start = end + 1;
        }

        // Last word
        String lastWord = "";
        for (int j = start; j < length; j++) {
            lastWord += text.charAt(j);
        }
        words[wordCount - 1] = lastWord;

        return words;
    }

    // Method 3: Compare two string arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }

        return true;
    }

    // Helper method to print array
    public static void printArray(String[] arr) {
        for (String word : arr) {
            System.out.print(word + " | ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input text
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        // User-defined split
        String[] customWords = splitUsingCharAt(text);

        // Built-in split
        String[] builtInWords = text.split(" ");

        // Compare results
        boolean result = compareArrays(customWords, builtInWords);

        // Display results
        System.out.print("Custom split result: ");
        printArray(customWords);

        System.out.print("Built-in split result: ");
        printArray(builtInWords);

        System.out.println("Both results are equal: " + result);

        scanner.close();
    }
}