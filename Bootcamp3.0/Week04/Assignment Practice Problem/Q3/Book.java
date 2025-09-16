public class Book {
    String title;
    String author;
    String isbn;
    boolean isAvailable;

    // Default constructor → empty book.
    public Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.isbn = "N/A";
        this.isAvailable = true; // Default to available
    }

    // Constructor with title and author.
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isbn = "N/A"; // Default ISBN
        this.isAvailable = true; // Default to available
    }

    // Constructor with all details.
    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    // borrowBook() → sets available = false.
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book '" + title + "' by " + author + " has been borrowed.");
        } else {
            System.out.println("Book '" + title + "' is currently not available.");
        }
    }

    // returnBook() → sets available = true.
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book '" + title + "' by " + author + " has been returned.");
        } else {
            System.out.println("Book '" + title + "' is already available.");
        }
    }

    // displayBookInfo().
    public void displayBookInfo() {
        System.out.println("--- Book Details ---");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Borrowed"));
        System.out.println("--------------------\n");
    }

    public static void main(String[] args) {
        // Create books
        Book book1 = new Book(); // Default constructor
        Book book2 = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams"); // Constructor with title and author
        Book book3 = new Book("1984", "George Orwell", "978-0451524935", true); // Constructor with all details
        Book book4 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084", false); // Book initially borrowed

        // Display initial book info
        System.out.println("--- Initial Book States ---");
        book1.displayBookInfo();
        book2.displayBookInfo();
        book3.displayBookInfo();
        book4.displayBookInfo();

        // Perform operations
        System.out.println("--- Library Operations ---");

        // Borrow book2
        book2.borrowBook();
        book2.displayBookInfo();

        // Try to borrow book2 again
        book2.borrowBook();
        book2.displayBookInfo();

        // Return book2
        book2.returnBook();
        book2.displayBookInfo();

        // Try to return book2 again
        book2.returnBook();
        book2.displayBookInfo();

        // Borrow book3
        book3.borrowBook();
        book3.displayBookInfo();

        // Try to borrow book4 (already borrowed)
        book4.borrowBook();
        book4.displayBookInfo();

        // Return book4
        book4.returnBook();
        book4.displayBookInfo();
    }
}
