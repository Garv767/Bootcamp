    import java.util.Scanner;

    public class StringUtils {

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

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a string: ");
            String inputString = scanner.nextLine();
            scanner.close();

            char firstNonRepeating = StringUtils.findFirstNonRepeatingCharacter(inputString);
            if (firstNonRepeating != '\0') {
                System.out.println("The first non-repeating character is: " + firstNonRepeating);
            } else {
                System.out.println("No non-repeating character found.");
            }

            String[][] frequencyArray = StringUtils.getCharacterFrequencies(inputString);
            StringUtils.displayCharacterFrequencies(frequencyArray);
        }
    }

