import java.util.Scanner;

public class VowelConsonentDisplay {

    public static String checkCharacterType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
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

    public static String[][] getCharacterTypes(String str) {
        if (str == null) {
            return new String[0][0];
        }

        int strLength = str.length();
        String[][] charTypes = new String[strLength][2];

        for (int i = 0; i < strLength; i++) {
            char ch = str.charAt(i);
            charTypes[i][0] = String.valueOf(ch);
            charTypes[i][1] = checkCharacterType(ch);
        }
        return charTypes;
    }

    public static void displayCharacterTypes(String[][] charTypes) {
        if (charTypes == null || charTypes.length == 0) {
            System.out.println("No characters to display.");
            return;
        }

        System.out.println("Character\tType");
        System.out.println("--------------------");
        for (String[] row : charTypes) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        scanner.close();

        String[][] charTypesArray = getCharacterTypes(inputString);
        displayCharacterTypes(charTypesArray);
    }
}

