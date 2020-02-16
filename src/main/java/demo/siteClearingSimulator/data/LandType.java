/**
 *
 */
package demo.siteClearingSimulator.data;

import java.util.Arrays;

/**
 * @author Vinayasimha Patil
 *
 */
public enum LandType {
    PLAIN_LAND('o'),
    ROCKY_LAND('r'),
    TREE_LAND('t'),
    PROTECTED_TREE_LAND('T');

    private char landTypeCode;

    private LandType(char landTypeCode) {
        this.landTypeCode = landTypeCode;
    }

    public char getLandTypeCode() {
        return landTypeCode;
    }

    public static LandType getLandType(char landTypeCode) {
        return Arrays.stream(LandType.values())
                .filter(landType -> landType.getLandTypeCode() == landTypeCode)
                .findFirst()
                .orElse(null);
    }
}
