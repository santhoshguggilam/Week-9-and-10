import java.util.Scanner;

public class BMICalculator {

    // Method 1: Calculate BMI and Status for one person
    public static String[] calculateBMI(double weight, double heightCm) {

        double heightM = heightCm / 100.0; // convert cm to meters
        double bmi = weight / (heightM * heightM);

        String status;

        // BMI classification
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 24.9) {
            status = "Normal";
        } else if (bmi < 29.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        // Return BMI and status as String array
        return new String[] {
            String.format("%.2f", bmi),
            status
        };
    }

    // Method 2: Process all persons
    public static String[][] processBMI(double[][] data) {

        String[][] result = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {

            double weight = data[i][0];
            double height = data[i][1];

            String[] bmiData = calculateBMI(weight, height);

            result[i][0] = String.valueOf(height);
            result[i][1] = String.valueOf(weight);
            result[i][2] = bmiData[0];
            result[i][3] = bmiData[1];
        }

        return result;
    }

    // Method 3: Display in tabular format
    public static void display(String[][] result) {

        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\tStatus");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < result.length; i++) {
            System.out.println(
                result[i][0] + "\t\t" +
                result[i][1] + "\t\t" +
                result[i][2] + "\t" +
                result[i][3]
            );
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[][] data = new double[10][2]; // [weight][height]

        // Input for 10 members
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Person " + (i + 1));

            System.out.print("Weight (kg): ");
            data[i][0] = scanner.nextDouble();

            System.out.print("Height (cm): ");
            data[i][1] = scanner.nextDouble();
        }

        // Process BMI
        String[][] result = processBMI(data);

        // Display result
        display(result);

        scanner.close();
    }
}