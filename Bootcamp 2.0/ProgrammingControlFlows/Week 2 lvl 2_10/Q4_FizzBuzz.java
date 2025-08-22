import java.util.Scanner;

public class Q4_FizzBuzz {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        if (!input.hasNextInt()) { // Check if the next input is an integer
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

        for (int i = 0; i <= number; i++) {
            String output = ""; // Initialize an empty string for each number

            if (i % 3 == 0) {
                output += "Fizz"; // Append "Fizz" if divisible by 3
            }
            if (i % 5 == 0) {
                output += "Buzz"; // Append "Buzz" if divisible by 5
            }

            if (output.isEmpty()) { // If the string is still empty, print the number
                System.out.println(i);
            } else {
                System.out.println(output); // Otherwise, print "Fizz", "Buzz", or "FizzBuzz"
            }
        }

        input.close();
    }
}