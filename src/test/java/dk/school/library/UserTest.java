// Packages
package dk.school.library;

// Imports
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    // Attributes

    // _________________________________________________________

    @Test
    void threeBooks() {
        User u = new User("Diddy");
        assertTrue(u.borrowBook(new Book("T1", "A", "1")));
        assertTrue(u.borrowBook(new Book("T2", "A", "2")));
        assertTrue(u.borrowBook(new Book("T3", "A", "3")));
    }

    // _________________________________________________________

    @Test
    void onlyTheeBooksNotFourLol() {
        User u = new User("Drake");
        u.borrowBook(new Book("T1", "A", "1"));
        u.borrowBook(new Book("T2", "A", "2"));
        u.borrowBook(new Book("T3", "A", "3"));
        assertFalse(u.borrowBook(new Book("T4", "A", "4")),
                "Lån nummer 4 skal afvises");
    }

    // _________________________________________________________

    @Test
    void unmodifiableList() {
        User u = new User("Trump");
        Book b = new Book("T1", "A", "1");
        u.borrowBook(b);

        List<Book> books = u.getBorrowedBooks();
        assertThrows(UnsupportedOperationException.class, () -> {
            books.add(new Book("X", "Y", "99"));
        }, "Listen skal være unmodifiable");
    }

    // _________________________________________________________

    @Test
    void returnOnlyIfUserHasIt() {

        User u = new User("Fartmachine1");
        Book b1 = new Book("T1", "A", "1");
        Book b2 = new Book("T2", "A", "2");
        u.borrowBook(b1);

        assertTrue(u.returnBook(b1), "Bruger skal kunne aflevere lånt bog");
        assertFalse(u.returnBook(b2), "Bruger skal ikke kunne aflevere ikke-lånt bog");
    }

} // UserTest End