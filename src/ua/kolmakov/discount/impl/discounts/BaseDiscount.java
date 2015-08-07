package ua.kolmakov.discount.impl.discounts;

import ua.kolmakov.discount.model.Discount;
import ua.kolmakov.discount.model.DiscountType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Kolmakov Alexey on 04.08.2015.
 */
public abstract class BaseDiscount implements Discount {
    protected DiscountType type;
    protected Date expireDate;
    protected Date startDate;
    protected BigDecimal discount;


    public BaseDiscount(Date startDate, Date expireDate, BigDecimal discount) {
        this.expireDate = expireDate;
        this.startDate = startDate;
        this.discount = discount;
    }

    @Override
    public DiscountType getType() {
        return type;
    }

    @Override
    public BigDecimal getDiscount() {
        return discount;
    }

    @Override
    public Date getExpireDate() {
        return expireDate;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

}
