import java.util.Scanner;

public class largestSecondLargestDigitsDynamic {

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
                maxDigit += 10; // Increase maxDigit by 10
                int[] temp = new int[maxDigit];
                System.arraycopy(digits, 0, temp, 0, digits.length);
                digits = temp; // Update digits array
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