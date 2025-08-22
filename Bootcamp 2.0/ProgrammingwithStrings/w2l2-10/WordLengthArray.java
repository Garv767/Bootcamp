import java.util.Scanner;

public class WordLengthArray {

    public static int findStringLength(String str) {
        if (str == null) {
            throw new NullPointerException("Input string cannot be null.");
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


    public static String[] splitText(String text) {
        if (text == null) {
            return new String[0]; // Return an empty array for null input
        }

        int textLength = findStringLength(text);
        int wordCount = 0;
        boolean inWord = false;

        // Count the number of words
        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) == ' ' || text.charAt(i) == '\t' || text.charAt(i) == '\n' || text.charAt(i) == '\r') {
                inWord = false;
            } else if (!inWord) {
                inWord = true;
                wordCount++;
            }
        }

        // Store the indexes of spaces
        String[] words = new String[wordCount];
        int wordIndex = 0;
        int startIndex = 0;
        inWord = false;

        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) == ' ' || text.charAt(i) == '\t' || text.charAt(i) == '\n' || text.charAt(i) == '\r') {
                if (inWord) {
                    words[wordIndex++] = text.substring(startIndex, i);
                    inWord = false;
                }
                startIndex = i + 1;
            } else if (!inWord) {
                inWord = true;
                startIndex = i;
            }
        }
        // Handle the last word
        if (inWord && wordIndex < wordCount) {
            words[wordIndex] = text.substring(startIndex, textLength);
        }
        return words;
    }


    public static String[][] getWordLengthsArray(String[] words) {
        if (words == null) {
            return new String[0][0]; // Return an empty 2D array for null input
        }

        int wordCount = words.length;
        String[][] wordLengths = new String[wordCount][2]; // 2 columns: word, length

        for (int i = 0; i < wordCount; i++) {
            wordLengths[i][0] = words[i];
            wordLengths[i][1] = String.valueOf(findStringLength(words[i])); // Convert length to String
        }
        return wordLengths;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String inputString = scanner.nextLine();
        scanner.close();

        // Split the text into words
        String[] words = splitText(inputString);

        // Get the 2D array of words and their lengths
        String[][] wordLengthsArray = getWordLengthsArray(words);

        // Display the result in a tabular format
        System.out.println("\nWord\tLength");
        System.out.println("------------------");
        for (String[] row : wordLengthsArray) {
            // Convert the length back to an Integer for display
            int length = Integer.parseInt(row[1]);
            System.out.println(row[0] + "\t" + length);
        }
    }
}

