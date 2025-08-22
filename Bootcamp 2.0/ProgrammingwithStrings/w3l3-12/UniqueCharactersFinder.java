import java.util.Arrays;
import java.util.Scanner;

public class UniqueCharactersFinder {

    public static int findStringLength(String str) {
        if (str == null) {
            return 0;
        }
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static char[] findUniqueCharacters(String text) {
        if (text == null || text.isEmpty()) {
            return new char[0];
        }

        int textLength = findStringLength(text);
        char[] uniqueChars = new char[textLength];
        int uniqueCount = 0;

        for (int i = 0; i < textLength; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < uniqueCount; j++) {
                if (currentChar == uniqueChars[j]) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                uniqueChars[uniqueCount++] = currentChar;
            }
        }

        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = uniqueChars[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        scanner.close();

        char[] uniqueCharsArray = findUniqueCharacters(inputString);
        System.out.println("Unique characters: " + Arrays.toString(uniqueCharsArray));
    }
}

