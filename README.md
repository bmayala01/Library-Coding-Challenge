## Getting Started

This Library Coding Challenge was done in VS Code with the "Extension Pack for Java" extension. This extension comes with use of Java as well as the ability to support JUnit testing.

Running the code:
Download VS Code and the "Extension Pack for Java" extension. User should be able to open the project from the base folder "Library Coding Challenge" to include all necessary files. The user should be able to simply press "run".

                                            -- Project Details --
Requirements:
1. A Book has a title, author, ISBN, and total copies owned.
2. A Member has a name and member ID.
3. A member can check out a book if:
    - At least one copy is available, AND
    - The member currently has fewer than 3 books checked out.
4. A member can return a book they have checked out.
5. Provide a method to list all books currently checked out by a given member.
6. Provide a method to list how many copies of a given book are currently available.
7. At least JUnit tests covering normal and edge cases.

## File Structure

The workspace contains 4 files that run the code, where:

App.Java:
Contains the main class to run the function. This initializes instances from the 'Book' object and the 'Member' object. It then runs through a scenario of a member checking out a book and going through reqs. 4-6.

Book:
Contains an object of a book. This includes a title, author, ISBN, total copies of the book, and available copies if it's been checked out or not. Available copies here equal the total copies, the library is fully stocked. It contains getters to grab the properties listed before as there is only a need to read the data (getters) and not write any new data (setters). Functions are implemented to keep track of a books own inventory.

Member:
Contains an object of a Member. This includes their name, member ID, as well as a list of books that member would checkout. The list is a dynamic array as the member has the ability to check out under the conditions of req. 3 and also have the ability to return a book if they like. When a member checks out or returns a book, the book gets added or removed from the array and the inventory of the book is also updated.

Library Test:
Contains JUnit tests to test the code as a whole and the reqs.
  - Edge case 1: A normal checkout where there are plenty of books and a member simply checks out 1 book.
  - Edge case 2: A member tries to check out more than 3 books.
  - Edge case 3: A member tries to check out a book where there are 0 available.
  - Edge case 4: 2 members check out from 7 books with different inventory counts. They check out out of order and
      maybe return 1 or 2 books. Edge cases 2 and 3 are implemented in here to check if logic follows.




## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
