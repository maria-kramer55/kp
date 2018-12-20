package connection;

import command.Connection;

public enum ConnectInstance {
    INSTANCE;

    private Connection instance;

    ConnectInstance() {
        instance = new Connection();
    }

    public Connection getInstance() {
        return instance;
    }
}