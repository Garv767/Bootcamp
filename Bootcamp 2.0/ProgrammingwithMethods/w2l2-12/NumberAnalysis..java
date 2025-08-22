import java.util.Scanner;

public class NumberAnalysis {

    public static boolean isPositive(int number) {
        return number > 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");

        for (int i = 0; i < numbers.length; i++) {
            boolean validInput = false;
            while(!validInput) {
                System.out.print("Enter number " + (i + 1) + ": ");
                if (input.hasNextInt()) {
                    numbers[i] = input.nextInt();
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Enter an integer");
                    input.next();
                }
            }
        }

        System.out.println("\nNumber Analysis:");
        for (int number : numbers) {
            if (isPositive(number)) {
                if (isEven(number)) {
                    System.out.println(number + " is positive and even.");
                } else {
                    System.out.println(number + " is positive and odd.");
                }
            } else {
                System.out.println(number + " is negative or zero.");
            }
        }

        int comparisonResult = compare(numbers[0], numbers[numbers.length - 1]);
        System.out.println("\nComparison of first and last elements:");

        if (comparisonResult == 1) {
            System.out.println("First element is greater than the last element.");
        } else if (comparisonResult == 0) {
            System.out.println("First element is equal to the last element.");
        } else {
            System.out.println("First element is less than the last element.");
        }

        input.close();
    }
}