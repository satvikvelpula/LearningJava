package library.model;
import java.util.ArrayList;

import static library.model.Book.getRandomSequence;



public class LibraryMember {
    private final String name;
    private final String memberID;
    private final ArrayList<Book> borrowed_books;
    private final ArrayList<Book> reserved_books;

    public LibraryMember(String name) {
        this.name = name;
        this.memberID = getRandomSequence();
        this.borrowed_books = new ArrayList<>();
        this.reserved_books = new ArrayList<>();
    }

    public ArrayList<Book> get_reservation_list() {
        return reserved_books;
    }

    public String getName() {
        return name;
    }

    public String memberID() {
        return memberID;
    }

    public ArrayList<Book> getBorrowed_books() {
        return borrowed_books;
    }
}