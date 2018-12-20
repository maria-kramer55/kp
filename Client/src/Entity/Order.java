package Entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    public  int orderId;
    public Date orderDate;
    public String clientName;
    public String clientLastName;
    public String serviceName;
    public String masterName;
    public String materialName;
    public int orderPrice;

    public Order() {
    }

    public Order(int orderId, Date orderDate, String clientName, String clientLastName, String serviceName,
                 String masterName, String materialName, int orderPrice) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.clientName = clientName;
        this.clientLastName = clientLastName;
        this.serviceName = serviceName;
        this.masterName = masterName;
        this.materialName = materialName;
        this.orderPrice = orderPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (getOrderId() != order.getOrderId()) return false;
        if (!getClientName().equals(order.getClientName())) return false;
        if (!getClientLastName().equals(order.getClientLastName())) return false;
        if (!getServiceName().equals(order.getServiceName())) return false;
        if (!getMasterName().equals(order.getMasterName())) return false;
        return getMaterialName().equals(order.getMaterialName());
    }

    @Override
    public int hashCode() {
        int result = getOrderId();
        result = 31 * result + getClientName().hashCode();
        result = 31 * result + getClientLastName().hashCode();
        result = 31 * result + getServiceName().hashCode();
        result = 31 * result + getMasterName().hashCode();
        result = 31 * result + getMaterialName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", clientName='" + clientName + '\'' +
                ", clientLastName='" + clientLastName + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", masterName='" + masterName + '\'' +
                ", materialName='" + materialName + '\'' +
                ", orderPrice=" + orderPrice +
                '}';
    }
}
