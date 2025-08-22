import java.util.Scanner;

public class Q2_EmployeeBonus {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee salary: ");
        double salary = input.nextDouble();

        System.out.print("Enter years of service: ");
        int yearsOfService = input.nextInt();

        if (yearsOfService > 5) {
            double bonusPercentage = 0.05; // 5% bonus
            double bonusAmount = salary * bonusPercentage;
            System.out.println("Bonus amount: $" + bonusAmount);
        } else {
            System.out.println("Employee is not eligible for a bonus.");
        }

        input.close(); // Close the scanner to prevent resource leaks
    }
}