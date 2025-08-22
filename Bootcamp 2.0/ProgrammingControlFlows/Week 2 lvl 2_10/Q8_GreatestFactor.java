import java.util.Scanner;

public class Q8_GreatestFactor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");

        if (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            input.close();
            return;
        }

        int number = input.nextInt();

        if (number <= 1) { // 1 and numbers less than 1 don't have factors other than 1 and themselves
            System.out.println("Numbers greater than 1 have factors besides 1 and themselves.");
            input.close();
            return;
        }

        int greatestFactor = 1; // Initialize to 1 (1 is always a factor)

        for (int i = number - 1; i >= 1; i--) { // Loop from number-1 down to 1
            if (number % i == 0) {
                greatestFactor = i;
                break; // Exit the loop as soon as the greatest factor is found
            }
        }

        System.out.println("The greatest factor of " + number + " (besides itself) is: " + greatestFactor);

        input.close();
    }
}