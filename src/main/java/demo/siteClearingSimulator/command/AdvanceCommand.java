/**
 *
 */
package demo.siteClearingSimulator.command;

import demo.siteClearingSimulator.data.BulldozerPosition;
import demo.siteClearingSimulator.data.Simulator;
import demo.siteClearingSimulator.data.SiteSquare;

/**
 * @author Vinayasimha Patil
 *
 */
public class AdvanceCommand implements Command {

    @Override
    public void execute(Simulator simulator, CommandData commandData) {
        for (int i = 0; i < commandData.getCommandData(); i++) {
            moveBulldozer(simulator, (i == commandData.getCommandData() - 1));
            if (simulator.isQuitSimulator()) {
                break;
            }
        }

        simulator.getReport().getCommunicationOverhead().addQuantity(1);
        simulator.getExecutedCommands().add(commandData);
    }

    private void moveBulldozer(Simulator simulator, boolean isLastSquareInTheMove) {
        BulldozerPosition bulldozerPosition = simulator.getBulldozerPosition();
        switch (bulldozerPosition.getBulldozerDirection()) {
            case NORTH:
                bulldozerPosition.setLatitude(bulldozerPosition.getLatitude() - 1);
                break;
            case SOUTH:
                bulldozerPosition.setLatitude(bulldozerPosition.getLatitude() + 1);
                break;
            case EAST:
                bulldozerPosition.setLongitude(bulldozerPosition.getLongitude() + 1);
                break;
            case WEST:
                bulldozerPosition.setLongitude(bulldozerPosition.getLongitude() - 1);
                break;
        }

        if (isBulldozerCameOutOfSite(simulator)) {
            simulator.setQuitSimulator(true);
            return;
        }

        SiteSquare currentSquare = simulator.getSite().getSiteSquares()
                .get(bulldozerPosition.getLatitude()).get(bulldozerPosition.getLongitude());

        int fuelUsage = 1;
        switch (currentSquare.getLandType()) {
            case PLAIN_LAND:
                fuelUsage = 1;
                break;
            case ROCKY_LAND:
                fuelUsage = currentSquare.isCleared() ? 1 : 2;
                break;
            case TREE_LAND:
                fuelUsage = currentSquare.isCleared() ? 1 : 2;
                if (!isLastSquareInTheMove) {
                    simulator.getReport().getPaintDamageToBulldozer().addQuantity(1);
                }
                break;
            case PROTECTED_TREE_LAND:
                fuelUsage = currentSquare.isCleared() ? 1 : 2;
                simulator.getReport().getDestructionOfProtectedTree().addQuantity(1);
                simulator.setQuitSimulator(true);
                break;
        }

        simulator.getReport().getFuelUsage().addQuantity(fuelUsage);
        currentSquare.setCleared(true);
    }

    private boolean isBulldozerCameOutOfSite(Simulator simulator) {
        BulldozerPosition bulldozerPosition = simulator.getBulldozerPosition();
        return (bulldozerPosition.getLatitude() < 0
                || bulldozerPosition.getLatitude() >= simulator.getSite().getSiteSquares().size()
                || bulldozerPosition.getLongitude() < 0
                || bulldozerPosition.getLongitude() >= simulator.getSite().getSiteSquares().get(0).size());
    }

}
