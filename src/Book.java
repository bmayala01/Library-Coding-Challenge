public class Book {
    private String title;
    private  String author;
    private  String isbn;
    private int copiesOwned;


    // Constructor (Initializes the object)
    public Book(String title, String author, String isbn, int copiesOwned) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.copiesOwned = copiesOwned;
    }

    // Getter allows reading the title, but not changing it
    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }


    public String getISBN() {
        return this.isbn;
    }

    public int getCopiesOwned() {
        return this.copiesOwned;
    }


    @Override
    public String toString() {
        return "Book\n" +
               "Title: " + title + "\n" +
               "Author: " + author + "\n" +
               "ISBN: " + isbn + "\n" +
               "There are " + copiesOwned + " left.";
    }
    

    public boolean isAvailable() {
        if (copiesOwned > 0) {
            return true;
        }

        return false;
    }

 

}
