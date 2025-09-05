public class Book {
    // a. Private instance variables
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    // a. Static variables
    private static int totalBooks = 0;
    private static int availableBooks = 0;
    private static int bookIdCounter = 1;

    // b. Constructor for Book class
    public Book(String title, String author) {
        this.bookId = generateBookId();
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        totalBooks++;
        availableBooks++;
    }

    // e. Static method to generate unique IDs
    private static String generateBookId() {
        return "B" + String.format("%03d", bookIdCounter++);
    }

    // b. Method to issue the book
    public boolean issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
            return true;
        }
        return false;
    }

    // b. Method to return the book
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
        }
    }

    // b. Method to display book info
    public void displayBookInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Status: " + (isAvailable ? "Available" : "Issued"));
    }

    // Getter for bookId
    public String getBookId() {
        return bookId;
    }

    // e. Static method to get total number of books
    public static int getTotalBooks() {
        return totalBooks;
    }
}
