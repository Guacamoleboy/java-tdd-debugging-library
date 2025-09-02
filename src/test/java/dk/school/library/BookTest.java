// Package
package dk.school.library;

// Imports
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    // Attributes

    // _________________________________________________________

    @Test
    void sameISBN() {
        Book b1 = new Book("Title1", "Author1", "123");
        Book b2 = new Book("Title2", "Author2", "123");
        assertEquals(b1, b2, "Bøger med samme ISBN skal være equal");
    }

    // _________________________________________________________

    @Test
    void differentISBN() {
        Book b1 = new Book("Title1", "Author1", "123");
        Book b2 = new Book("Title1", "Author1", "456");
        assertNotEquals(b1, b2);
    }

    // _________________________________________________________

    @Test
    void hashcodeISBN() {
        Book b1 = new Book("A", "B", "999");
        Book b2 = new Book("C", "D", "999");
        assertEquals(b1.hashCode(), b2.hashCode(),
                "hashCode skal være baseret på ISBN");
    }

    // _________________________________________________________

    @Test
    void loan() {
        Book b = new Book("T", "A", "321");
        assertFalse(b.isLoaned());
        b.setLoaned(true);
        assertTrue(b.isLoaned());
    }

} // BookTest End