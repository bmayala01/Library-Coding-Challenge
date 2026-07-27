import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

public class LibraryTest {

    @Test
    public void testNormalCheckout() {
        // Req. 1
        Book book = new Book("Hunger Games", " Suzanne Collins", "123-4567890", 5);
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



}