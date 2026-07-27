import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
       // System.out.println("Hello, World!!!!");
       // Initialize objects
        Book myBook = new Book("Hunger Games", " Suzanne Collins", "123-4567890", 5);
        final Random rand = new Random();
        Member member = new Member("Alice Smith", "M" + String.valueOf(rand.nextInt(1000) + 1));

        
        System.out.println("\nMember Info");
        System.out.println(member.getName() + " - " + member.getMemberID());
        System.out.println(myBook);

        
        System.out.println("\n" + member.getName() + " checked out " + myBook.getTitle());
        member.checkOut(myBook);
        

        System.out.println("\nLibrary Status");
        System.out.println("Title: " + myBook.getTitle() + ", Author: " + myBook.getAuthor());
        System.out.println("Available to checkout: " + myBook.getAvailableCopies());
        

        System.out.println("\nChecked out books by " + member.getName() + " - " + member.getMemberID() + ":");
        for (Book b : member.getCheckedOutBooks()) {
            System.out.println("• " + b.getTitle());
        }
    }
}
