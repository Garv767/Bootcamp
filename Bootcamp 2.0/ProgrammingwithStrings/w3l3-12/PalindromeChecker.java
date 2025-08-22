import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        if (text == null) {
            return false;
        }
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0;
        int end = cleanText.length() - 1;

        while (start < end) {
            if (cleanText.charAt(start) != cleanText.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text == null) {
            return false;
        }
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isPalindromeRecursiveHelper(cleanText, 0, cleanText.length() - 1);
    }

    private static boolean isPalindromeRecursiveHelper(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursiveHelper(text, start + 1, end - 1);
    }

    public static char[] reverseString(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        char[] reversed = new char[length];
        for (int i = 0; i < length; i++) {
            reversed[i] = str.charAt(length - 1 - i);
        }
        return reversed;
    }

    public static boolean isPalindromeCharArray(String text) {
        if (text == null) {
            return false;
        }
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] originalChars = cleanText.toCharArray();
        char[] reversedChars = reverseString(cleanText);

        if (reversedChars == null)
            return true;

        if (originalChars.length != reversedChars.length) {
            return false;
        }

        for (int i = 0; i < originalChars.length; i++) {
            if (originalChars[i] != reversedChars[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String inputString = scanner.nextLine();
        scanner.close();

        boolean isPalindrome1 = isPalindromeIterative(inputString);
        System.out.println("Is palindrome (Iterative): " + isPalindrome1);

        boolean isPalindrome2 = isPalindromeRecursive(inputString);
        System.out.println("Is palindrome (Recursive): " + isPalindrome2);

        boolean isPalindrome3 = isPalindromeCharArray(inputString);
        System.out.println("Is palindrome (Character Array): " + isPalindrome3);
    }
}

