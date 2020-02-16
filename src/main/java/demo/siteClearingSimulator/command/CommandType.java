/**
 *
 */
package demo.siteClearingSimulator.command;

import java.util.Arrays;

/**
 * @author Vinayasimha Patil
 *
 */
public enum CommandType {
    ADVANCE('a', "Advance", new AdvanceCommand()),
    LEFT('l', "Turn Left", new LeftTurnCommand()),
    RIGHT('r', "Turn Right", new RightTurnCommand()),
    QUIT('q', "Quit", new QuitCommand());

    private char commandTypeCode;
    private String commandText;
    private Command command;

    private CommandType(char commandTypeCode, String commandText, Command command) {
        this.commandTypeCode = commandTypeCode;
        this.commandText = commandText;
        this.command = command;
    }

    public char getCommandTypeCode() {
        return commandTypeCode;
    }


    public Command getCommand() {
        return command;
    }

    public static CommandType getCommandType(char commandTypeCode) {
        return Arrays.stream(CommandType.values())
                .filter(landType -> landType.getCommandTypeCode() == commandTypeCode)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return commandText;
    }
}
