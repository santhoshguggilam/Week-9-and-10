public class NullPointerExceptionDemo {

    // Method 1: Generates NullPointerException
    public static void generateException() {

        String text = null;

        // This will throw NullPointerException
        System.out.println("Length: " + text.length());
    }

    // Method 2: Handles NullPointerException using try-catch
    public static void handleException() {

        String text = null;

        try {
            // This will throw exception but will be handled
            System.out.println("Uppercase: " + text.toUpperCase());
        } catch (NullPointerException e) {
            System.out.println("Exception handled: Cannot perform operation on null string");
        }

        System.out.println("Program continues after handling exception.");
    }

    public static void main(String[] args) {

        System.out.println("=== Calling method that generates exception ===");

        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Exception occurred in generateException(): " + e);
        }

        System.out.println("\n=== Calling method that handles exception ===");
        handleException();
    }
}