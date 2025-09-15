public class Book {
    String title;
    String author;
    double price;
    
    Book(){ //Default constructor
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    Book(String title, String author, double price){ //Parameterized constructor
        this.title = title;
        this.author = author;
        this.price = price;
    }   

    void display(){ //Display method
        System.out.println("Title of the book is " + title + " by " + author + " at price $"+ price );
    }

    public static void main (String[] args){
        Book b1 = new Book();
        Book b2 = new Book("3 Mistakes of my life", "Durjoy Dutta", 349); //Object initialization

        b1.display();
        b2.display();
    }
}
