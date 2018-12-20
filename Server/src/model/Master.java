package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Master extends Entity<Long> {
    private String name;
    private BigDecimal salary;
    private String phoneNumber;
    private long procedure;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getProcedure() {
        return procedure;
    }

    public void setProcedure(long procedure) {
        this.procedure = procedure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Master master = (Master) o;
        return Objects.equals(name, master.name) &&
                Objects.equals(salary, master.salary) &&
                Objects.equals(phoneNumber, master.phoneNumber) &&
                Objects.equals(procedure, master.procedure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, salary, phoneNumber, procedure);
    }

    @Override
    public String toString() {
        return "Master{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", procedure=" + procedure +
                '}';
    }
}
