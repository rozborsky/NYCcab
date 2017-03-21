package ua.rozborsky.nycCab.classes;

import org.springframework.stereotype.Component;
import ua.rozborsky.nycCab.interfaces.RideValues;

/**
 * Created by roman on 18.03.2017.
 */
@Component
public class RideValuesImpl implements RideValues{
    private int hour;
    private double pickupLatitude;
    private double pickupLongtitude;
    private double dropoffLatitude;
    private double dropoffLongtitude;


    public double getPickupLatitude() {
        return pickupLatitude;
    }

    public void setPickupLatitude(double pickupLatitude) {
        this.pickupLatitude = pickupLatitude;
    }

    public double getPickupLongtitude() {
        return pickupLongtitude;
    }

    public void setPickupLongtitude(double pickupLongtitude) {
        this.pickupLongtitude = pickupLongtitude;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public double getDropoffLatitude() {
        return dropoffLatitude;
    }

    public void setDropoffLatitude(double dropoffLatitude) {
        this.dropoffLatitude = dropoffLatitude;
    }

    public double getDropoffLongtitude() {
        return dropoffLongtitude;
    }

    public void setDropoffLongtitude(double dropoffLongtitude) {
        this.dropoffLongtitude = dropoffLongtitude;
    }
}
