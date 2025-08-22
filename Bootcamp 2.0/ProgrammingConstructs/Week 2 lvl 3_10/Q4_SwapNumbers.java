import java.util.Scanner; // Import Scanner class for user input

public class Q4_SwapNumbers {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        // Create Scanner object to take input from the user
        Scanner nums = new Scanner(System.in);

        // Prompt user to enter first number
        System.out.print("Enter first number: ");
        int number1 = nums.nextInt(); // Read first number input

        // Prompt user to enter second number
        System.out.print("Enter second number: ");
        int number2 = nums.nextInt(); // Read second number input

        // Swap the numbers using a temporary variable
        int temp = number1;
        number1 = number2;
        number2 = temp;

        // Display the swapped numbers
        System.out.println("The swapped numbers are " + number1 + " and " + number2);

        // Close the scanner to prevent resource leak
        nums.close();
    }
}