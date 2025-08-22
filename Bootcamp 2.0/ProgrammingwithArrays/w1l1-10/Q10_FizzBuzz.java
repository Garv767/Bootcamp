import java.util.Scanner;

public class Q10_FizzBuzz {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");

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

        String[] results = new String[number];

        for (int i = 0; i < number; i++) {
            int currentNumber = i + 1; // Adjust for 1-based indexing

            if (currentNumber % 3 == 0 && currentNumber % 5 == 0) {
                results[i] = "FizzBuzz";
            } else if (currentNumber % 3 == 0) {
                results[i] = "Fizz";
            } else if (currentNumber % 5 == 0) {
                results[i] = "Buzz";
            } else {
                results[i] = String.valueOf(currentNumber);
            }
        }

        for (int i = 0; i < number; i++) {
            System.out.println("Position " + (i + 1) + " = " + results[i]);
        }

        input.close();
    }
}