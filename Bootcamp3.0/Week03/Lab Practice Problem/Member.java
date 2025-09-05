import java.util.Arrays;

public class Member {
    // c. Private instance variables
    private String memberId;
    private String memberName;
    private String[] booksIssued;
    private int bookCount;

    // e. Static variable for ID generation
    private static int memberIdCounter = 1;

    // Constructor
    public Member(String memberName) {
        this.memberId = generateMemberId();
        this.memberName = memberName;
        this.booksIssued = new String[10]; // Assuming max 10 books per member
        this.bookCount = 0;
    }

    // e. Static method to generate unique IDs
    private static String generateMemberId() {
        return "M" + String.format("%03d", memberIdCounter++);
    }

    // d. Method to borrow a book
    public void borrowBook(Book book) {
        if (bookCount < booksIssued.length) {
            if (book.issueBook()) {
                booksIssued[bookCount] = book.getBookId();
                bookCount++;
                System.out.println(memberName + " successfully borrowed book '" + book.title + "'.");
            } else {
                System.out.println("Book '" + book.title + "' is currently not available.");
            }
        } else {
            System.out.println(memberName + " has reached the maximum borrowing limit.");
        }
    }

    // d. Method to return a book
    public void returnBook(String bookId, Book[] allBooks) {
        int bookIndex = -1;
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i].equals(bookId)) {
                bookIndex = i;
                break;
            }
        }

        if (bookIndex != -1) {
            for (Book book : allBooks) {
                if (book.getBookId().equals(bookId)) {
                    book.returnBook();
                    System.out.println(memberName + " successfully returned book '" + book.title + "'.");

                    // Remove book ID from the member's list
                    for (int i = bookIndex; i < bookCount - 1; i++) {
                        booksIssued[i] = booksIssued[i+1];
                    }
                    booksIssued[bookCount - 1] = null;
                    bookCount--;
                    return;
                }
            }
        }
        System.out.println(memberName + " did not borrow a book with ID: " + bookId);
    }

    public void displayMemberInfo() {
        System.out.println("----------------------------------------");
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + memberName);
        System.out.println("Books Issued: " + bookCount);
        if (bookCount > 0) {
            System.out.println("Issued Book IDs: " + Arrays.toString(Arrays.copyOf(booksIssued, bookCount)));
        }
        System.out.println("----------------------------------------");
    }
}
