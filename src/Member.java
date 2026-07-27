import java.util.ArrayList;
import java.util.List;

/*
 * Tracks member in a library
 * Takes the Book object to track what books that member has checked out
 */
public class Member {
    private String name;
    private String memberID;
    private final List<Book> checkedOutBooks;   // dynamic list to hold a members books

    // Constructor (Initializes the object)
    public Member(String name, String memberID) {
        this.name = name;
        this.memberID = memberID;
        this.checkedOutBooks = new ArrayList<>();   // Creates an empty list of checked out books
    }

    // Getter allows reading the name, but not changing it
    public String getName() {
        return this.name;
    }

    public String getMemberID() {
        return this.memberID;
    }

    /*
     * A member can check a book out if the book is available
     * The member cant have more than 3 books checked out (in the list)
     */
    public boolean checkOut(Book book) {
        if (book.isAvailable() && checkedOutBooks.size() < 3) {
            checkedOutBooks.add(book);      // Adds a book to the list

            book.checkOut();                // Syncs books checkout with members

            System.out.println(book);
            return true;
        }

        return false;
    }

    /*
     * if the member has the book checked out (is in the list)
     * removes book from the list
     */
    public boolean returnBook(Book book) {
        if (checkedOutBooks.contains(book)) {
            checkedOutBooks.remove(book);

            book.returnBook();   // Syncs books return with members

            return true;
        }

        return false;
    }

    /**
     * Returns the list of books currently checked out by this member.
     * If the list is empty, it prints a message instead.
     */
    public List<Book> getCheckedOutBooks() {
        if (checkedOutBooks.isEmpty()) {
            System.out.println(
                "Name: " + name + "\n" +
                "ID: " + memberID + "\n" +
                "has no books checked out."
            );
        }
        return checkedOutBooks;
    }


}
