package demo.siteClearingSimulator.command;

import demo.siteClearingSimulator.data.BulldozerDirection;
import demo.siteClearingSimulator.data.BulldozerPosition;
import demo.siteClearingSimulator.data.Simulator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AdvanceCommandTest {

    private Simulator simulator;

    @Before
    public void setupTestData() {
        simulator = Simulator.buildSimulator("src/test/resources/sitemap.txt");
    }

    @Test
    public void testAdvanceCommand() {
        CommandData commandData = CommandData.buildCommandData("a 4");

        Command command = new AdvanceCommand();
        command.execute(simulator, commandData);

        Assert.assertEquals(1, simulator.getReport().getCommunicationOverhead().getQuantity());
        Assert.assertEquals(5, simulator.getReport().getFuelUsage().getQuantity());
        Assert.assertEquals(1, simulator.getReport().getPaintDamageToBulldozer().getQuantity());
    }

    @Test
    public void testAdvanceCommandForExitSite() {
        CommandData commandData = CommandData.buildCommandData("a 14");

        Command command = new AdvanceCommand();
        command.execute(simulator, commandData);

        Assert.assertEquals(1, simulator.getReport().getCommunicationOverhead().getQuantity());
        Assert.assertEquals(11, simulator.getReport().getFuelUsage().getQuantity());
        Assert.assertTrue(simulator.isQuitSimulator());
    }

    @Test
    public void testAdvanceCommandForEnteringProtectedTreeLand() {
        BulldozerPosition bulldozerPosition = simulator.getBulldozerPosition();
        bulldozerPosition.setLongitude(7);
        bulldozerPosition.setBulldozerDirection(BulldozerDirection.SOUTH);
        CommandData commandData = CommandData.buildCommandData("a 3");

        Command command = new AdvanceCommand();
        command.execute(simulator, commandData);

        Assert.assertEquals(1, simulator.getReport().getCommunicationOverhead().getQuantity());
        Assert.assertEquals(2, simulator.getReport().getFuelUsage().getQuantity());
        Assert.assertEquals(1, simulator.getReport().getDestructionOfProtectedTree().getQuantity());
        Assert.assertTrue(simulator.isQuitSimulator());
    }
}
