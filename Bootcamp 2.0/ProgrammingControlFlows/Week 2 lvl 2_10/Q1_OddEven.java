import java.util.Scanner;

public class Q1_OddEven {

    public static void printOddEven(int number) {
        if (number <= 0) {
            System.out.println("Invalid input. Please enter a positive integer.");
            return; // Exit early if input is invalid
        }

        System.out.println("Odd numbers:");
        for (int i = 1; i <= number; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println(); // New line for better formatting

        System.out.println("Even numbers:");
        for (int i = 2; i <= number; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println(); // New line for better formatting
    }


    public static void printOddEvenSingleLoop(int number) {
         if (number <= 0) {
            System.out.println("Invalid input. Please enter a positive integer.");
            return;
        }

         System.out.println("Numbers from 1 to " + number + ":");
         for (int i = 1; i <= number; i++) {
             if (i % 2 == 0) {
                 System.out.println(i + " is even");
             } else {
                 System.out.println(i + " is odd");
             }
         }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num;

        while (true) {  // Input loop for validation
            try {
                System.out.print("Enter a positive integer: ");
                num = input.nextInt();
                if (num > 0) {
                    break; // Exit the loop if input is valid
                } else {
                    System.out.println("Please enter a number greater than zero.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                input.next(); // Clear the invalid input from the scanner
            }
        }

        printOddEven(num);
        System.out.println("--- Single Loop Version ---"); // Separator
        printOddEvenSingleLoop(num);
        input.close(); // Close the scanner to prevent resource leaks
    }
}