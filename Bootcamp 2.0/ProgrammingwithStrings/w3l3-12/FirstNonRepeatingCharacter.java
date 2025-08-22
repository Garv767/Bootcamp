import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingCharacter(String str) {
        if (str == null || str.isEmpty()) {
            return '\0';
        }

        int[] charFrequencies = new int[256];
        int strLength = str.length();

        for (int i = 0; i < strLength; i++) {
            char c = str.charAt(i);
            charFrequencies[c]++;
        }

        for (int i = 0; i < strLength; i++) {
            char c = str.charAt(i);
            if (charFrequencies[c] == 1) {
                return c;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        scanner.close();

        char firstNonRepeating = findFirstNonRepeatingCharacter(inputString);
        if (firstNonRepeating != '\0') {
            System.out.println("The first non-repeating character is: " + firstNonRepeating);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}

