package command.discount;

import command.Command;
import command.ServerMessageUtil;
import model.Discount;

import java.util.List;

public class AllDiscounts implements Command {
    @Override
    public void processServerMessage() {
        List<Discount> list = (List<Discount>) ServerMessageUtil.get();
    }
}
