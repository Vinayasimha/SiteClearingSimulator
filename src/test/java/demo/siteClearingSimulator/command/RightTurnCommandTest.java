package demo.siteClearingSimulator.command;

import demo.siteClearingSimulator.data.BulldozerDirection;
import demo.siteClearingSimulator.data.BulldozerPosition;
import demo.siteClearingSimulator.data.Report;
import demo.siteClearingSimulator.data.Simulator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

@RunWith(JUnit4.class)
public class RightTurnCommandTest {

    @Test
    public void testRightTurnCommand() {
        Simulator simulator = new Simulator();
        simulator.setBulldozerPosition(new BulldozerPosition(1, 1, BulldozerDirection.NORTH));
        simulator.setExecutedCommands(new ArrayList<>());
        simulator.setReport(new Report());

        Command command = new RightTurnCommand();

        command.execute(simulator, new CommandData());
        Assert.assertEquals(BulldozerDirection.EAST, simulator.getBulldozerPosition().getBulldozerDirection());
        Assert.assertEquals(1, simulator.getReport().getCommunicationOverhead().getQuantity());

        command.execute(simulator, new CommandData());
        Assert.assertEquals(BulldozerDirection.SOUTH, simulator.getBulldozerPosition().getBulldozerDirection());
        Assert.assertEquals(2, simulator.getReport().getCommunicationOverhead().getQuantity());

        command.execute(simulator, new CommandData());
        Assert.assertEquals(BulldozerDirection.WEST, simulator.getBulldozerPosition().getBulldozerDirection());
        Assert.assertEquals(3, simulator.getReport().getCommunicationOverhead().getQuantity());

        command.execute(simulator, new CommandData());
        Assert.assertEquals(BulldozerDirection.NORTH, simulator.getBulldozerPosition().getBulldozerDirection());
        Assert.assertEquals(4, simulator.getReport().getCommunicationOverhead().getQuantity());
    }
}
