package ua.kolmakov.discount.impl.products;

import ua.kolmakov.discount.impl.gpoupes.Electronics;

import java.math.BigDecimal;

/**
 * Created by Kolmakov Alexey on 04.08.2015.
 */
public class VacuumCleaner extends BaseProduct {

    public VacuumCleaner(Long id, String name, BigDecimal price) {
        super(id, name, price);
        groups.add(new Electronics("Electronic Group"));
    }
}
