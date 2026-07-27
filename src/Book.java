/*
 * Tracks a books specific detail.
 * Keeps tracks of a books inventory through its total copies and its available copies.
 */
public class Book {
    private String title;
    private  String author;
    private  String isbn;
    private int totalCopies;        // total copies of the book in the library.
    private int availableCopies;    // available copies after checking out or returning the book


    // Constructor (Initializes the object)
    public Book(String title, String author, String isbn, int totalCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
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

    public int getTotalCopies() {
        return this.totalCopies;
    }

    // there must be at least 1 copy of a book to have any available
    public int getAvailableCopies() {
        if (totalCopies > 0) {
            return this.availableCopies;
        }
        else {
            return 0;
        }
    }


    // Overrides the default object toString() for my personal one
    @Override
    public String toString() {
        return "\nBook Info\n" +
               "Title: " + title + "\n" +
               "Author: " + author + "\n" +
               "ISBN: " + isbn + "\n" +
               "Total: " + totalCopies + "\n" +
               "Available: " + availableCopies + " left";
    }
    

    // True if there are avaiable copies
    public boolean isAvailable() {
        return availableCopies > 0;
    }

    /*
     * checks if a book is available
     * decrements available copies upon checking out
     */
    public void checkOut() {
        if (isAvailable()) {
            availableCopies--;
        }
    }

    /*
     * available copies can equal total copies but not exceed it
     * Only increment if its 1 or more less than total copies
     */
    public void returnBook() {
        if (availableCopies < totalCopies) {
            availableCopies++;
        }
    }

 

}
