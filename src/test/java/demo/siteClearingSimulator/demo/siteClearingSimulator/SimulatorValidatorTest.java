package demo.siteClearingSimulator.demo.siteClearingSimulator;

import demo.siteClearingSimulator.command.CommandData;
import demo.siteClearingSimulator.data.LandType;
import demo.siteClearingSimulator.data.Site;
import demo.siteClearingSimulator.data.SiteSquare;
import demo.siteClearingSimulator.validator.SimulatorValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(JUnit4.class)
public class SimulatorValidatorTest {

    @Test
    public void testIsValidSite() {
        Site site = new Site();
        List<List<SiteSquare>> siteSquares = new ArrayList<>();
        site.setSiteSquares(siteSquares);

        Assert.assertFalse(SimulatorValidator.isValidSite(site));

        siteSquares.add(IntStream.range(0, 3)
                .mapToObj(value -> new SiteSquare(LandType.PLAIN_LAND))
                .collect(Collectors.toList()));
        siteSquares.add(IntStream.range(0, 2)
                .mapToObj(value -> new SiteSquare(LandType.PLAIN_LAND))
                .collect(Collectors.toList()));

        Assert.assertFalse(SimulatorValidator.isValidSite(site));

        siteSquares.get(1).add(new SiteSquare(null));
        Assert.assertFalse(SimulatorValidator.isValidSite(site));

        siteSquares.get(1).get(2).setLandType(LandType.PLAIN_LAND);
        Assert.assertTrue(SimulatorValidator.isValidSite(site));
    }

    @Test
    public void testIsValidCommand() {
        CommandData commandData = CommandData.buildCommandData("x");
        boolean isValid = SimulatorValidator.isValidCommand(commandData);
        Assert.assertFalse(isValid);

        commandData = CommandData.buildCommandData("a");
        isValid = SimulatorValidator.isValidCommand(commandData);
        Assert.assertFalse(isValid);

        commandData = CommandData.buildCommandData("l");
        isValid = SimulatorValidator.isValidCommand(commandData);
        Assert.assertTrue(isValid);

        commandData = CommandData.buildCommandData("a  4");
        isValid = SimulatorValidator.isValidCommand(commandData);
        Assert.assertTrue(isValid);
    }
}
