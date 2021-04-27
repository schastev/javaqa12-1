package domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor

public class Smartphone extends Product {
    private String brand;

    public Smartphone(int id, String name, int price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    public boolean matches(String search) {
        if (!super.matches(search)) {
            if (this.getBrand().equalsIgnoreCase(search)) {
                return true;
            }
        } else {
            return true;
        }
        return false;
    }
}
