// Package
package dk.school.library;

// Imports
import java.util.Objects;

public class Book {

    // Attributes
    private String title;
    private String author;
    private String isbn;
    private boolean loaned;

    // _________________________________________________________

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.loaned = false;
    }

    // _________________________________________________________

    public String getTitle() {
        return title;
    }

    // _________________________________________________________

    public String getAuthor() {
        return author;
    }

    // _________________________________________________________

    public String getIsbn() {
        return isbn;
    }

    // _________________________________________________________

    public void setLoaned(boolean loaned) {
        this.loaned = loaned;
    }

    // _________________________________________________________

    public boolean isLoaned() {
        return loaned;
    }

    // _________________________________________________________

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book other = (Book) o;
        return Objects.equals(this.isbn, other.isbn);
    }

    // _________________________________________________________

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    // _________________________________________________________

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", loaned=" + loaned +
                '}';
    }

} // Book Class End