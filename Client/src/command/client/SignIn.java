package command.client;

import command.Command;
import command.ServerMessageUtil;
import model.Client;

public class SignIn implements Command {
    @Override
    public void processServerMessage() {
        Client client = (Client) ServerMessageUtil.get();
    }
}
