package command;

import java.util.ArrayList;
import java.util.List;

public class _2524764_CommandInvoker {

    private List<_2524764_Command> commandHistory = new ArrayList<>();

    public void executeCommand(_2524764_Command command) {
        command.execute();
        commandHistory.add(command);
    }

    public List<_2524764_Command> getCommandHistory() {
        return commandHistory;
    }
}
