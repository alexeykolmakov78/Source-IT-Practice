package ua.kolmakov.discount.impl.gpoupes;

import ua.kolmakov.discount.model.Discount;
import ua.kolmakov.discount.model.ProductGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kolmakov Alexey on 05.08.2015.
 */
public abstract class BaseGroup implements ProductGroup {
    protected String name;
    protected List<Discount> discounts;

    public BaseGroup(String name) {
        this.name = name;
        discounts = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Discount> getDiscounts() {
        return discounts;
    }
}
