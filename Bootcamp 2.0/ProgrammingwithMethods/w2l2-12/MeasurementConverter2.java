public class MeasurementConverter2 {

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }

    public static void main(String[] args) {
        // Example usage
        double fahrenheit = 68;
        double celsius = convertFahrenheitToCelsius(fahrenheit);
        System.out.println(fahrenheit + " Fahrenheit = " + celsius + " Celsius");

        double celsiusInput = 20;
        double fahrenheitOutput = convertCelsiusToFahrenheit(celsiusInput);
        System.out.println(celsiusInput + " Celsius = " + fahrenheitOutput + " Fahrenheit");

        double pounds = 150;
        double kilograms = convertPoundsToKilograms(pounds);
        System.out.println(pounds + " pounds = " + kilograms + " kilograms");

        double kilogramsInput = 70;
        double poundsOutput = convertKilogramsToPounds(kilogramsInput);
        System.out.println(kilogramsInput + " kilograms = " + poundsOutput + " pounds");

        double gallons = 10;
        double liters = convertGallonsToLiters(gallons);
        System.out.println(gallons + " gallons = " + liters + " liters");

        double litersInput = 40;
        double gallonsOutput = convertLitersToGallons(litersInput);
        System.out.println(litersInput + " liters = " + gallonsOutput + " gallons");
    }
}