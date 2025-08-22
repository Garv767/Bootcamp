import java.util.Arrays;
import java.util.Scanner;

public class StringSplitter {

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
        int[] spaceIndices = new int[wordCount]; // At most, there will be wordCount -1 spaces.  But allocate for wordCount for simplicity
        String[] words = new String[wordCount];
        int wordIndex = 0;
        int startIndex = 0;

        inWord = false; //reset
        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) == ' ' || text.charAt(i) == '\t' || text.charAt(i) == '\n' || text.charAt(i) == '\r') {
                if (inWord) {
                    words[wordIndex++] = text.substring(startIndex, i);
                    inWord = false;
                }
                startIndex = i + 1; //start of next word
            } else if (!inWord) {
                inWord = true;
                startIndex = i;
            }
        }
        //handle the last word.
        if(inWord && wordIndex < wordCount){
            words[wordIndex] = text.substring(startIndex, textLength);
        }
        return words;
    }

 
    public static boolean compareStringArrays(String[] array1, String[] array2) {
        if (array1 == null && array2 == null) {
            return true;
        }
        if (array1 == null || array2 == null) {
            return false;
        }
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
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

        // Split the text using the custom method
        String[] customSplitResult = splitText(inputString);
        System.out.println("Words (using custom split method): " + Arrays.toString(customSplitResult));

        // Split the text using the built-in split() method
        String[] builtInSplitResult = inputString.split("\\s+"); // Split by any whitespace
        System.out.println("Words (using built-in split() method): " + Arrays.toString(builtInSplitResult));

        // Compare the two String arrays
        boolean areEqual = compareStringArrays(customSplitResult, builtInSplitResult);
        System.out.println("Are the two arrays equal? " + areEqual);
    }
}

