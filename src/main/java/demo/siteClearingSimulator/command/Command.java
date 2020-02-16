/**
 *
 */
package demo.siteClearingSimulator.command;

import demo.siteClearingSimulator.data.Simulator;

/**
 * @author Vinayasimha Patil
 *
 */
public interface Command {
    void execute(Simulator simulator, CommandData commandData);
}
