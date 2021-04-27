package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    Smartphone testPhone1 = new Smartphone(1, "EG102", 12300, "Samsung");
    Smartphone testPhone2 = new Smartphone(1, "EG103", 12300, "Apple");
    Smartphone testPhone3 = new Smartphone(1, "EG103", 12300, "Samsung");
    Book testBook1 = new Book(2, "Herlock Sholmes", 1200, "Capcom");
    Book testBook2 = new Book(2, "Compra", 1200, "Konami");

    @BeforeEach
    public void setUp() {
        repo.save(testPhone1);
        repo.save(testBook1);
        repo.save(testPhone2);
        repo.save(testBook2);
        repo.save(testPhone3);
    }

    @AfterEach
    public void cleanUp() {
        repo.removeAll();
    }

    @Test
    void searchByBookNameTest() {
        String text = "Herlock Sholmes";
        Product[] actual = ProductManager.searchBy(text);
        Product[] expected = new Product[]{testBook1};
        assertArrayEquals(actual, expected);
    }

    @Test
    void searchByAuthorTest() {
        String text = "Capcom";
        Product[] actual = ProductManager.searchBy(text);
        Product[] expected = new Product[]{testBook1};
        assertArrayEquals(actual, expected);
    }
    @Test
    void searchByBrandTest() {
        String text = "Samsung";
        Product[] actual = ProductManager.searchBy(text);
        Product[] expected = new Product[]{testPhone1, testPhone3};
        assertArrayEquals(actual, expected);
    }
    @Test
    void searchByPhoneNameTest() {
        String text = "EG102";
        Product[] actual = ProductManager.searchBy(text);
        Product[] expected = new Product[]{testPhone1};
        assertArrayEquals(actual, expected);
    }

    @Test
    void searchByNothingFound() {
        String text = "123";
        Product[] actual = ProductManager.searchBy(text);
        Product[] expected = new Product[0];
        assertArrayEquals(actual, expected);
    }

}