package ua.kolmakov.discount.impl.products;

import ua.kolmakov.discount.impl.DiscountCalculator;
import ua.kolmakov.discount.model.Product;
import ua.kolmakov.discount.model.ProductGroup;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kolmakov Alexey on 04.08.2015.
 */
public abstract class BaseProduct implements Product {
    protected Long id;
    protected String name;
    protected List<ProductGroup> groups;
    protected BigDecimal price;

    public BaseProduct(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
        groups = new ArrayList<>();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<ProductGroup> getGroups() {
        return groups;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public BigDecimal adjustPrice() {
        return this.getPrice().subtract(DiscountCalculator.calculate(this));
    }
}
