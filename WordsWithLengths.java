import java.util.Scanner;

public class WordsWithLengths {

    // Method 1: Find length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End reached
        }
        return count;
    }

    // Method 2: Split text into words using charAt()
    public static String[] splitUsingCharAt(String text) {

        int length = findLength(text);

        // Count words
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];

        int index = 0;
        String currentWord = "";

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ') {
                currentWord += text.charAt(i);
            } else {
                words[index++] = currentWord;
                currentWord = "";
            }
        }

        // Last word
        words[index] = currentWord;

        return words;
    }

    // Method 3: Create 2D array [word][length]
    public static String[][] getWordsWithLengths(String[] words) {

        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];

            int len = findLength(words[i]);

            // Convert int to String
            result[i][1] = String.valueOf(len);
        }

        return result;
    }

    // Method to display result in tabular format
    public static void displayTable(String[][] data) {

        System.out.println("\nWord\tLength");
        System.out.println("----------------");

        for (int i = 0; i < data.length; i++) {
            String word = data[i][0];

            // Convert String length back to int
            int length = Integer.parseInt(data[i][1]);

            System.out.println(word + "\t" + length);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        // Process
        String[] words = splitUsingCharAt(text);
        String[][] result = getWordsWithLengths(words);

        // Output
        displayTable(result);

        scanner.close();
    }
}