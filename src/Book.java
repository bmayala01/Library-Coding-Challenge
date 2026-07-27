public class Book {
    private String title;
    private  String author;
    private  String isbn;
    private int totalCopies;
    private int availableCopies;


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

    public int getAvailableCopies() {
        if (totalCopies > 0) {
            return this.availableCopies;
        }
        else {
            return 0;
        }
    }


    @Override
    public String toString() {
        return "\nBook Info\n" +
               "Title: " + title + "\n" +
               "Author: " + author + "\n" +
               "ISBN: " + isbn + "\n" +
               "Total: " + totalCopies + "\n" +
               "Available: " + availableCopies + " left";
    }
    

    public boolean isAvailable() {
        return availableCopies > 0;
    }

    public void checkOut() {
        if (isAvailable()) {
            availableCopies--;
        }
    }

    public void returnBook() {
        if (availableCopies < totalCopies) {
            availableCopies++;
        }
    }

 

}
