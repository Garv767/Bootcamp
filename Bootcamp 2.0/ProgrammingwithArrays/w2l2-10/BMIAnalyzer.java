import java.util.Scanner;

public class BMIAnalyzer {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");

        if (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            input.close();
            return;
        }

        int numPersons = input.nextInt();

        if (numPersons <= 0) {
            System.out.println("Please enter a positive integer for the number of persons.");
            input.close();
            return;
        }

        double[] weights = new double[numPersons];
        double[] heights = new double[numPersons];
        double[] bmis = new double[numPersons];
        String[] statuses = new String[numPersons];

        // Input weight and height
        for (int i = 0; i < numPersons; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            if (!input.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid weight (kg).");
                input.next();
                i--;
                continue;
            }
            weights[i] = input.nextDouble();

            System.out.print("Enter height (m) for person " + (i + 1) + ": ");
            if (!input.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid height (m).");
                input.next();
                i--;
                continue;
            }
            heights[i] = input.nextDouble();
        }

        // Calculate BMI and status
        for (int i = 0; i < numPersons; i++) {
            bmis[i] = weights[i] / (heights[i] * heights[i]);
            statuses[i] = getBMIStatus(bmis[i]);
        }

        // Display results
        System.out.println("\nBMI Analysis:");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-20s\n", "Height (m)", "Weight (kg)", "BMI", "Weight Status");
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-20s\n", heights[i], weights[i], bmis[i], statuses[i]);
        }

        input.close();
    }

    public static String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal weight";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}