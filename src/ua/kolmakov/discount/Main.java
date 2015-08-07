package ua.kolmakov.discount;

import ua.kolmakov.discount.impl.products.Laptop;
import ua.kolmakov.discount.impl.products.MobilePhone;
import ua.kolmakov.discount.impl.products.SmartPhone;
import ua.kolmakov.discount.impl.products.VacuumCleaner;
import ua.kolmakov.discount.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kolmakov Alexey on 04.08.2015.
 */
public class Main {

    public static void main(String[] args) {
        Product prod1 = new SmartPhone(1L, "tablet", new BigDecimal(3000d));
        Product prod2 = new MobilePhone(2L, "mobile phone", new BigDecimal(1000d));
        Product prod3 = new VacuumCleaner(3L, "vacuum cleaner", new BigDecimal(6000d));
        Product prod4 = new Laptop(4L, "laptop", new BigDecimal(12000d));
        List<Product> productList = new ArrayList<>();
        productList.add(prod1);
        productList.add(prod2);
        productList.add(prod3);
        productList.add(prod4);

        for (Product product : productList) {
            System.out.printf("Product: %s; price: %f; discount price: %f \n",
                    product.getName(), product.getPrice().doubleValue(), product.adjustPrice().doubleValue());
        }
    }


}
