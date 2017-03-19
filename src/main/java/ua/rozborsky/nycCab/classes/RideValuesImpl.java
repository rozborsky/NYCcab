package ua.rozborsky.nycCab.classes;

import org.springframework.stereotype.Component;
import ua.rozborsky.nycCab.interfaces.RideValues;

/**
 * Created by roman on 18.03.2017.
 */
@Component
public class RideValuesImpl implements RideValues{
    private int start;
    private int finish;
    private double latitude;
    private double longitude;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
