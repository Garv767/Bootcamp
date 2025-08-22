import java.util.Scanner;

public class StringUtilClass {

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

    public static String[][] getCharacterFrequencies(String str) {
        if (str == null || str.isEmpty()) {
            return new String[0][0];
        }

        int[] charFrequencies = new int[256];
        int strLength = str.length();

        for (int i = 0; i < strLength; i++) {
            char c = str.charAt(i);
            charFrequencies[c]++;
        }

        int uniqueCharCount = 0;
        for (int frequency : charFrequencies) {
            if (frequency > 0) {
                uniqueCharCount++;
            }
        }

        String[][] charFrequencyArray = new String[uniqueCharCount][2];
        int arrayIndex = 0;
        for (int i = 0; i < 256; i++) {
            if (charFrequencies[i] > 0) {
                charFrequencyArray[arrayIndex][0] = String.valueOf((char) i);
                charFrequencyArray[arrayIndex][1] = String.valueOf(charFrequencies[i]);
                arrayIndex++;
            }
        }
        return charFrequencyArray;
    }

    public static void displayCharacterFrequencies(String[][] charFrequencies) {
        if (charFrequencies == null || charFrequencies.length == 0) {
            System.out.println("No characters to display.");
            return;
        }

        System.out.println("Character\tFrequency");
        System.out.println("-------------------------");
        for (String[] row : charFrequencies) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
    }

    public static char[] uniqueCharacters(String text) {
        if (text == null || text.isEmpty()) {
            return new char[0];
        }

        int textLength = text.length();
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

    public static String[][] getCharacterFrequenciesUsingUnique(String str) {
           if (str == null || str.isEmpty()) {
            return new String[0][0];
        }
        char[] uniqueCharsArr = uniqueCharacters(str);
        String[][] charFrequencyArray = new String[uniqueCharsArr.length][2];
        for (int i = 0; i < uniqueCharsArr.length; i++) {
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == uniqueCharsArr[i]) {
                    count++;
                }
            }
            charFrequencyArray[i][0] = String.valueOf(uniqueCharsArr[i]);
            charFrequencyArray[i][1] = String.valueOf(count);
        }
        return charFrequencyArray;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        scanner.close();

        char firstNonRepeating = StringUtilClass.findFirstNonRepeatingCharacter(inputString);
        if (firstNonRepeating != '\0') {
            System.out.println("The first non-repeating character is: " + firstNonRepeating);
        } else {
            System.out.println("No non-repeating character found.");
        }

        String[][] frequencyArray = StringUtilClass.getCharacterFrequencies(inputString);
        StringUtils.displayCharacterFrequencies(frequencyArray);

        String[][] frequencyArrayUnique = StringUtilClass.getCharacterFrequenciesUsingUnique(inputString);
        System.out.println("\nCharacter Frequencies using Unique Characters:");
        StringUtils.displayCharacterFrequencies(frequencyArrayUnique);
    }
}

