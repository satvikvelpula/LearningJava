import java.sql.Array;
import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private int publication_year;
    private double rating;
    private String review;
    ArrayList<Double> ratings;
    ArrayList<String> reviews;

    public Book(String title, String author, int publication_year) {
        this.title = title;
        this.author = author;
        this.publication_year = publication_year;
        this.ratings = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }


    public boolean setRating(double book_rating) {
        if (book_rating > 5 || book_rating < 0) {
            System.out.println("Rating is invalid. ");
            return false;
        }
        rating = book_rating;
        ratings.add(rating);
        return true;
    }

    public double getRating() {
        return rating;
    }

    public boolean addReview(String book_review) {
        if (book_review.isEmpty()) {
            return false;
        }
        review = book_review;
        reviews.add(review);
        return true;
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

class User {
    String name;
    int age;
    ArrayList<Book> borrowed_books;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        borrowed_books = new ArrayList<>();
    }

    public void listOfBorrowedBooks() {
        for (Book book : borrowed_books) {
            System.out.println(book.getTitle());
        }
    }
}

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(String title, User user) {
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
            user.borrowed_books.add(finder);
        }
    }

    public void returnBook(Book book) {
        if (books.contains(book)) {
            System.out.println("Book is already in the library. ");
        } else {
            books.add(book);
        }
    }

    public boolean isBookAvailable(String title) {
        boolean isAvailable = false;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                isAvailable = true;
            }
        }

        System.out.println(isAvailable);
        return isAvailable;
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

    public void getAverageBookRating() {
        double total = 0;
        int counter = 0;
        for ( Book book : books) {
            if (book.getRating() > 0) {
                counter++;
                total += book.getRating();
            } else {
                continue;
            }
        }
        total /= counter;
        System.out.println(total);
    }

    public void getMostReviewedBook() {
        int max = 0;
        String max_book = null;
        for (Book book : books) {
            if (book.reviews.isEmpty()) {
                continue;
            }

            if (book.reviews.size() > max) {
                max = book.reviews.size();
                max_book = book.getTitle();
            }
        }
        System.out.println("Book: " + max_book + " Reviews: " + max);
    }

}

class LibraryMain {
    public static void main(String[] args) {
        Book book = new Book("1984", "George Orwell", 1949);
        Book book2 = new Book("Orwell on Truth", "George Orwell", 1953);
        Book book3 = new Book("Animal Farm", "George Orwell", 1945);
        Book book4 = new Book("Brave New World", "Aldous Huxley", 1932);
        Book book5 = new Book("Fahrenheit 451", "Ray Bradbury", 1953);

        book.setRating(4);
        book.setRating(2);
        book2.setRating(3);
        book3.setRating(5);

        book.addReview("A chilling and powerful warning about totalitarianism.");
        book.addReview("Thought-provoking, but a bit slow in the middle.");
        book2.addReview("Insightful essays that really make you think.");
        book3.addReview("Short, sharp, and incredibly effective satire.");
        book3.addReview("A timeless classic with deep political insight.");
        book3.addReview("Thought-provoking, but a bit slow in the middle.");



        Library library = new Library();


        library.addBook(book);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        // library.displayBooks();

        // library.getAverageBookRating();

        library.getMostReviewedBook();

        User carl = new User("Carl", 21);
        library.borrowBook("Brave New World", carl);
        carl.listOfBorrowedBooks();
        library.returnBook(book4);
        library.displayBooks();

    }
}
