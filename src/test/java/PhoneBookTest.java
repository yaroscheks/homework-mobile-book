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

    @Test
    public void testFindByNumberExists() {
        phoneBook.add("A", "1");
        String name = phoneBook.findByNumber("1");
        assertEquals("A", name);
    }

    @Test
    public void testFindByNumberDoesNotExist() {
        phoneBook.add("A", "1");
        String name = phoneBook.findByNumber("2");
        assertNull(name);
    }

    @Test
    public void testFindByNumberMultipleContacts() {
        phoneBook.add("A", "1");
        phoneBook.add("B", "2");
        String name = phoneBook.findByNumber("2");
        assertEquals("B", name);
    }

    @Test
    public void testFindByNameExists() {
        phoneBook.add("A", "1");
        String number = phoneBook.findByName("A");
        assertEquals("1", number);
    }

    @Test
    public void testFindByNameDoesNotExist() {
        phoneBook.add("A", "1");
        String number = phoneBook.findByName("B");
        assertNull(number);
    }

    @Test
    public void testFindByNameMultipleContacts() {
        phoneBook.add("A", "1");
        phoneBook.add("B", "2");
        String number = phoneBook.findByName("B");
        assertEquals("2", number);
    }

    @Test
    public void testPrintAllNamesEmptyBook() {
        phoneBook.printAllNames();
        assertEquals("", outContent.toString().trim());
    }

    @Test
    public void testPrintAllNamesSingleContact() {
        phoneBook.add("A", "1");
        phoneBook.printAllNames();
        assertEquals("A", outContent.toString().trim());
    }

    @Test
    public void testPrintAllNamesMultipleContacts() {
        phoneBook.add("A", "1");
        phoneBook.add("B", "2");
        phoneBook.printAllNames();
        assertEquals("A\nB", outContent.toString().trim());
    }
}