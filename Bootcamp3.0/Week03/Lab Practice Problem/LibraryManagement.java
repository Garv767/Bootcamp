public class LibraryManagement {
    public static void main(String[] args) {
        // f. Create arrays of Book and Member objects
        Book[] books = {
            new Book("The Lord of the Rings", "J.R.R. Tolkien"),
            new Book("The Hobbit", "J.R.R. Tolkien"),
            new Book("Pride and Prejudice", "Jane Austen")
        };

        Member[] members = {
            new Member("John Doe"),
            new Member("Jane Smith")
        };

        System.out.println("--- Initial Library State ---");
        System.out.println("Total books in library: " + Book.getTotalBooks());
        System.out.println("Available books in library: " + Book.availableBooks);
        System.out.println();

        // Display initial book information
        for (Book book : books) {
            book.displayBookInfo();
        }
        System.out.println();

        // f. Demonstrate borrowing books
        System.out.println("--- Demonstrating Borrowing ---");
        members[0].borrowBook(books[0]); // John borrows "The Lord of the Rings"
        members[1].borrowBook(books[0]); // Jane tries to borrow the same book
        members[1].borrowBook(books[2]); // Jane borrows "Pride and Prejudice"
        System.out.println();

        System.out.println("--- After Borrowing ---");
        System.out.println("Available books in library: " + Book.availableBooks);
        members[0].displayMemberInfo();
        members[1].displayMemberInfo();
        books[0].displayBookInfo();
        books[2].displayBookInfo();
        System.out.println();

        // f. Demonstrate returning books
        System.out.println("--- Demonstrating Returning ---");
        members[0].returnBook(books[0].getBookId(), books);
        System.out.println();

        System.out.println("--- After Returning ---");
        System.out.println("Available books in library: " + Book.availableBooks);
        members[0].displayMemberInfo();
        books[0].displayBookInfo();
    }
}
