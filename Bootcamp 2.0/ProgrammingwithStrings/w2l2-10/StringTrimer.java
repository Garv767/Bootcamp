import java.util.Scanner;

public class StringTrimer {

    public static int[] trimSpaces(String str) {
        if (str == null || str.isEmpty()) {
            return new int[] { 0, -1 };
        }

        int start = 0;
        int end = str.length() - 1;

        while (start <= end && Character.isWhitespace(str.charAt(start))) {
            start++;
        }

        while (end >= start && Character.isWhitespace(str.charAt(end))) {
            end--;
        }

        return new int[] { start, end };
    }

    public static String substring(String str, int start, int end) {
        if (str == null) {
            return null;
        }
        if (start > end) {
            return "";
        }
        if (start < 0) {
            start = 0;
        }
        if (end >= str.length()) {
            end = str.length() - 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static boolean compareStrings(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return true;
        }
        if (str1 == null || str2 == null) {
            return false;
        }

        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 != len2) {
            return false;
        }

        for (int i = 0; i < len1; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string with leading/trailing spaces: ");
        String inputString = scanner.nextLine();
        scanner.close();

        int[] trimIndices = trimSpaces(inputString);
        String trimmedStringCustom = substring(inputString, trimIndices[0], trimIndices[1]);

        String trimmedStringBuiltIn = inputString.trim();

        boolean areEqual = compareStrings(trimmedStringCustom, trimmedStringBuiltIn);

        System.out.println("Trimmed String (Custom): \"" + trimmedStringCustom + "\"");
        System.out.println("Trimmed String (Built-in): \"" + trimmedStringBuiltIn + "\"");
        System.out.println("Strings are equal: " + areEqual);
    }
}

