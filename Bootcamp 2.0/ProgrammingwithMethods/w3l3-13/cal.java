 import java.util.Scanner;
public class CalendarDisplay {
// Array of month names
static String[] months = {
"", "January", "February", "March", "April", "May", "June",
"July", "August", "September", "October", "November", "December"
};
// Array of days in each month
static int[] daysInMonth = {
0, 31, 28, 31, 30, 31, 30,
31, 31, 30, 31, 30, 31
};
// Check for leap year
public static boolean isLeapYear(int year) {
return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
}
// Get first day of the month using Gregorian calendar algorithm
public static int getFirstDayOfMonth(int month, int year) {
int d = 1; // First day of month
int y0 = year - (14 - month) / 12;
}
int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
int m0 = month + 12 * ((14 - month) / 12) - 2;
int d0 = (d + x + (31 * m0) / 12) % 7;
return d0; // 0=Sunday, 1=Monday, ..., 6=Saturday
// Print the calendar
public static void printCalendar(int month, int year) {
if (month < 1 || month > 12) {
System.out.println("Invalid month.");
return;
}
int days = daysInMonth[month];
// Adjust for leap year if February
if (month == 2 && isLeapYear(year)) {
days = 29;
}
// Print calendar header
System.out.printf("
 %s %d\n", months[month], year);
System.out.println(" Su Mo Tu We Th Fr Sa");
int startDay = getFirstDayOfMonth(month, year);
// Print initial spaces
for (int i = 0; i < startDay; i++) {
System.out.print(" ");
}
// Print days
for (int day = 1; day <= days; day++) {
System.out.printf("%3d", day);
}
}
if ((day + startDay) % 7 == 0 || day == days) {
System.out.println();
}
// Main method
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter month (1-12): ");
int month = scanner.nextInt();
System.out.print("Enter year: ");
int year = scanner.nextInt();
printCalendar(month, year);
}
}