import java.util.Scanner;

public class StringLengthFinder {

  
    public static int findStringLength(String str) {
        if (str == null) {
            throw new NullPointerException("Input string cannot be null.");
        }
        int count = 0;
        try {
            while (true) {
                str.charAt(count); // Keep accessing characters until an exception occurs
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // This exception is expected when we go beyond the string's end.
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.next(); // Use next() to read one word.  Use nextLine() to read a whole line.
        scanner.close();

        // Find the length using the custom method
        int customLength = findStringLength(inputString);
        System.out.println("Length of the string (using custom method): " + customLength);

        // Find the length using the built-in length() method
        int builtInLength = inputString.length();
        System.out.println("Length of the string (using built-in length() method): " + builtInLength);
    }
}

