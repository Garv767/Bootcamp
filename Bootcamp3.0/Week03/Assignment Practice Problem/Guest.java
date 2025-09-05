import java.util.UUID;
import java.util.Arrays;

public class Guest {
    private String guestId;
    private String guestName;
    private String phoneNumber;
    private String email;
    private String[] bookingHistory; // Array to store booking IDs
    private int bookingCount;

    private static int guestIdCounter = 1;

    public Guest(String guestName, String phoneNumber, String email) {
        this.guestId = "G" + String.format("%03d", guestIdCounter++);
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bookingHistory = new String; // Max booking history of 10
        this.bookingCount = 0;
    }

    public void addBooking(String bookingId) {
        if (bookingCount < bookingHistory.length) {
            bookingHistory[bookingCount++] = bookingId;
        } else {
            System.out.println("Booking history full for guest " + guestName);
        }
    }

    public String getGuestId() { return guestId; }
    public String getGuestName() { return guestName; }

    public void displayInfo() {
        System.out.println("Guest ID: " + guestId);
        System.out.println("Name: " + guestName);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Booking History: " + Arrays.toString(Arrays.copyOf(bookingHistory, bookingCount)));
    }
}
