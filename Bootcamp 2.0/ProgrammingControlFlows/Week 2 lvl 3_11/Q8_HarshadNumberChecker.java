import java.util.Scanner;

public class Q8_HarshadNumberChecker {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number to check for Harshad property: ");

        if (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            input.close();
            return;
        }

        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            input.close();
            return;
        }

        int originalNumber = number; // Store the original number
        int sumOfDigits = 0; // Initialize sum of digits to 0

        while (originalNumber != 0) {
            int digit = originalNumber % 10; // Get the last digit (remainder)
            sumOfDigits += digit; // Add the digit to the sum
            originalNumber /= 10; // Remove the last digit (quotient)
        }

        if (number % sumOfDigits == 0) {
            System.out.println(number + " is a Harshad number.");
        } else {
            System.out.println(number + " is not a Harshad number.");
        }

        input.close();
    }
}