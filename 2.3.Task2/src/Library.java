import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private int publication_year;

    public Book(String title, String author, int publication_year) {
        this.title = title;
        this.author = author;
        this.publication_year = publication_year;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublication_year() {
        return publication_year;
    }

}

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(String title) {
        Book finder = null;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                finder = book;
            }
        }

        if (finder == null) {
            System.out.println("No book found, so no book borrowed. ");
        } else {
            books.remove(finder);
        }
    }

    public void returnBook(Book book) {
        if (books.contains(book)) {
            System.out.println("Book is already in the library. ");
        } else {
            books.add(book);
        }
    }


    public void findBooksByAuthor(String author) {
        System.out.println("Books by " + author);
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                System.out.println("Title: " + book.getTitle() + ", Publication Year: " + book.getPublication_year());
            } else {
                continue;
            }
        }
    }

    public void displayBooks() {
        System.out.println("Library Catalog: ");
        int counter = 0;
        for (Book book : books) {
            counter++;
            System.out.println(counter + ". " + "Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Publication Year: " + book.getPublication_year());
        }
    }

}

class LibraryMain {
    public static void main(String[] args) {
        Book book = new Book("1984", "George Orwell", 1949);
        Book book2 = new Book("Orwell on Truth", "George Orwell", 1953);
        Book book3 = new Book("Animal Farm", "George Orwell", 1945);
        Book book4 = new Book("Brave New World", "Aldous Huxley", 1932);
        Book book5 = new Book("Fahrenheit 451", "Ray Bradbury", 1953);


        Library library = new Library();

        library.addBook(book);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.displayBooks();

    }
}
