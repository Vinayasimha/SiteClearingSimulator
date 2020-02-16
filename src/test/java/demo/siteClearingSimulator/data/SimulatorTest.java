package demo.siteClearingSimulator.data;

import demo.siteClearingSimulator.command.CommandData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SimulatorTest {

    @Test
    public void testSimulator() {
        Simulator simulator = Simulator.buildSimulator("src/test/resources/sitemap.txt");

        executeCommand(simulator, "a 4");
        executeCommand(simulator, "r");
        executeCommand(simulator, "a 4");
        executeCommand(simulator, "l");
        executeCommand(simulator, "a 2");
        executeCommand(simulator, "a 4");
        executeCommand(simulator, "l");
        executeCommand(simulator, "q");

        simulator.calculateCost();

        Assert.assertTrue(simulator.isQuitSimulator());

        Assert.assertEquals(BulldozerDirection.NORTH, simulator.getBulldozerPosition().getBulldozerDirection());
        Assert.assertEquals(4, simulator.getBulldozerPosition().getLatitude());
        Assert.assertEquals(9, simulator.getBulldozerPosition().getLongitude());

        Assert.assertEquals(new Report.ReportItem(7, 7), simulator.getReport().getCommunicationOverhead());
        Assert.assertEquals(new Report.ReportItem(19, 19), simulator.getReport().getFuelUsage());
        Assert.assertEquals(new Report.ReportItem(34, 102), simulator.getReport().getUnclearedSquares());
        Assert.assertEquals(new Report.ReportItem(0, 0), simulator.getReport().getDestructionOfProtectedTree());
        Assert.assertEquals(new Report.ReportItem(1, 2), simulator.getReport().getPaintDamageToBulldozer());

    }

    private void executeCommand(Simulator simulator, String commandInput) {
        CommandData commandData = CommandData.buildCommandData(commandInput);
        commandData.getCommandType().getCommand().execute(simulator, commandData);
    }
}
