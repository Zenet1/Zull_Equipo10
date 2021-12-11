package Src;

public class Process {
    private Command command;

    public Process(Command command) {
        this.command = command;
    }

    int commandCases() {

        if (command.getMainCommand().equals("go"))
            return 1;

        if (command.getMainCommand().equals("help"))
            return 2;

        if (command.getMainCommand().equals("quit"))
            return 3;

        return 0;
    }

    boolean quit() {
        boolean isNull;
        if (command.getSecondaryCommand().equals("NOWHERE")) {
            isNull = true;
        } else {
            isNull = false;
        }
        return isNull;
    };

    boolean nowhere() {
        if (command.getSecondaryCommand().equals("NOWHERE")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isUnknown() {
        if (command.getMainCommand() == null) {
            return true;
        } else {
            return false;
        }
    }

    public Command getCommand() {
        return this.command;
    }
}