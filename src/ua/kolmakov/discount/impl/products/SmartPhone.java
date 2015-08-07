package ua.kolmakov.discount.impl.products;

import ua.kolmakov.discount.impl.gpoupes.Electronics;
import ua.kolmakov.discount.impl.gpoupes.Mobile;
import ua.kolmakov.discount.impl.gpoupes.PC;

import java.math.BigDecimal;

/**
 * Created by Kolmakov Alexey on 04.08.2015.
 */
public class SmartPhone extends BaseProduct {

    public SmartPhone(Long id, String name, BigDecimal price) {
        super(id, name, price);
        groups.add(new Electronics("Electronic Group"));
        groups.add(new PC("PC Group"));
        groups.add(new Mobile("Mobile Group"));
    }

}
