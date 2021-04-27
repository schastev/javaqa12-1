package domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public boolean matches(String search) {
        if (!super.matches(search)) {
            if (this.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
        } else {
            return true;
        }
        return false;
    }
}
