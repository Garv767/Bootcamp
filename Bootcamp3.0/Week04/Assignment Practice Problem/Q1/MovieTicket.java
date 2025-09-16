public class MovieTicket {
    String movieName;
    String theatreName;
    int seatNumber;
    double price;

    public MovieTicket(){
        this.movieName = "Unknown";
        this.theatreName = "Unknown";
        this.seatNumber = 0;
        this.price = 0.0;
    }

    public MovieTicket(String movieNamw){
        this.movieName = movieNamw;
        this.theatreName = "Unknown";
        this.seatNumber = 0;
        this.price =200.0;
    }

    public MovieTicket (String movieName, int seatNumber){
        this.movieName = movieName;
        this.theatreName = "PVR";
        this.seatNumber = seatNumber;
        this.price = 250.0;
    }

    public MovieTicket(String movieName, String theatreName, int seatNumber, double price){
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

     public void printTicket() {
        System.out.println(" Movie Ticket ");
        System.out.println("Movie: " + movieName);
        System.out.println("Theatre: " + theatreName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: ₹" + String.format("%.2f", price));
        System.out.println("\n");
    }

    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket();
        ticket1.printTicket();

        MovieTicket ticket2 = new MovieTicket("Inception");
        ticket2.printTicket();

        MovieTicket ticket3 = new MovieTicket("Avatar", 15);
        ticket3.printTicket();

        MovieTicket ticket4 = new MovieTicket("Titanic", "IMAX", 20, 300.0);
        ticket4.printTicket();
    }

}
