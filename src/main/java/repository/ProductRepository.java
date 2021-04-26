package repository;

import domain.Product;

public class ProductRepository {
    private static Product[] repository = new Product[0];

    public void save(Product item) {
        int j = repository.length;
        Product[] tmp = new Product[j + 1];
        System.arraycopy(repository, 0, tmp, 0, j);
        tmp[j] = item;
        repository = tmp;
    }

    public static Product[] getAll() {
        return repository;
    }

    public void removeById(int id) {
        int j = repository.length;
        Product[] tmp = new Product[j - 1];
        int i = 0;
        for (Product prod : repository) {
            if (prod.getId() != id) {
                tmp[i] = prod;
                i++;
            }
        }
        repository = tmp;
    }
    public void removeAll() {
        repository = new Product[0];
    }
}
