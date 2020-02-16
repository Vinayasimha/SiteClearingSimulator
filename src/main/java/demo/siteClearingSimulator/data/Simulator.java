/**
 *
 */
package demo.siteClearingSimulator.data;

import demo.siteClearingSimulator.command.CommandData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Vinayasimha Patil
 *
 */
public class Simulator {

    private Site site;
    private BulldozerPosition bulldozerPosition;
    private List<CommandData> executedCommands;
    private Report report;

    private boolean quitSimulator;

    public static Simulator buildSimulator(String siteMapFilePath) {
        Simulator simulator = new Simulator();

        simulator.setSite(Site.buildSite(siteMapFilePath));
        simulator.setBulldozerPosition(new BulldozerPosition(0, -1, BulldozerDirection.EAST));
        simulator.setExecutedCommands(new ArrayList<>());
        simulator.setReport(new Report());

        return simulator;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public BulldozerPosition getBulldozerPosition() {
        return bulldozerPosition;
    }

    public void setBulldozerPosition(BulldozerPosition bulldozerPosition) {
        this.bulldozerPosition = bulldozerPosition;
    }

    public List<CommandData> getExecutedCommands() {
        return executedCommands;
    }

    public void setExecutedCommands(List<CommandData> executedCommands) {
        this.executedCommands = executedCommands;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public boolean isQuitSimulator() {
        return quitSimulator;
    }

    public void setQuitSimulator(boolean quitSimulator) {
        this.quitSimulator = quitSimulator;
    }

    public void calculateCost() {
        long unclearedSquares = getSite().getSiteSquares().stream()
                .flatMap(Collection::stream)
                .filter(siteSquare -> !siteSquare.isCleared() && siteSquare.getLandType() != LandType.PROTECTED_TREE_LAND)
                .count();

        report.getUnclearedSquares().addQuantity((int) unclearedSquares);

        report.getCommunicationOverhead().setCost(report.getCommunicationOverhead().getQuantity());
        report.getFuelUsage().setCost(report.getFuelUsage().getQuantity());
        report.getUnclearedSquares().setCost(report.getUnclearedSquares().getQuantity() * 3);
        report.getDestructionOfProtectedTree().setCost(report.getDestructionOfProtectedTree().getQuantity() * 10);
        report.getPaintDamageToBulldozer().setCost(report.getPaintDamageToBulldozer().getQuantity() * 2);
    }

}