import java.util.Scanner;

public class employeeBonus {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] salaries = new double[10];
        int[] yearsOfService = new int[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        System.out.println("Enter salary and years of service for 10 employees:");

        for (int i = 0; i < 10; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Employee " + (i + 1) + " Salary: ");
                if (!input.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a valid salary.");
                    input.next(); // Clear invalid input
                    continue;
                }
                salaries[i] = input.nextDouble();

                System.out.print("Employee " + (i + 1) + " Years of Service: ");
                if (!input.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid number of years.");
                    input.next(); // Clear invalid input
                    continue;
                }
                yearsOfService[i] = input.nextInt();

                validInput = true;
            }
        }

        for (int i = 0; i < 10; i++) {
            double bonusPercentage = (yearsOfService[i] > 5) ? 0.05 : 0.02;
            bonuses[i] = salaries[i] * bonusPercentage;
            newSalaries[i] = salaries[i] + bonuses[i];

            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        System.out.println("\nTotal Bonus Payout: $" + totalBonus);
        System.out.println("Total Old Salary: $" + totalOldSalary);
        System.out.println("Total New Salary: $" + totalNewSalary);

        input.close();
    }
}