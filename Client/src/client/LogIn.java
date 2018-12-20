package client;

import Enum.ConnectInstance;
import model.Client;

public class LogIn {

    public static String access;
    public static String clientName;
    public static String clientLastName;

    public static void access() {
        Client client = (Client) ConnectInstance.INSTANCE.getInstance().get();
    }
}
