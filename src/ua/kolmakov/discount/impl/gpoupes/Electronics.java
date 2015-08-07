package ua.kolmakov.discount.impl.gpoupes;

import ua.kolmakov.discount.impl.discounts.ProductDiscount;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Kolmakov Alexey on 04.08.2015.
 */

public class Electronics extends BaseGroup {

    public Electronics(String name) {
        super(name);
        discounts.add(new ProductDiscount(new Date(2015 - 1900, 5, 10), new Date(2015 - 1900, 9, 10), new BigDecimal(0.1)));
    }
}
