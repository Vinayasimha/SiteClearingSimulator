package demo.siteClearingSimulator.validator;

import demo.siteClearingSimulator.command.CommandData;
import demo.siteClearingSimulator.command.CommandType;
import demo.siteClearingSimulator.data.Site;
import demo.siteClearingSimulator.data.SiteSquare;

import java.util.Collection;
import java.util.Objects;

/**
 * @author Vinayasimha Patil
 *
 */
public class SimulatorValidator {

    public static boolean isValidSite(Site site) {
        if (site.getSiteSquares() == null || site.getSiteSquares().isEmpty()) {
            return false;
        }

        if (site.getSiteSquares().get(0).isEmpty()) {
            return false;
        }

        int columnCount = site.getSiteSquares().get(0).size();
        if (site.getSiteSquares().stream().anyMatch(siteSquares -> siteSquares.size() != columnCount)) {
            return false;
        }

        if (site.getSiteSquares().stream()
                .flatMap(Collection::stream)
                .map(SiteSquare::getLandType)
                .anyMatch(Objects::isNull)) {
            return false;
        }

        return true;
    }

    public static boolean isValidCommand(CommandData commandData) {
        return commandData.getCommandType() != null &&
                (commandData.getCommandType() != CommandType.ADVANCE || commandData.getCommandData() > 0);
    }
}
