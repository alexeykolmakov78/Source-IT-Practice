package ua.kolmakov.discount.impl.gpoupes;

import ua.kolmakov.discount.impl.discounts.AccumDiscount;
import ua.kolmakov.discount.impl.discounts.ProductDiscount;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Kolmakov Alexey on 04.08.2015.
 */
public class PC extends BaseGroup {

    public PC(String name) {
        super(name);
        discounts.add(new ProductDiscount(new Date(2015 - 1900, 7, 20), new Date(2015 - 1900, 8, 20), new BigDecimal(0.2)));
        discounts.add(new AccumDiscount(new Date(2015 - 1900, 5, 10), new Date(2015 - 1900, 10, 10), new BigDecimal(0.05)));
    }
}
