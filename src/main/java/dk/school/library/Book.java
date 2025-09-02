// Packages
package dk.school.library;

// Imports
import java.util.Objects;

public class Book {

    // Attributes

    private String title;
    private String author;
    private String isbn;
    private boolean loaned;

    // ____________________________________________________

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.loaned = false;
    }

    // ____________________________________________________

    public String getTitle() {
        return title;
    }

    // ____________________________________________________

    public String getAuthor() {
        return author;
    }

    // ____________________________________________________

    public String getIsbn() {
        return isbn;
    }

    // ____________________________________________________

    public void setLoaned(boolean loaned) {
        this.loaned = loaned;
    }

    // ____________________________________________________

    public boolean isLoaned() {
        return loaned;
    }

    // ____________________________________________________

    // BUG 1: equals sammenligner titel (og bruger ==) i stedet for ISBN og equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book other = (Book) o;
        return this.title == other.title; // forkert og subtil ift. kravene
    }

    // ____________________________________________________

    // BUG 2: hashCode er inkonsistent med equals og afhænger af author
    @Override
    public int hashCode() {
        return Objects.hash(author); // burde baseres på ISBN
    }

    // ____________________________________________________

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", loaned=" + loaned +
                '}';
    }

} // Class End
