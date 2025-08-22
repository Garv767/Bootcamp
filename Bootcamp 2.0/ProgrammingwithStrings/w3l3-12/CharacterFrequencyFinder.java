import java.util.Scanner;

public class CharacterFrequencyFinder {

    public static String[] getCharacterFrequenciesNestedLoop(String str) {
        if (str == null || str.isEmpty()) {
            return new String[0];
        }

        char[] textChars = str.toCharArray();
        int strLength = textChars.length;
        int[] frequencies = new int[strLength];
        int uniqueCharCount = 0;

        for (int i = 0; i < strLength; i++) {
            if (textChars[i] != '0') {
                int count = 1;
                for (int j = i + 1; j < strLength; j++) {
                    if (textChars[i] == textChars[j]) {
                        count++;
                        textChars[j] = '0';
                    }
                }
                frequencies[uniqueCharCount] = count;
                uniqueCharCount++;
            }
        }
        String[] result = new String[uniqueCharCount * 2];
        int resultIndex = 0;
        for (int i = 0; i < strLength; i++) {
            if (textChars[i] != '0') {
                result[resultIndex++] = String.valueOf(textChars[i]);
                result[resultIndex++] = String.valueOf(frequencies[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        scanner.close();

        String[] frequencyArrayNestedLoop = CharacterFrequencyFinder.getCharacterFrequenciesNestedLoop(inputString);
        System.out.println("\nCharacter Frequencies using Nested Loop:");
        if (frequencyArrayNestedLoop.length == 0)
             System.out.println("No characters to display");
        else {
            System.out.println("Character\tFrequency");
            System.out.println("-------------------------");
            for (int i = 0; i < frequencyArrayNestedLoop.length; i += 2) {
                System.out.println(frequencyArrayNestedLoop[i] + "\t\t" + frequencyArrayNestedLoop[i + 1]);
            }
        }
    }
}

