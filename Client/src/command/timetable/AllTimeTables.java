package command.timetable;

import command.Command;
import command.ServerMessageUtil;
import model.TimeTable;

import java.util.List;

public class AllTimeTables implements Command {
    @Override
    public void processServerMessage() {
        List<TimeTable> timeTableList = (List<TimeTable>) ServerMessageUtil.get();
    }
}
