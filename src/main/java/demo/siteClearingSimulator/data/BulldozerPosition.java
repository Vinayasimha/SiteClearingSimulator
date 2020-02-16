/**
 *
 */
package demo.siteClearingSimulator.data;

/**
 * @author Vinayasimha Patil
 *
 */
public class BulldozerPosition {
    private int latitude;
    private int longitude;
    private BulldozerDirection bulldozerDirection;

    public BulldozerPosition(int latitude, int longitude, BulldozerDirection bulldozerDirection) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.bulldozerDirection = bulldozerDirection;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public BulldozerDirection getBulldozerDirection() {
        return bulldozerDirection;
    }

    public void setBulldozerDirection(BulldozerDirection bulldozerDirection) {
        this.bulldozerDirection = bulldozerDirection;
    }
}
