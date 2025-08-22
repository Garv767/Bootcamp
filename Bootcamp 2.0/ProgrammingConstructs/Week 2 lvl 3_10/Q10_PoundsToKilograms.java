import java.util.Scanner;

public class Q10_PoundsToKilograms {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the weight in pounds: ");
        double weightPounds = input.nextDouble();
        // Conversion factor: 1 pound = 0.453592 kilograms (more accurate)
        double kilogramsPerPound = 0.453592;  // Or use 2.2 if you want to use the hint's value
        // Calculate weight in kilograms
        double weightKilograms = weightPounds * kilogramsPerPound;
        // Print the results, formatted to two decimal places
        System.out.printf("The weight of the person in pounds is %.2f and in kg is %.2f%n", weightPounds, weightKilograms);
        input.close(); // Close the scanner
    }
}