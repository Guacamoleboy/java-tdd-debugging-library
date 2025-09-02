// Packages
package dk.school.library;

// Imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    // Attributes

    // BUG: eksponerer intern tilstand via getter (returnerer direkte liste)
    private final String name;
    private final List<Book> borrowedBooks = new ArrayList<>();

    // ____________________________________________________

    public User(String name) {
        this.name = name;
    }

    // ____________________________________________________

    public String getName() {
        return name;
    }

    // ____________________________________________________

    // BUG: tillader 4 bøger
    public boolean borrowBook(Book b) {
        if (borrowedBooks.size() <= 3) {
            borrowedBooks.add(b);
            return true;
        }
        return false;
    }

    // ____________________________________________________

    public boolean hasBook(Book b) {
        return borrowedBooks.contains(b);
    }

    // ____________________________________________________

    // BUG: fjerner via en ny instans (afhænger af equals-implementering)
    public boolean returnBook(Book b) {
        Book tmp = new Book(b.getTitle(), b.getAuthor(), b.getIsbn());
        return borrowedBooks.remove(tmp);
    }

    // ____________________________________________________

    // BUG: eksponerer ændringsbar liste (burde returnere en kopi eller unmodifiable)
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // ____________________________________________________

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + "'" +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }

} // Class End
