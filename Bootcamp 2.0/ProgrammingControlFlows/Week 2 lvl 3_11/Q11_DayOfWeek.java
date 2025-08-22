public class Q11_DayOfWeek {

    public static void main(String[] args) {

        /* if (args.length != 3) {
            System.out.println("Usage: java DayOfWeek m d y");
            return;
        } */

        try {
            int m = Integer.parseInt(args[0]);
            int d = Integer.parseInt(args[1]);
            int y = Integer.parseInt(args[2]);

            if (!isValidDate(m, d, y)) {
                System.out.println("Invalid date.");
                return;
            }

            int dayOfWeek = calculateDayOfWeek(m, d, y);
            System.out.println(dayOfWeek);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Month, day, and year must be integers.");
        }
    }

    private static boolean isValidDate(int m, int d, int y) {
        if (m < 1 || m > 12 || d < 1) {
            return false;
        }

        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (m == 2 && isLeapYear(y)) {
            return d <= 29;
        } else {
            return d <= daysInMonth[m];
        }
    }

    private static boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    private static int calculateDayOfWeek(int m, int d, int y) {
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        return (d + x + 31 * m0 / 12) % 7;
    }
}
