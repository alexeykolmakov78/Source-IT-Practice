package ua.kolmakov.discount.model;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 */
public interface Product {
    String getName();
    List<ProductGroup> getGroups();
    BigDecimal getPrice();//цена без скидки
    Long getId();
    BigDecimal adjustPrice();//цена со скидкой
}
