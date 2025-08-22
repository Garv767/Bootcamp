import java.util.Scanner;

public class AnagramChecker {

    public static boolean areAnagrams(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return false;
        }

        String cleanText1 = text1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String cleanText2 = text2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleanText1.length() != cleanText2.length()) {
            return false;
        }

        int[] charFrequencies1 = new int[256];
        int[] charFrequencies2 = new int[256];

        for (char c : cleanText1.toCharArray()) {
            charFrequencies1[c]++;
        }
        for (char c : cleanText2.toCharArray()) {
            charFrequencies2[c]++;
        }

        for (int i = 0; i < 256; i++) {
            if (charFrequencies1[i] != charFrequencies2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first text: ");
        String text1 = scanner.nextLine();
        System.out.print("Enter the second text: ");
        String text2 = scanner.nextLine();
        scanner.close();

        boolean areAnagrams = areAnagrams(text1, text2);
        System.out.println("Are the two texts anagrams? " + areAnagrams);
    }
}

