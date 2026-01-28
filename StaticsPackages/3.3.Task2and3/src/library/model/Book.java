package library.model;

public class Book {
    private final String isbn;
    private final String book_title;
    private final String author;
    protected boolean reserved;

    public Book(String book_title, String author) {
        this.isbn = getRandomSequence();
        this.book_title = book_title;
        this.author = author;
    }

    public boolean isReserved() {
        return reserved;
    }


    public boolean setReserved(boolean tof) {
        return reserved == tof;
    }



    public String getIsbn() {
        return isbn;
    }

    public String getBook_title() {
        return book_title;
    }

    public String getAuthor() {
        return author;
    }

    protected static String getRandomSequence() {
        int[] sequence = new int[10];
        String format = "";

        for (int i = 0; i < sequence.length; i++) {
            int randomNum = (int) (Math.random() * 9);
            sequence[i] = randomNum;
            format += Integer.toString(sequence[i]);
        }

        return format;
    }

}