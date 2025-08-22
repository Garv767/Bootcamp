import java.util.Scanner;

public class largestSecondLargestDigits {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");

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

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        while (number != 0) {
            digits[index] = number % 10;
            number /= 10;
            index++;

            if (index == maxDigit) {
                break;
            }
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        if (index == 0) {
            System.out.println("No digits to analyze.");
        } else if (index == 1) {
            System.out.println("Largest digit: " + largest);
            System.out.println("Second largest digit: Not found.");
        } else {
            System.out.println("Largest digit: " + largest);
            if (secondLargest == Integer.MIN_VALUE) {
                System.out.println("Second largest digit: Not found.");
            } else {
                System.out.println("Second largest digit: " + secondLargest);
            }
        }

        input.close();
    }
}