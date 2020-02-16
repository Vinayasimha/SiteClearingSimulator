/**
 *
 */
package demo.siteClearingSimulator.command;

/**
 * @author Vinayasimha Patil
 *
 */
public class CommandData {
    private CommandType commandType;
    private int commandData;

    public static CommandData buildCommandData(String commandInput) {
        CommandData commandData = new CommandData();

        commandInput = commandInput.trim();
        if (commandInput.isEmpty()) {
            return commandData;
        }

        CommandType commandType = CommandType.getCommandType(Character.toLowerCase(commandInput.charAt(0)));
        if (commandType == CommandType.ADVANCE) {
            try {
                commandData.setCommandData(Integer.parseInt(commandInput.substring(1).trim()));
            } catch (Exception e) {
            }

        } else if (commandInput.length() != 1) {
            return commandData;
        }

        commandData.setCommandType(commandType);

        return commandData;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public int getCommandData() {
        return commandData;
    }

    public void setCommandData(int commandData) {
        this.commandData = commandData;
    }

    @Override
    public String toString() {
        StringBuilder commandDataString = new StringBuilder();
        commandDataString.append(commandType);

        if (commandType == CommandType.ADVANCE) {
            commandDataString.append(" ").append(commandData);
        }

        return commandDataString.toString();
    }
}
