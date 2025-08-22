import java.util.Scanner;

public class BMIAnalyzer2D {

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

        double[][] personData = new double[numPersons][3]; // [persons][weight, height, BMI]
        String[] weightStatus = new String[numPersons];

        // Input weight and height
        for (int i = 0; i < numPersons; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
                if (!input.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a valid weight (kg).");
                    input.next();
                    continue;
                }
                double weight = input.nextDouble();
                if (weight <= 0) {
                    System.out.println("Weight must be positive. Please re-enter.");
                    continue;
                }
                personData[i][0] = weight;

                System.out.print("Enter height (m) for person " + (i + 1) + ": ");
                if (!input.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a valid height (m).");
                    input.next();
                    continue;
                }
                double height = input.nextDouble();
                if (height <= 0) {
                    System.out.println("Height must be positive. Please re-enter.");
                    continue;
                }
                personData[i][1] = height;

                validInput = true;
            }
        }

        // Calculate BMI and status
        for (int i = 0; i < numPersons; i++) {
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);
            weightStatus[i] = getBMIStatus(personData[i][2]);
        }

        // Display results
        System.out.println("\nBMI Analysis:");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-20s\n", "Height (m)", "Weight (kg)", "BMI", "Weight Status");
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-20s\n", personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
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