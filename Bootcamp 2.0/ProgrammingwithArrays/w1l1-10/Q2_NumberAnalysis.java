import java.util.Scanner;

public class Q2_NumberAnalysis {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] numbers = new int[5]; // Array to store 5 numbers

        System.out.println("Enter 5 numbers:");

        // Input 5 numbers
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            if (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                input.next(); // Clear invalid input
                i--; // Re-enter input for the same index
                continue;
            }
            numbers[i] = input.nextInt();
        }

        System.out.println("\nNumber Analysis:");

        // Analyze each number
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];

            if (num > 0) {
                if (num % 2 == 0) {
                    System.out.println("Number " + (i + 1) + " (" + num + ") is positive and even.");
                } else {
                    System.out.println("Number " + (i + 1) + " (" + num + ") is positive and odd.");
                }
            } else if (num < 0) {
                System.out.println("Number " + (i + 1) + " (" + num + ") is negative.");
            } else {
                System.out.println("Number " + (i + 1) + " (" + num + ") is zero.");
            }
        }

        // Compare first and last elements
        if (numbers[0] == numbers[numbers.length - 1]) {
            System.out.println("\nFirst and last elements are equal.");
        } else if (numbers[0] > numbers[numbers.length - 1]) {
            System.out.println("\nFirst element is greater than the last element.");
        } else {
            System.out.println("\nFirst element is less than the last element.");
        }

        input.close();
    }
}