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
public class RightTurnCommand implements Command {

    @Override
    public void execute(Simulator simulator, CommandData commandData) {
        BulldozerDirection newBulldozerDirection;
        switch (simulator.getBulldozerPosition().getBulldozerDirection()) {
            case NORTH:
                newBulldozerDirection = BulldozerDirection.EAST;
                break;
            case SOUTH:
                newBulldozerDirection = BulldozerDirection.WEST;
                break;
            case EAST:
                newBulldozerDirection = BulldozerDirection.SOUTH;
                break;
            case WEST:
                newBulldozerDirection = BulldozerDirection.NORTH;
                break;
            default:
                newBulldozerDirection = simulator.getBulldozerPosition().getBulldozerDirection();
        }

        simulator.getBulldozerPosition().setBulldozerDirection(newBulldozerDirection);
        simulator.getReport().getCommunicationOverhead().addQuantity(1);
        simulator.getExecutedCommands().add(commandData);
    }

}
