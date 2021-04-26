package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import repository.ProductRepository;

public class ProductManager {
    public static Product[] searchBy(String text) {
        Product[] items = ProductRepository.getAll();
        Product[] searchResult = new Product[0];
        for (Product item : items) {
            if (matches(item, text)) {
                int len = searchResult.length + 1;
                Product[] tmp = new Product[len];
                if (len > 1) { //only bring over the old array when there is something to bring over
                    System.arraycopy(searchResult, 0, tmp, 0, len - 1);
                }
                tmp[len - 1] = item;
                searchResult = tmp;
            }
        }
        return searchResult;
    }

    public static boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            return book.getName().equalsIgnoreCase(search) || book.getAuthor().equalsIgnoreCase(search);
        } else if (product instanceof Smartphone) {
            Smartphone phone = (Smartphone) product;
            return phone.getName().equalsIgnoreCase(search) || phone.getBrand().equalsIgnoreCase(search);
        }
        return false;
    }
}