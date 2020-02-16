/**
 *
 */
package demo.siteClearingSimulator.command;

import demo.siteClearingSimulator.data.BulldozerDirection;
import demo.siteClearingSimulator.data.Simulator;

/**
 * @author Vinayasimha Patil
 *
 */
public class LeftTurnCommand implements Command {

    @Override
    public void execute(Simulator simulator, CommandData commandData) {
        BulldozerDirection newBulldozerDirection;
        switch (simulator.getBulldozerPosition().getBulldozerDirection()) {
            case NORTH:
                newBulldozerDirection = BulldozerDirection.WEST;
                break;
            case SOUTH:
                newBulldozerDirection = BulldozerDirection.EAST;
                break;
            case EAST:
                newBulldozerDirection = BulldozerDirection.NORTH;
                break;
            case WEST:
                newBulldozerDirection = BulldozerDirection.SOUTH;
                break;
            default:
                newBulldozerDirection = simulator.getBulldozerPosition().getBulldozerDirection();
        }

        simulator.getBulldozerPosition().setBulldozerDirection(newBulldozerDirection);
        simulator.getReport().getCommunicationOverhead().addQuantity(1);
        simulator.getExecutedCommands().add(commandData);
    }

}
