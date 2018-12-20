package command.procedure;

import command.Command;
import command.ServerMessageUtil;
import model.Procedure;

import java.util.List;

public class AllProcedures implements Command {
    @Override
    public void processServerMessage() {
        List<Procedure> procedures = (List<Procedure>) ServerMessageUtil.get();
    }
}
