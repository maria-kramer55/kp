package command.client;

import command.Command;
import command.ServerMessageUtil;
import model.Client;

import java.util.List;

public class AllClients implements Command {
    @Override
    public void processServerMessage() {
        List<Client> clients = (List<Client>) ServerMessageUtil.get();
    }
}
