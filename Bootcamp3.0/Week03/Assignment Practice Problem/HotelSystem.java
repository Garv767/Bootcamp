import java.time.LocalDate;
import java.util.Scanner;
import java.util.Arrays;

public class HotelSystem {

    // Arrays to simulate a simple database
    private static Room[] allRooms;
    private static Guest[] allGuests;
    private static Booking[] allBookings;

    // Counters for arrays
    private static int guestCount = 0;
    private static int bookingCount = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize hotel name
        Booking.setHotelName("Grand Hyatt");

        // Set up the available rooms in the hotel
        initializeRooms();
        
        // Initialize arrays for guests and bookings
        allGuests = new Guest;
        allBookings = new Booking;

        // Main application loop
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    makeReservation();
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 3:
                    checkAvailability();
                    break;
                case 4:
                    Booking.displayCompanyStats(allRooms, allBookings);
                    break;
                case 5:
                    displayAllRooms();
                    break;
                case 6:
                    displayAllGuests();
                    break;
                case 7:
                    displayAllBookings();
                    break;
                case 0:
                    System.out.println("Thank you for using " + Booking.getHotelName() + " reservation system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void initializeRooms() {
        allRooms = new Room;
        allRooms = new Room("101", "Single", 100.0, 1);
        allRooms = new Room("102", "Single", 100.0, 1);
        allRooms = new Room("103", "Double", 150.0, 2);
        allRooms = new Room("104", "Double", 150.0, 2);
        allRooms = new Room("105", "Suite", 300.0, 4);
        allRooms = new Room("201", "Single", 110.0, 1);
        allRooms = new Room("202", "Double", 160.0, 2);
        allRooms = new Room("203", "Suite", 320.0, 4);
    }

    private static void displayMenu() {
        System.out.println("\n--- " + Booking.getHotelName() + " Reservation System ---");
        System.out.println("1. Make a Reservation");
        System.out.println("2. Cancel a Reservation");
        System.out.println("3. Check Room Availability");
        System.out.println("4. Display Hotel Statistics");
        System.out.println("5. Display All Rooms");
        System.out.println("6. Display All Guests");
        System.out.println("7. Display All Bookings");
        System.out.println("0. Exit");
    }
    
    private static void makeReservation() {
        System.out.println("\n--- Make a Reservation ---");
        
        System.out.print("Enter Guest Name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter Guest Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Guest Email: ");
        String email = scanner.nextLine();
        
        Guest newGuest = findOrCreateGuest(guestName, phoneNumber, email);
        
        System.out.print("Enter Room Type (Single, Double, Suite): ");
        String roomType = scanner.nextLine();
        System.out.print("Enter Check-in Date (YYYY-MM-DD): ");
        LocalDate checkInDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter Check-out Date (YYYY-MM-DD): ");
        LocalDate checkOutDate = LocalDate.parse(scanner.nextLine());

        Room availableRoom = findAvailableRoom(roomType);
        
        if (availableRoom != null) {
            Booking newBooking = new Booking(newGuest, availableRoom, checkInDate, checkOutDate);
            addBooking(newBooking);
            
            System.out.println("Reservation successful!");
            newBooking.displayBookingInfo();
        } else {
            System.out.println("Sorry, no " + roomType + " rooms are available at the moment.");
        }
    }

    private static void cancelReservation() {
        System.out.println("\n--- Cancel a Reservation ---");
        System.out.print("Enter Booking ID to cancel: ");
        String bookingId = scanner.nextLine();
        
        Booking bookingToCancel = findBookingById(bookingId);
        
        if (bookingToCancel != null) {
            bookingToCancel.cancelReservation();
        } else {
            System.out.println("Booking with ID " + bookingId + " not found.");
        }
    }
    
    private static void checkAvailability() {
        System.out.println("\n--- Check Room Availability ---");
        System.out.println("Available Room Types:");
        System.out.println("- Single");
        System.out.println("- Double");
        System.out.println("- Suite");
        System.out.print("Enter Room Type to check: ");
        String roomType = scanner.nextLine();
        
        int availableCount = 0;
        for (Room room : allRooms) {
            if (room != null && room.getRoomType().equalsIgnoreCase(roomType) && room.isAvailable()) {
                availableCount++;
            }
        }
        
        System.out.println("There are " + availableCount + " " + roomType + " rooms available.");
    }
    
    private static Guest findOrCreateGuest(String name, String phone, String email) {
        // Simple search logic to avoid duplicate guests
        for (Guest guest : allGuests) {
            if (guest != null && guest.getEmail().equalsIgnoreCase(email)) {
                return guest;
            }
        }
        
        // If guest not found, create a new one
        Guest newGuest = new Guest(name, phone, email);
        if (guestCount < allGuests.length) {
            allGuests[guestCount++] = newGuest;
        } else {
            // In a real system, you'd handle array resizing
            System.out.println("Guest array is full. Could not add new guest.");
        }
        return newGuest;
    }
    
    private static Room findAvailableRoom(String roomType) {
        for (Room room : allRooms) {
            if (room != null && room.getRoomType().equalsIgnoreCase(roomType) && room.isAvailable()) {
                return room;
            }
        }
        return null;
    }
    
    private static void addBooking(Booking newBooking) {
        if (bookingCount < allBookings.length) {
            allBookings[bookingCount++] = newBooking;
        } else {
            // Array resizing in a real application
            System.out.println("Booking array is full. Could not add new booking.");
        }
    }
    
    private static Booking findBookingById(String bookingId) {
        for (Booking booking : allBookings) {
            if (booking != null && booking.getBookingId().equals(bookingId)) {
                return booking;
            }
        }
        return null;
    }
    
    private static void displayAllRooms() {
        System.out.println("\n--- All Rooms ---");
        for (Room room : allRooms) {
            if (room != null) {
                room.displayRoomInfo();
            }
        }
    }

    private static void displayAllGuests() {
        System.out.println("\n--- All Guests ---");
        for (Guest guest : allGuests) {
            if (guest != null) {
                guest.displayGuestInfo();
            }
        }
    }
    
    private static void displayAllBookings() {
        System.out.println("\n--- All Bookings ---");
        for (Booking booking : allBookings) {
            if (booking != null) {
                booking.displayBookingInfo();
            }
        }
    }
}
