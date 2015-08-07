package ua.kolmakov.discount.impl;

import ua.kolmakov.discount.model.Discount;
import ua.kolmakov.discount.model.DiscountType;
import ua.kolmakov.discount.model.Product;
import ua.kolmakov.discount.model.ProductGroup;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kolmakov Alexey on 05.08.2015.
 */
public class DiscountCalculator {

    private static List<Discount> validDiscounts;

    /**
     * Calculates the product discount according to discounts types.
     *
     * @param product
     * @return absolute value of the product discount.
     */
    public static BigDecimal calculate(Product product) {
        BigDecimal result = product.getPrice();
        validDiscounts = findValidDiscounts(product);

        if (validDiscounts.stream()
                .map(d -> d.getType())
                .collect(Collectors.toList()).contains(DiscountType.ACCUMULATIVE)) {
            System.out.println("ACCUMULATIVE");
            return result.multiply(accumulate());
        } else {
            System.out.println("NOT ACCUMULATIVE");
            return result.multiply(maximum());
        }
    }

    /**
     * @return maximum of all actual discounts
     */
    private static BigDecimal maximum() {
        return validDiscounts.stream()
                .map(d -> d.getDiscount())
                .max(Comparator.<BigDecimal>naturalOrder()).get();
    }

    /**
     * @return sum of the all product discounts
     */
    private static BigDecimal accumulate() {
        BigDecimal result = new BigDecimal(0);
        for (Discount discount : validDiscounts) {
            result = result.add(discount.getDiscount());
        }
        return result;
    }

    /**
     * Return all discounts of the product which are valid now.
     *
     * @param product
     * @return valid discounts.
     */
    private static List<Discount> findValidDiscounts(Product product) {
        List<ProductGroup> groups = product.getGroups();
        List<Discount> discounts = new ArrayList<>();
        Date now = new Date();
        for (ProductGroup group : groups) {
            discounts.addAll(group.getDiscounts().stream()
                    .filter(discount -> discount.getStartDate().before(now) && discount.getExpireDate().after(now))
                    .collect(Collectors.toList()));
        }
        return discounts;
    }

}
