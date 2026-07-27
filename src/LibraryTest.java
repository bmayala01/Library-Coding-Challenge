import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

public class LibraryTest {

    /*
     * Perfroms a normal checkout where a member can freely checkout a book
     * Member does not exceed 3 books checked out
     * There is at least 1 book able to be checked out
    */
    @Test
    public void testNormalCheckout() {
        // Req. 1
        Book book = new Book("Hunger Games", "Suzanne Collins", "123-4567890", 5);
        // Reeq. 2
        final Random rand = new Random();
        Member member = new Member("Brendan Ayala", "M" + String.valueOf(rand.nextInt(1000) + 1));

        // Performing the checkout
        boolean success = member.checkOut(book);

        // AssertTrue: Verify the result is true
        assertTrue(success, "Checkout should return true when successful.");
        // assertEquals(expected, actual)
        assertEquals(book.getTotalCopies() - 1, book.getAvailableCopies(), "Available copies should decrease by 1.");
        assertEquals(1, member.getCheckedOutBooks().size(), "Member should have exactly 1 book in their list.");
    }


    /*
     * Performs a checkout where the member checks out no more than 3 books
     * Safe as there is at least 1 book able to be checked out
    */
    @Test
    public void testCheckoutLimit() {
        // Req. 1
        Book book = new Book("Hunger Games", "Suzanne Collins", "123-4567890", 5);
        Book book2 = new Book("Catching Fire", "Suzanne Collins", "234-5678901", 7);
        Book book3 = new Book("Mockingjay", "Suzanne Collins", "345-6789012", 1);
        Book book4 = new Book("The Ballad of Songbirds and Snakes", " Suzanne Collins", "678-9012345", 10);

        // Reeq. 2
        final Random rand = new Random();
        Member member = new Member("Brendan Ayala", "M" + String.valueOf(rand.nextInt(1000) + 1));

        // Checks out the limit of 3
        member.checkOut(book3);
        member.checkOut(book4);
        member.checkOut(book);

        // Performing a 4th checkout
        boolean success = member.checkOut(book4);

        // AssertFalse: Verify the result is false
        assertFalse(success, "Checkout should return false (exceeding 3 book limit per member).");
        // assertEquals(expected, actual)
        assertEquals(3, member.getCheckedOutBooks().size(), "Max checked out books should be 3");
        //assertEquals(book4.getTotalCopies(), book4.getAvailableCopies(), "Available copies for the 4th should still equal the total copies.");    // checking out book2 before book4
        assertEquals(book4.getTotalCopies() - 1, book4.getAvailableCopies(), "Available copies for the 4th should equal 1 taken away from the total.");     // checking out book4 before book4 again
    }


    /*
     * Tries to perform a checkout on a book where 0 are available
     */
    @Test
    public void testCheckoutNoneAvailable() {
        // Req. 1
        Book unavailableBook = new Book("The Ballad of Songbirds and Snakes", "Suzanne Collins", "678-9012345", 0);

        // Reeq. 2
        final Random rand = new Random();
        Member member = new Member("Brendan Ayala", "M" + String.valueOf(rand.nextInt(1000) + 1));

        // attempting unavailable checkout
        boolean success = member.checkOut(unavailableBook);

        // AssertFalse: Verify the result is false
        assertFalse(success, "Checkout should return false (No copies available).");
        // assertEquals(expected, actual)
        assertEquals(0, member.getCheckedOutBooks().size(), "Max checked out books should be 0");
        assertEquals(unavailableBook.getTotalCopies(), unavailableBook.getAvailableCopies(), "Available copies should still equal the total copies (0).");
    }


    /*
     * testing a checkout with multiple members where one checks out the max of 3
     * The other member checks out 1 or 2.
     * It will be decided who tries to checkout the book with 0 available.
     */
    @Test
    public void testMultipleEdges() {
        // Req. 1
        Book book = new Book("Hunger Games", "Suzanne Collins", "123-4567890", 5);
        Book book2 = new Book("Catching Fire", "Suzanne Collins", "234-5678901", 7);
        Book book3 = new Book("Mockingjay", "Suzanne Collins", "345-6789012", 1);
        Book book4 = new Book("The Ballad of Songbirds and Snakes", " Suzanne Collins", "678-9012345", 0);
        Book book5 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "123-4567890", 100);
        Book book6 = new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", "234-5678901", 25);
        Book book7 = new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "123-4567890", 13);

        Member member = new Member("Brendan Ayala", "M100");
        Member member2 = new Member("Bill Madsen", "M101");

         // Checks out the limit of 3
        member.checkOut(book3);     // available now 0, member count: 1
        boolean successOn0 = member.checkOut(book4);     // cant checkout, already 0

        member2.checkOut(book);     // memeber2 count: 1
        boolean successNowUnavailable = member2.checkOut(book3);    // Cant checkout, because now its 0

        member.checkOut(book7);     // member count: 2
        member2.checkOut(book7);    // member2 count: 2
        member2.returnBook(book);   // >> member2 count: 1 
        member.checkOut(book2);     // member count: 3
        boolean successOnLimit = member.checkOut(book6);     // >> memebr count: 3, denied - was exceeding 3


        // AssertFalse: Verify the result is false
        assertFalse(successOn0, "Checkout should return false (No copies available).");
        assertFalse(successNowUnavailable, "Checkout should return false (Took the last one).");
        assertFalse(successOnLimit, "Checkout should return false (exceeding 3 book limit per member).");
        // assertEquals(expected, actual)
        assertEquals(3, member.getCheckedOutBooks().size(), "Member should have 3 books");
        assertEquals(1, member2.getCheckedOutBooks().size(), "Member2 should have 1 book");
        assertEquals(book.getTotalCopies(), book.getAvailableCopies(), "Available copies for the first should still equal the total copies because it was returned.");
        assertEquals(book4.getTotalCopies(), book4.getAvailableCopies(), "Available copies for the first should still equal the total (0).");
        assertEquals(book3.getTotalCopies() - 1, book3.getAvailableCopies(), "Available copies for the 3rd should equal 1 taken away from the total.");
    }

}