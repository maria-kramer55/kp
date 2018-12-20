package Entity;

import java.io.Serializable;

public class Worker implements Serializable {
    public int workerNumber;
    public String workerName;
    public String workerLastName;
    public String serviceName;
    public int workerSallary;


    public Worker() {
    }

    public Worker(int workerNumber, String workerName, String workerLastName, String serviceName, int workerSallary) {
        this.workerNumber = workerNumber;
        this.workerName = workerName;
        this.workerLastName = workerLastName;
        this.serviceName = serviceName;
        this.workerSallary = workerSallary;
    }

    public int getWorkerNumber() {
        return workerNumber;
    }

    public void setWorkerNumber(int workerNumber) {
        this.workerNumber = workerNumber;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerLastName() {
        return workerLastName;
    }

    public void setWorkerLastName(String workerLastName) {
        this.workerLastName = workerLastName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getWorkerSallary() {
        return workerSallary;
    }

    public void setWorkerSallary(int workerSallary) {
        this.workerSallary = workerSallary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

        if (getWorkerNumber() != worker.getWorkerNumber()) return false;
        if (!getWorkerName().equals(worker.getWorkerName())) return false;
        if (!getWorkerLastName().equals(worker.getWorkerLastName())) return false;
        return getServiceName().equals(worker.getServiceName());
    }

    @Override
    public int hashCode() {
        int result = getWorkerNumber();
        result = 31 * result + getWorkerName().hashCode();
        result = 31 * result + getWorkerLastName().hashCode();
        result = 31 * result + getServiceName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "workerNumber=" + workerNumber +
                ", workerName='" + workerName + '\'' +
                ", workerLastName='" + workerLastName + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", workerSallary=" + workerSallary +
                '}';
    }
}

