import java.util.Scanner;

public class BMIAnalysis {

    public static double[][] calculateBMI(double[][] personData) {
        for (int i = 0; i < personData.length; i++) {
            double weight = personData[i][0];
            double heightInCm = personData[i][1];
            double heightInMeters = heightInCm / 100.0; // Convert cm to meters
            personData[i][2] = weight / (heightInMeters * heightInMeters);
        }
        return personData;
    }

    public static String[] getBMIStatus(double[][] personData) {
        String[] statuses = new String[personData.length];
        for (int i = 0; i < personData.length; i++) {
            double bmi = personData[i][2];
            if (bmi < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmi < 25) {
                statuses[i] = "Normal weight";
            } else if (bmi < 30) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        return statuses;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] personData = new double[10][3]; // [persons][weight, height(cm), BMI]

        System.out.println("Enter weight (kg) and height (cm) for 10 persons:");

        for (int i = 0; i < 3; i++) {
            boolean validInput = false;
            while(!validInput) {
                System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
                if (input.hasNextDouble()) {
                    personData[i][0] = input.nextDouble();
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Enter a double");
                    input.next();
                }
            }

            validInput = false;
            while(!validInput) {
                System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
                if (input.hasNextDouble()) {
                    personData[i][1] = input.nextDouble();
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Enter a double");
                    input.next();
                }
            }
        }

        personData = calculateBMI(personData);
        String[] statuses = getBMIStatus(personData);

        System.out.println("\nBMI Analysis:");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-20s\n", "Weight (kg)", "Height (cm)", "BMI", "Weight Status");
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < 3; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-20s\n", personData[i][0], personData[i][1], personData[i][2], statuses[i]);
        }

        input.close();
    }
}