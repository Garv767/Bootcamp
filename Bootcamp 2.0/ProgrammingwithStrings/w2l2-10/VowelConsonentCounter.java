import java.util.Scanner;

public class VowelConsonentCounter {

    public static String checkCharacterType(char ch) {
        // Convert to lowercase
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32); // Add 32 to get lowercase ASCII value
        }

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }


    public static int[] countVowelsAndConsonants(String str) {
        if (str == null || str.isEmpty()) {
            return new int[] {0, 0}; // Handle null or empty string
        }

        int vowelCount = 0;
        int consonantCount = 0;
        int strLength = str.length(); //avoid calculating length in every loop iteration.

        for (int i = 0; i < strLength; i++) {
            char ch = str.charAt(i);
            String charType = checkCharacterType(ch);
            if (charType.equals("Vowel")) {
                vowelCount++;
            } else if (charType.equals("Consonant")) {
                consonantCount++;
            }
            // else, do nothing, it is not a letter
        }
        return new int[] { vowelCount, consonantCount };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        scanner.close();

        int[] counts = countVowelsAndConsonants(inputString);

        if (counts != null) {
            System.out.println("Vowel Count: " + counts[0]);
            System.out.println("Consonant Count: " + counts[1]);
        } else {
            System.out.println("Invalid input string."); // Handle the null case, though it should not happen
        }
    }
}

