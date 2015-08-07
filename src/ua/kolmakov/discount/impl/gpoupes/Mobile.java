package ua.kolmakov.discount.impl.gpoupes;

import ua.kolmakov.discount.impl.discounts.GroupDiscount;
import ua.kolmakov.discount.impl.discounts.ProductDiscount;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Kolmakov Alexey on 04.08.2015.
 */
public class Mobile extends BaseGroup {

    public Mobile(String name) {
        super(name);
        discounts.add(new ProductDiscount(new Date(2015 - 1900, 10, 1), new Date(2015 - 1900, 11, 1), new BigDecimal(0.15)));
        discounts.add(new GroupDiscount(new Date(2015 - 1900, 6, 30), new Date(2015 - 1900, 9, 30), new BigDecimal(0.15)));
    }
}
