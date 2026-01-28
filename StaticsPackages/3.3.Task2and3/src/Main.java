import library.model.*;
import library.system.*;

public class Main {
    public static void main(String[] args) {

        // Create library
        Library library = new Library();

        // Create books
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("Animal Farm", "George Orwell");
        Book book3 = new Book("Brave New World", "Aldous Huxley");

        // Add books to library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Create members
        LibraryMember alice = new LibraryMember("Alice");
        LibraryMember bob = new LibraryMember("Bob");

        // Add members to library
        library.addMember(alice);
        library.addMember(bob);

        // Borrow operations
        library.borrowBook(alice, book1);
        library.borrowBook(bob, book2);

        // Check borrowed books
        System.out.println("\nAlice borrowed:");
        System.out.println(alice.getBorrowed_books());

        System.out.println("\nBob borrowed:");
        System.out.println(bob.getBorrowed_books());

        // Return operations
        library.returnBook(alice, book1);

        // Final state
        System.out.println("\nAlice borrowed after return:");
        System.out.println(alice.getBorrowed_books());

        // Final state
        System.out.println("\nBob borrowed after return:");
        System.out.println(alice.getBorrowed_books());
    }
}
