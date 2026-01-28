package library.system;
import library.model.*;
import java.util.ArrayList;

// Implement methods to add books, add members, borrow books, and return books.
public class Library {

    ArrayList<Book> library_books;
    ArrayList<LibraryMember> library_members;

    public Library() {
        library_books = new ArrayList<>();
        library_members = new ArrayList<>();
    }

    public void addMember(LibraryMember member) {
        library_members.add(member);
    }

    public void addBook(Book book) {
        if (library_books.contains(book)) {
            System.out.println("Book is already in the library. ");
        } else {
            library_books.add(book);
        }
    }

    public void borrowBook(LibraryMember member, Book book) {
        if (!library_books.contains(book)) {
            System.out.println("Book is not in the library to begin with. ");
            return;
        }

        if (!library_members.contains(member)) {
            System.out.println("Could not borrow book, member is not in the library to begin with. ");
            return;
        }

        if (member.getBorrowed_books().contains(book)) {
            System.out.println("Could not borrow book, book is already borrowed. ");
            return;
        }

        library_books.remove(book);
        member.getBorrowed_books().add(book);

        /*

        else {
            if (library_members.contains(member)) {
                if (!member.getBorrowed_books().contains(book)) {
                    library_books.remove(book);
                    member.getBorrowed_books().add(book);
                }
            }
        }


         */
    }

    public void returnBook(LibraryMember member, Book book) {

        if (library_books.contains(book)) {
            System.out.println("Book is already in the library to begin with. ");
            return;
        }

        if (!library_members.contains(member)) {
            System.out.println("Can not return book, member is not in library to begin with .");
            return;
        }

        if (!member.getBorrowed_books().contains(book)) {
            System.out.println("Can not return book, book was never borrowed. ");
            return;
        }

        member.getBorrowed_books().remove(book);
        library_books.add(book);
    }

    public void reserveBook(LibraryMember member, Book book) {

        if (!library_members.contains(member)) {
            System.out.println("Can not reserve book, member not available. ");
            return;
        }

        if (!library_books.contains(book)) {
            System.out.println("Can not reserve book, book not available. ");
            return;
        }

        if (book.isReserved()) {
            System.out.println("Can not reserve book, book is already reserved. ");
            return;
        }


        book.setReserved(true);
        library_books.remove(book);
        member.get_reservation_list().add(book);
    }

    public void cancelReservation(LibraryMember member, Book book) {
        if (!library_members.contains(member)) {
            System.out.println("Can not cancel reservation, member not available. ");
            return;
        }

        if (!book.isReserved()) {
            System.out.println("Book wasn't reserved to begin with. ");
            return;
        }

        book.setReserved(false);
        library_books.add(book);
        member.get_reservation_list().remove(book);
    }

    public void displayReservations(LibraryMember member) {
        if (!library_members.contains(member)) {
            System.out.println("Member isn't available. ");
            return;
        }

        System.out.println(member.get_reservation_list());

    }

}
