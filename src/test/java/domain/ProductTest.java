package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    ProductRepository repo = new ProductRepository();
    Smartphone testPhone1 = new Smartphone(1, "EG102", 12300, "Samsung");
    Book testBook1 = new Book(2, "Herlock Sholmes", 1200, "Capcom");
    Smartphone testPhone2 = new Smartphone(1, "EG103", 12300, "Apple");
    Book testBook2 = new Book(2, "Compra", 1200, "Konami");

    @BeforeEach
    public void setUp() {
        repo.save(testPhone1);
        repo.save(testBook1);
        repo.save(testPhone2);
        repo.save(testBook2);
    }

    @AfterEach
    public void cleanUp() {
        repo.removeAll();
    }

    @Test
    public void matchesNameTest() {
        String text = "Herlock Sholmes";
        boolean actual = testBook1.matches(text);
        assertTrue(actual);
    }
    @Test
    public void matchesAuthorTest() {
        String text = "Capcom";
        boolean actual = testBook1.matches(text);
        assertTrue(actual);
    }
    @Test
    public void matchesBrandTest() {
        String text = "Apple";
        boolean actual = testPhone2.matches(text);
        assertTrue(actual);
    }
    @Test
    public void doesnotmatchBrandTest() {
        String text = "Apple";
        boolean actual = testPhone1.matches(text);
        assertFalse(actual);
    }
}