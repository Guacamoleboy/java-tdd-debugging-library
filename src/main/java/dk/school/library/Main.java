// Package
package dk.school.library;

public class Main {

    // Attributes (static)
    private static Library lib = new Library();
    private static User drake = new User("Drake");
    private static User diddy = new User("Diddy");

    // Books
    private static Book cleanCode = new Book("Clean Code", "Robert C. Martin", "9780132350884");
    private static Book effectiveJava = new Book("Effective Java", "Joshua Bloch", "9780134685991");
    private static Book javaConcurrency = new Book("Java Concurrency in Practice", "Brian Goetz", "9780321349606");
    private static Book designPatterns = new Book("Design Patterns", "Gamma et al.", "9780201633610");

    public static void main(String[] args) {

        // Add books to our library
        lib.addBook(cleanCode);
        lib.addBook(effectiveJava);
        lib.addBook(new Book("clean code", "Robert C. Martin", "9780132350884")); // Test
        lib.addBook(javaConcurrency);
        lib.addBook(designPatterns);

        // Loan Test
        boolean loaned = lib.loanBook("9780132350884", drake);
        System.out.println("Loaned Clean Code to Drake? " + loaned);

        // Books Available
        System.out.println("Available books now: " + lib.availableBooks());

        // Return a book
        lib.returnBook(cleanCode, drake);
        System.out.println("After return, available books: " + lib.availableBooks());

        // Loan 3 books to Diddy (ong)
        lib.loanBook("9780132350884", diddy);
        lib.loanBook("9780134685991", diddy);
        lib.loanBook("9780321349606", diddy);

        // Test with 4th book to Diddy
        boolean fourthLoan = lib.loanBook("9780201633610", diddy);
        System.out.println("Diddy loaned 4th book? " + fourthLoan); // false

        // All Available books after running tests (Debug to see if it works as intended)
        System.out.println("Final available books: " + lib.availableBooks());
    }

} // Main Class End