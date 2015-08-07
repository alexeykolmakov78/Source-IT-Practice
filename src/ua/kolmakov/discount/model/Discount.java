package ua.kolmakov.discount.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 */
public interface Discount {
    DiscountType getType();
    BigDecimal getDiscount();// % of the product price
    Date getExpireDate();
    Date getStartDate();
}
