public class UnitConverter {

    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    public static void main(String[] args) {
        // Example usage
        double kilometers = 10;
        double miles = convertKmToMiles(kilometers);
        System.out.println(kilometers + " kilometers = " + miles + " miles");

        double milesInput = 5;
        double kilometersOutput = convertMilesToKm(milesInput);
        System.out.println(milesInput + " miles = " + kilometersOutput + " kilometers");

        double meters = 20;
        double feet = convertMetersToFeet(meters);
        System.out.println(meters + " meters = " + feet + " feet");

        double feetInput = 30;
        double metersOutput = convertFeetToMeters(feetInput);
        System.out.println(feetInput + " feet = " + metersOutput + " meters");
    }
}