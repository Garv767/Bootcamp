import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Booking {
    private String bookingId;
    private Guest guest;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalAmount;

    private static int bookingIdCounter = 1;

    public Booking(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.bookingId = "B" + String.format("%04d", bookingIdCounter++);
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = calculateTotalAmount();
    }

    private double calculateTotalAmount() {
        long days = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        return days * room.getPricePerNight();
    }

    public void displayBookingInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("----------------------------------------");
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Guest: " + guest.getGuestName() + " (" + guest.getGuestId() + ")");
        System.out.println("Room: " + room.getRoomNumber() + " (" + room.getRoomType() + ")");
        System.out.println("Check-in: " + checkInDate.format(formatter));
        System.out.println("Check-out: " + checkOutDate.format(formatter));
        System.out.printf("Total Amount: $%.2f%n", totalAmount);
        System.out.println("----------------------------------------");
    }

    public String getBookingId() { return bookingId; }
    public Guest getGuest() { return guest; }
    public Room getRoom() { return room; }
}
