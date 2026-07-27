import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
       // System.out.println("Hello, World!!!!");
       // Initialize objects
        // Req. 1
        Book myBook = new Book("Hunger Games", " Suzanne Collins", "123-4567890", 5);
        // Reeq. 2
        final Random rand = new Random();
        Member member = new Member("Alice Smith", "M" + String.valueOf(rand.nextInt(1000) + 1));
        
        System.out.println("\nMember Info");
        System.out.println(member.getName() + " - " + member.getMemberID());
        System.out.println(myBook);

        // Req. 3
        System.out.println("\n" + member.getName() + " checked out " + myBook.getTitle());
        member.checkOut(myBook);

        // Req. 6
        System.out.println("\nLibrary Status");
        System.out.println("Title: " + myBook.getTitle() + ", Author: " + myBook.getAuthor());
        System.out.println("Available to checkout: " + myBook.getAvailableCopies());
        
        // Req. 5
        System.out.println("\nChecked out books by " + member.getName() + " - " + member.getMemberID() + ":");
        for (Book b : member.getCheckedOutBooks()) {
            System.out.println("• " + b.getTitle());
        }

        // Req. 4
        System.out.println("\n" + member.getName() + " returned " + myBook.getTitle());
        member.returnBook(myBook);

        // Req. 6
        System.out.println("Available to checkout after return: " + myBook.getAvailableCopies());

    }
}
