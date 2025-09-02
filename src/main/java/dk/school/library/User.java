// Packages
package dk.school.library;

// Imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    // Attributes
    private final String name;
    private final List<Book> borrowedBooks = new ArrayList<>();

    // _________________________________________________________

    public User(String name) {
        this.name = name;
    }

    // _________________________________________________________

    public String getName() {
        return name;
    }

    // _________________________________________________________

    public boolean borrowBook(Book b) {
        if (borrowedBooks.size() < 3) {
            borrowedBooks.add(b);
            return true;
        }
        return false;
    }

    // _________________________________________________________

    public boolean hasBook(Book b) {
        return borrowedBooks.contains(b);
    }

    // _________________________________________________________

    public boolean returnBook(Book b) {
        return borrowedBooks.remove(b);
    }

    // _________________________________________________________

    public List<Book> getBorrowedBooks() {
        return Collections.unmodifiableList(borrowedBooks);
    }

    // _________________________________________________________

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + "'" +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }

} // User Class End