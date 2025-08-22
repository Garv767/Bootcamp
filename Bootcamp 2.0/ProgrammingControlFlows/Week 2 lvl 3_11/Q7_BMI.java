import java.util.Scanner;
import java.text.DecimalFormat; // Import for formatting BMI to two decimal places

public class Q7_BMI {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00"); // Create DecimalFormat object

        System.out.print("Enter weight in kilograms (kg): ");

        if (!input.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid weight (in kg).");
            input.close();
            return;
        }
        double weight = input.nextDouble();

        System.out.print("Enter height in centimeters (cm): ");

        if (!input.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid height (in cm).");
            input.close();
            return;
        }

        double heightCm = input.nextDouble();

        if (weight <= 0 || heightCm <= 0) {
            System.out.println("Weight and height must be positive values.");
            input.close();
            return;
        }

        double heightM = heightCm / 100; // Convert height from cm to meters
        double bmi = weight / (heightM * heightM);

        System.out.println("Your BMI is: " + df.format(bmi) + " kg/m^2"); // Format BMI to two decimal places

        String weightStatus;

        if (bmi < 18.5) {
            weightStatus = "Underweight";
        } else if (bmi < 25) {
            weightStatus = "Normal weight";
        } else if (bmi < 30) {
            weightStatus = "Overweight";
        } else {
            weightStatus = "Obese";
        }

        System.out.println("Weight Status: " + weightStatus);

        input.close();
    }
}