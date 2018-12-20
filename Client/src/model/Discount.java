package model;

import java.util.Date;
import java.util.Objects;

/**
 * Class describing object for storing information about Discount, extends {@link Entity}
 */
public class Discount extends Entity<Long> {
    private Integer discountPercent;
    private Date effectiveTo;

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Date getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(Date effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Discount discount = (Discount) o;
        return Objects.equals(discountPercent, discount.discountPercent) &&
                Objects.equals(effectiveTo, discount.effectiveTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discountPercent, effectiveTo);
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountPercent=" + discountPercent +
                ", effectiveTo=" + effectiveTo +
                '}';
    }
}
