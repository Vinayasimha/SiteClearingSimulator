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
public class QuitCommandTest {

    @Test
    public void testQuitCommand() {
        Simulator simulator = new Simulator();
        simulator.setBulldozerPosition(new BulldozerPosition(1, 1, BulldozerDirection.NORTH));
        simulator.setExecutedCommands(new ArrayList<>());
        simulator.setReport(new Report());

        Command command = new QuitCommand();

        command.execute(simulator, new CommandData());
        Assert.assertTrue(simulator.isQuitSimulator());
        Assert.assertEquals(0, simulator.getReport().getCommunicationOverhead().getQuantity());
    }
}
