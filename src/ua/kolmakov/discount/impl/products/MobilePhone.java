package ua.kolmakov.discount.impl.products;

import ua.kolmakov.discount.impl.gpoupes.Electronics;
import ua.kolmakov.discount.impl.gpoupes.Mobile;

import java.math.BigDecimal;

/**
 * Created by Kolmakov Alexey on 04.08.2015.
 */
public class MobilePhone extends BaseProduct {

    public MobilePhone(Long id, String name, BigDecimal price) {
        super(id, name, price);
        this.groups.add(new Electronics("Electronic Group"));
        this.groups.add(new Mobile("Mobile Group"));
    }
}
