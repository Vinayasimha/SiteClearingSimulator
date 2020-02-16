/**
 *
 */
package demo.siteClearingSimulator.data;

/**
 * @author Vinayasimha Patil
 *
 */
public class SiteSquare {
    private LandType landType;
    private boolean cleared;

    public SiteSquare(LandType landType) {
        this.landType = landType;
    }

    public static SiteSquare buildSiteSquare(char landTypeCode) {
        return new SiteSquare(LandType.getLandType(landTypeCode));
    }

    public LandType getLandType() {
        return landType;
    }

    public void setLandType(LandType landType) {
        this.landType = landType;
    }

    public boolean isCleared() {
        return cleared;
    }

    public void setCleared(boolean cleared) {
        this.cleared = cleared;
    }

    @Override
    public String toString() {
        return landType.getLandTypeCode() + " ";
    }
}
