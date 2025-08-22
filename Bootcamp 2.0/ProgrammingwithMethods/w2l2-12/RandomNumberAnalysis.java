public class RandomNumberAnalysis {

    public static int[] generate4DigitRandomArray(int size) {
        int[] randomNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = 1000 + (int) (Math.random() * 9000); // Generates a number between 1000 and 9999
        }
        return randomNumbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return new double[]{0, 0, 0}; // Return default values for empty or null array
        }

        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        for (int number : numbers) {
            sum += number;
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        double average = sum / numbers.length;
        return new double[]{average, min, max};
    }

    public static void main(String[] args) {
        int[] randomValues = generate4DigitRandomArray(5);

        System.out.println("Generated random numbers:");
        for (int value : randomValues) {
            System.out.print(value + " ");
        }
        System.out.println();

        double[] results = findAverageMinMax(randomValues);
        double average = results[0];
        int min = (int) results[1];
        int max = (int) results[2];

        System.out.println("Average: " + average);
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
}