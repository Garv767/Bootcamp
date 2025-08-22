import java.util.Scanner;

public class Q5_ArmstrongNumberChecker {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number to check for Armstrong property: ");

        if (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            input.close();
            return;
        }

        int number = input.nextInt();

        if (number < 0) {
            System.out.println("Please enter a non-negative integer.");
            input.close();
            return;
        }

        int originalNumber = number; // Store the original number
        int sum = 0; // Initialize sum of cubes to 0

        while (originalNumber != 0) {
            int digit = originalNumber % 10; // Get the last digit (remainder)
            sum += Math.pow(digit, 3); // Calculate cube and add to sum
            originalNumber /= 10; // Remove the last digit (quotient)
        }

        if (sum == number) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }

        input.close();
    }
}
