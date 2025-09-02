// Packages
package dk.school.library;

// Imports
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LibraryTest {

    // Attributes

    // ____________________________________________________

    @Test
    @DisplayName("Whatever 1")
    void addBookShouldBeIdempotentOnIsbn() {
        // TODO: tilføj samme ISBN to gange, forvent kun én bog
        fail("Skriv testen først (TDD) og fjern denne fail.");
    }

    // ____________________________________________________

    @Test
    @DisplayName("Whatever 2")
    void findByTitleShouldBeCaseInsensitiveAndUseEquals() {
        // TODO
        fail("Skriv testen først (TDD) og fjern denne fail.");
    }

    // ____________________________________________________

    @Test
    @DisplayName("Whatever 3")
    void loanAndReturnHappyPath() {
        // TODO: lån bog til bruger med plads; returnér; tjek availableBooks
        fail("Skriv testen først (TDD) og fjern denne fail.");
    }

    // ____________________________________________________

    @Test
    @DisplayName("Whatever 4")
    void loanShouldNotChangeBookStateIfUserCannotBorrow() {
        // TODO: fyld bruger op med 3 bøger; forsøg at låne en 4.; bogen må ikke blive markeret som udlånt
        fail("Skriv testen først (TDD) og fjern denne fail.");
    }

} // LibraryTest End