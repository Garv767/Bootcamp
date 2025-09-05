import java.util.UUID;

public class Room {
    private String roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;
    private int maxOccupancy;

    public Room(String roomNumber, String roomType, double pricePerNight, int maxOccupancy) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.maxOccupancy = maxOccupancy;
        this.isAvailable = true; // All rooms are available initially
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // Getters
    public String getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isAvailable() { return isAvailable; }
    public int getMaxOccupancy() { return maxOccupancy; }

    public void displayInfo() {
        System.out.printf("  %-10s | %-15s | $%-12.2f | %-12s | %-10s%n",
            roomNumber, roomType, pricePerNight, maxOccupancy, isAvailable ? "Yes" : "No");
    }
}

