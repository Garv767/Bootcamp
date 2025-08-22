import java.util.Scanner;

public class digitFrequency {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");

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

        int tempNumber = number;
        int digitCount = 0;

        // Count digits
        if (tempNumber == 0) {
            digitCount = 1;
        } else {
            while (tempNumber != 0) {
                tempNumber /= 10;
                digitCount++;
            }
        }

        int[] digits = new int[digitCount];
        int index = 0;
        tempNumber = number; // Reset tempNumber

        // Extract digits
        while (tempNumber != 0) {
            digits[index] = tempNumber % 10;
            tempNumber /= 10;
            index++;
        }

        int[] frequency = new int[10]; // Frequency array for digits 0-9

        // Calculate frequency
        for (int digit : digits) {
            frequency[digit]++;
        }

        // Display frequency
        System.out.println("Digit frequencies:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i]);
            }
        }

        input.close();
    }
}