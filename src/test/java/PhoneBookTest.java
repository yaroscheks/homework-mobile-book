import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    private PhoneBook phoneBook;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        phoneBook = new PhoneBook();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAddNewContact() {
        int count = phoneBook.add("A", "1");
        assertEquals(1, count);
    }

    @Test
    public void testAddDuplicateContact() {
        phoneBook.add("A", "1");
        int count = phoneBook.add("A", "2");
        assertEquals(1, count);
    }

    @Test
    public void testAddMultipleContacts() {
        phoneBook.add("A", "1");
        int count = phoneBook.add("B", "2");
        assertEquals(2, count);
    }
}