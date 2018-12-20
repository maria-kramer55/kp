package command.client;

import command.Command;
import command.ServerMessageUtil;
import model.Client;

public class LogIn implements Command {
    public void processServerMessage() {
        Client client = (Client) ServerMessageUtil.get();
    }
}
