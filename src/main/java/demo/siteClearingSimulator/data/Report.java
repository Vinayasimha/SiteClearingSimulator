/**
 *
 */
package demo.siteClearingSimulator.data;

import java.util.Objects;

/**
 * @author Vinayasimha Patil
 *
 */
public class Report {
    private ReportItem communicationOverhead;
    private ReportItem fuelUsage;
    private ReportItem unclearedSquares;
    private ReportItem destructionOfProtectedTree;
    private ReportItem paintDamageToBulldozer;

    public Report() {
        communicationOverhead = new ReportItem();
        fuelUsage = new ReportItem();
        unclearedSquares = new ReportItem();
        destructionOfProtectedTree = new ReportItem();
        paintDamageToBulldozer = new ReportItem();
    }

    public ReportItem getCommunicationOverhead() {
        return communicationOverhead;
    }

    public ReportItem getFuelUsage() {
        return fuelUsage;
    }

    public ReportItem getUnclearedSquares() {
        return unclearedSquares;
    }

    public ReportItem getDestructionOfProtectedTree() {
        return destructionOfProtectedTree;
    }

    public ReportItem getPaintDamageToBulldozer() {
        return paintDamageToBulldozer;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Item                             Quantity    Cost").append(System.lineSeparator());

        builder.append("Communication Overhead           ")
                .append(String.format("%8s", communicationOverhead.quantity)).append("    ")
                .append(String.format("%4s", communicationOverhead.cost))
                .append(System.lineSeparator());

        builder.append("Fuel Usage                       ")
                .append(String.format("%8s", fuelUsage.quantity)).append("    ")
                .append(String.format("%4s", fuelUsage.cost))
                .append(System.lineSeparator());

        builder.append("Uncleared Squares                ")
                .append(String.format("%8s", unclearedSquares.quantity)).append("    ")
                .append(String.format("%4s", unclearedSquares.cost))
                .append(System.lineSeparator());

        builder.append("Destruction of Protected Tree    ")
                .append(String.format("%8s", destructionOfProtectedTree.quantity)).append("    ")
                .append(String.format("%4s", destructionOfProtectedTree.cost))
                .append(System.lineSeparator());

        builder.append("Paint Damage to Bulldozer        ")
                .append(String.format("%8s", paintDamageToBulldozer.quantity)).append("    ")
                .append(String.format("%4s", paintDamageToBulldozer.cost))
                .append(System.lineSeparator());

        builder.append("-------------------------------------------------").append(System.lineSeparator());

        builder.append("Total                                        ").append(String.format("%4s", totalCost()));

        return builder.toString();
    }

    private int totalCost() {
        return communicationOverhead.cost +
                fuelUsage.cost +
                unclearedSquares.cost +
                destructionOfProtectedTree.cost +
                paintDamageToBulldozer.cost;
    }

    public static class ReportItem {
        private int quantity;
        private int cost;

        public ReportItem() {

        }

        public ReportItem(int quantity, int cost) {
            this.quantity = quantity;
            this.cost = cost;
        }

        public int getQuantity() {
            return quantity;
        }

        public void addQuantity(int quantity) {
            this.quantity += quantity;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ReportItem that = (ReportItem) o;
            return quantity == that.quantity &&
                    cost == that.cost;
        }

        @Override
        public int hashCode() {
            return Objects.hash(quantity, cost);
        }
    }
}
