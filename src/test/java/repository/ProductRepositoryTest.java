package repository;

import domain.Product;
import org.junit.jupiter.api.*;

class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
    private Product one = new Product(1, "one", 21);
    private Product two = new Product(2, "one", 10);
    private Product three = new Product(3, "one", 40);
    private Product four = new Product(4, "one", 17);
    private Product five = new Product(5, "one", 100);
    private Product six = new Product(6, "one", 1239);


    @BeforeEach
    public void setUp() {
        repo.save(one);
        repo.save(two);
        repo.save(three);
        repo.save(four);
        repo.save(five);
        repo.save(six);
    }

    @AfterEach
    public void cleanUp() {
        repo.removeAll();
    }


    @Test
    public void getAllTest() {
        Product[] expected = new Product[]{one, two, three, four, five, six};
        Product[] actual = ProductRepository.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdTest() {
        Product[] expected = new Product[]{one, two, three, five, six};
        repo.removeById(4);
        Product[] actual = ProductRepository.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}