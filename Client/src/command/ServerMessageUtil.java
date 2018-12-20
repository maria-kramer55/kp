package command;

import connection.Connection;

public class ServerMessageUtil {
    public static Object get() {
        return Connection.getInstance().get();
    }
}
