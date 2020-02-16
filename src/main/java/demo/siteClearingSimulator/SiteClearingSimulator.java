/**
 *
 */
package demo.siteClearingSimulator;

import demo.siteClearingSimulator.command.CommandData;
import demo.siteClearingSimulator.data.Simulator;
import demo.siteClearingSimulator.validator.SimulatorValidator;

import java.util.Scanner;

/**
 * @author Vinayasimha Patil
 *
 */
public class SiteClearingSimulator {

    /**
     * @param args
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            usage();
        }

        Simulator simulator = Simulator.buildSimulator(args[0]);

        if (!SimulatorValidator.isValidSite(simulator.getSite())) {
            System.out.println("Site map data is invalid");
            System.exit(0);
        }

        System.out.println(TextConstants.WELCOME);
        System.out.println();
        System.out.println(simulator.getSite());

        System.out.println(TextConstants.BULLDOZER_STATUS);
        System.out.println();

        try (Scanner scanner = new Scanner(System.in)) {
            while (!simulator.isQuitSimulator()) {
                System.out.print(TextConstants.COMMANDS);
                String commandInput = scanner.nextLine();
                CommandData commandData = CommandData.buildCommandData(commandInput);

                if (!SimulatorValidator.isValidCommand(commandData)) {
                    System.out.println("Invalid Command");
                    continue;
                }

                commandData.getCommandType().getCommand().execute(simulator, commandData);
            }
        }

        System.out.println();
        System.out.println(TextConstants.COMMANDS_EXECUTED_HEADER);

        System.out.println();
        System.out.println(simulator.getExecutedCommands());

        System.out.println();
        System.out.println(TextConstants.REPORT_HEADER);

        simulator.calculateCost();
        System.out.println();
        System.out.println(simulator.getReport());

        System.out.println();
        System.out.println(TextConstants.THANK_YOU);
    }

    private static void usage() {
        System.out.println("SiteClearingSimulator <siteMapFilePath>");
        System.out.println("SiteClearingSimulator C:\\data\\SiteMapFile.txt");
        System.exit(0);
    }

}
