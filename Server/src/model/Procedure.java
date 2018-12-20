package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Procedure extends Entity<Long> {
    private String type;
    private BigDecimal cost;
    private int discount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Procedure procedure = (Procedure) o;
        return Objects.equals(type, procedure.type) &&
                Objects.equals(cost, procedure.cost) &&
                Objects.equals(discount, procedure.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, cost, discount);
    }

    @Override
    public String toString() {
        return "Procedure{" +
                "type='" + type + '\'' +
                ", cost=" + cost +
                ", discount=" + discount +
                '}';
    }
}
