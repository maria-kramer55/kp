package Entity;

import java.io.Serializable;

public class Service implements Serializable {

    public int serviceId;
    public String serviceName;
    public String serviceMale;
    public int servicePrice;

    public Service() {
    }

    public Service(int serviceId, String serviceName, String serviceMale) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceMale = serviceMale;
    }

    public Service(int serviceId, String serviceName, String serviceMale, int servicePrice) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceMale = serviceMale;
        this.servicePrice = servicePrice;
    }

    public Service(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceMale() {
        return serviceMale;
    }

    public void setServiceMale(String serviceMale) {
        this.serviceMale = serviceMale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        if (getServiceId() != service.getServiceId()) return false;
        if (getServicePrice() != service.getServicePrice()) return false;
        if (!getServiceName().equals(service.getServiceName())) return false;
        return getServiceMale().equals(service.getServiceMale());
    }

    @Override
    public int hashCode() {
        int result = getServiceId();
        result = 31 * result + getServiceName().hashCode();
        result = 31 * result + getServiceMale().hashCode();
        result = 31 * result + getServicePrice();
        return result;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                ", serviceMale='" + serviceMale + '\'' +
                ", servicePrice=" + servicePrice +
                '}';
    }
}
