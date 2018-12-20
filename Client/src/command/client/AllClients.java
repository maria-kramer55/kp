package command.client;

import command.Command;
import command.ServerMessageUtil;
import model.Client;

import java.util.List;

public class AllClients implements Command {
    private List<Client> clients;

    @Override
    public void processServerMessage() {
        clients = (List<Client>) ServerMessageUtil.get();
    }

    public List<Client> getClients() {
        processServerMessage();
        return clients;
    }
}
