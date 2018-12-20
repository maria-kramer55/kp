package Entity;


import java.io.Serializable;

public class Client implements Serializable {

    private int clientId;
    private String clientName;
    private String clientLastName;
    private String clientGender;
    private String clientLogin;
    private String clientPassword;

    public Client() {
    }

    public Client( String clientName, String clientLastName, String clientGender) {
        this.clientName = clientName;
        this.clientLastName = clientLastName;
        this.clientGender = clientGender;
    }

    public Client(int clientId) {
        this.clientId = clientId;
    }

    public Client(String clientLogin, String clientPassword) {
        this.clientLogin = clientLogin;
        this.clientPassword = clientPassword;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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

    public String getClientGender() {
        return clientGender;
    }

    public void setClientGender(String clientGender) {
        this.clientGender = clientGender;
    }

    public String getClientLogin() {
        return clientLogin;
    }

    public void setClientLogin(String clientLogin) {
        this.clientLogin = clientLogin;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (getClientId() != client.getClientId()) return false;
        if (!getClientName().equals(client.getClientName())) return false;
        return getClientLastName().equals(client.getClientLastName());
    }

    @Override
    public int hashCode() {
        int result = getClientId();
        result = 31 * result + getClientName().hashCode();
        result = 31 * result + getClientLastName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", clientLastName='" + clientLastName + '\'' +
                ", clientGender='" + clientGender + '\'' +
                ", clientLogin='" + clientLogin + '\'' +
                ", clientPassword='" + clientPassword + '\'' +
                '}';
    }
}
