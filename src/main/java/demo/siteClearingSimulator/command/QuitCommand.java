/**
 *
 */
package demo.siteClearingSimulator.command;

import demo.siteClearingSimulator.data.Simulator;

/**
 * @author Vinayasimha Patil
 *
 */
public class QuitCommand implements Command {

    @Override
    public void execute(Simulator simulator, CommandData commandData) {
        simulator.setQuitSimulator(true);
        simulator.getExecutedCommands().add(commandData);
    }

}
