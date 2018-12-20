package command;

public class ServerMessageUtil {
    public static Object get() {
        return Connection.getInstance().get();
    }
}
