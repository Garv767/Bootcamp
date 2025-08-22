    import java.util.Scanner;

public class BmiCalculator {

    public static double[][] getWeightAndHeight(Scanner scanner, int numPersons) {
        double[][] data = new double[numPersons][2];
        for (int i = 0; i < numPersons; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = scanner.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = scanner.nextDouble();
        }
        return data;
    }

    public static String[][] calculateBmiAndStatus(double[][] personData) {
        int numPersons = personData.length;
        String[][] results = new String[numPersons][4];
        for (int i = 0; i < numPersons; i++) {
            double weight = personData[i][0];
            double heightInCm = personData[i][1];
            double heightInMeter = heightInCm / 100;
            double bmi = weight / (heightInMeter * heightInMeter);
            String status;

            if (bmi < 18.5) {
                status = "Underweight";
            } else if (bmi < 24.9) {
                status = "Normal Weight";
            } else if (bmi < 29.9) {
                status = "Overweight";
            } else {
                status = "Obese";
            }

            results[i][0] = String.format("%.2f", heightInCm);
            results[i][1] = String.format("%.2f", weight);
            results[i][2] = String.format("%.2f", bmi);
            results[i][3] = status;
        }
        return results;
    }

    public static void displayResults(String[][] results) {
        System.out.println("------------------------------------------------------------------");
        System.out.println("Height (cm)\tWeight (kg)\tBMI\t\tStatus");
        System.out.println("------------------------------------------------------------------");
        for (String[] row : results) {
            System.out.println(row[0] + "\t\t" + row[1] + "\t\t" + row[2] + "\t" + row[3]);
        }
        System.out.println("------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPersons = 10;
        double[][] personData = getWeightAndHeight(scanner, numPersons);
        scanner.close();

        String[][] results = calculateBmiAndStatus(personData);
        displayResults(results);
    }
}

