package command.master;

import command.Command;
import command.ServerMessageUtil;
import model.Master;

import java.util.List;

public class AllMasters implements Command {
    @Override
    public void processServerMessage() {
        List<Master> masters = (List<Master>) ServerMessageUtil.get();
    }
}
