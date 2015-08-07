package ua.kolmakov.discount.impl.discounts;

import ua.kolmakov.discount.model.DiscountType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Kolmakov Alexey on 04.08.2015.
 */
public class ProductDiscount extends BaseDiscount {

    public ProductDiscount(Date expireDate, Date startDate, BigDecimal discount) {
        super(expireDate, startDate, discount);
        type = DiscountType.PRODUCT_ONLY;
    }
}