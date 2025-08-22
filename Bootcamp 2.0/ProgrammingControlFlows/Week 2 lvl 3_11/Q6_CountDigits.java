import java.util.Scanner;

public class Q6_CountDigits {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");

        if (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            input.close();
            return;
        }

        int number = input.nextInt();

        if (number == 0) { // Handle the case where the number is 0 separately
            System.out.println("The number of digits is 1.");
            input.close();
            return;
        }

        if (number < 0) {
            number = -number; // Make the number positive if it's negative
        }

        int count = 0;

        while (number != 0) {
            number /= 10; // Remove the last digit
            count++;
        }

        System.out.println("The number of digits is: " + count);

        input.close();
    }
}