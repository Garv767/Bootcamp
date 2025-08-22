public class MeasurementConverter {

    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    public static void main(String[] args) {
        // Example usage
        double yards = 10;
        double feet = convertYardsToFeet(yards);
        System.out.println(yards + " yards = " + feet + " feet");

        double feetInput = 30;
        double yardsOutput = convertFeetToYards(feetInput);
        System.out.println(feetInput + " feet = " + yardsOutput + " yards");

        double meters = 5;
        double inches = convertMetersToInches(meters);
        System.out.println(meters + " meters = " + inches + " inches");

        double inchesInput = 12;
        double metersOutput = convertInchesToMeters(inchesInput);
        System.out.println(inchesInput + " inches = " + metersOutput + " meters");

        double inchesCm = 10;
        double centimeter = convertInchesToCentimeters(inchesCm);
        System.out.println(inchesCm + " inches = " + centimeter + " centimeters");
    }
}