// Packages
package dk.school.library;

// Imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    // Attributes
    private final List<Book> books = new ArrayList<>();

    // _______________________________________________________

    // Add book
    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }

    // _______________________________________________________

    public Book findByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    // _______________________________________________________

    public boolean loanBook(String isbn, User user) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn) && !b.isLoaned()) {
                if (user.borrowBook(b)) {
                    b.setLoaned(true);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    // _______________________________________________________

    public void returnBook(Book book, User user) {
        if (user.hasBook(book)) {
            book.setLoaned(false);
            user.returnBook(book);
        }
    }

    // _______________________________________________________

    public List<Book> availableBooks() {
        return books.stream()
                .filter(b -> !b.isLoaned())
                .collect(Collectors.toList());
    }

    // _______________________________________________________

    public List<Book> search(String query) {
        String q = query.toLowerCase();
        return books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(q)
                        || b.getAuthor().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    // _______________________________________________________

    public List<Book> getAllBooks() {
        return Collections.unmodifiableList(books);
    }

} // Library Class End