import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String memberID;
    private final List<Book> checkedOutBooks;


    public Member(String name, String memberID) {
        this.name = name;
        this.memberID = memberID;
        this.checkedOutBooks = new ArrayList<>();
    }


    public boolean checkOut(Book book) {
        if (book.isAvailable() && checkedOutBooks.size() < 3) {
            checkedOutBooks.add(book);

            book.checkOut();

            System.out.println(book + " added to collection");
            return true;
        }

        return false;
    }

    public boolean returnBook(Book book) {
        if (checkedOutBooks.contains(book)) {
            checkedOutBooks.remove(book);

            book.returnBook();

            return true;
        }

        return false;
    }


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
