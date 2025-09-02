// Packages
package dk.school.library;

// Imports
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    // Attributes

    // _________________________________________________________

    @Test
    void cantBeAddedTwice() {
        Library lib = new Library();
        Book b1 = new Book("T1", "A", "123");
        Book b2 = new Book("T2", "A", "123");
        lib.addBook(b1);
        lib.addBook(b2);
        assertEquals(1, lib.getAllBooks().size(),
                "Samme ISBN må ikke tilføjes to gange");
    }

    // _________________________________________________________

    @Test
    void notCaseSensitive() {
        Library lib = new Library();
        Book b = new Book("The Hobbit", "Tolkien", "123");
        lib.addBook(b);

        assertEquals(b, lib.findByTitle("the hobbit"));
        assertEquals(b, lib.findByTitle("THE HOBBIT"));
    }

    // _________________________________________________________

    @Test
    void loanBookDependingOnStatus() {
        Library lib = new Library();
        Book b = new Book("T1", "A", "123");
        lib.addBook(b);
        User u = new User("Diddy");

        boolean ok = lib.loanBook("123", u);

        assertTrue(ok);
        assertTrue(b.isLoaned());
        assertTrue(u.hasBook(b));
    }

    // _________________________________________________________

    @Test
    void checkForThreeLoansMax() {
        Library lib = new Library();
        Book b = new Book("T1", "A", "123");
        lib.addBook(b);
        User u = new User("Diddy");
        u.borrowBook(new Book("B1", "A", "1"));
        u.borrowBook(new Book("B2", "A", "2"));
        u.borrowBook(new Book("B3", "A", "3"));

        boolean ok = lib.loanBook("123", u);

        assertFalse(ok, "Bruger med 3 lån må ikke få en 4.");
        assertFalse(b.isLoaned(), "Bogen skal forblive ledig");
    }

    // _________________________________________________________

    @Test
    void returnBook() {
        Library lib = new Library();
        Book b = new Book("T1", "A", "123");
        lib.addBook(b);
        User u = new User("Diddy");
        lib.loanBook("123", u);

        lib.returnBook(b, u);

        assertFalse(b.isLoaned());
        assertFalse(u.hasBook(b));
    }

    // _________________________________________________________

    @Test
    void onlyShowAvailableBooks() {
        Library lib = new Library();
        Book b1 = new Book("T1", "A", "1");
        Book b2 = new Book("T2", "A", "2");
        lib.addBook(b1);
        lib.addBook(b2);
        User u = new User("Diddy");
        lib.loanBook("1", u);

        List<Book> available = lib.availableBooks();

        assertEquals(1, available.size());
        assertEquals(b2, available.get(0));
    }

    // _________________________________________________________

    @Test
    void queryCaseSensitivity() {
        Library lib = new Library();
        Book b1 = new Book("The Hobbit", "J.R.R. Tolkien", "1");
        Book b2 = new Book("1984", "George Orwell", "2");
        lib.addBook(b1);
        lib.addBook(b2);

        List<Book> result1 = lib.search("hob");
        List<Book> result2 = lib.search("orwell");

        assertTrue(result1.contains(b1));
        assertTrue(result2.contains(b2));
    }

} // LibraryTest End