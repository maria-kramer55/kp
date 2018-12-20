package command;

import connection.ConnectInstance;

public class ServerMessageUtil {
    public static Object get() {
        return ConnectInstance.INSTANCE.getInstance().get();
    }
}
