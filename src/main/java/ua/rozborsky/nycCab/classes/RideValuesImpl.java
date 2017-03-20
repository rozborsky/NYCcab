package ua.rozborsky.nycCab.classes;

import org.springframework.stereotype.Component;

/**
 * Created by roman on 18.03.2017.
 */
@Component
public class RideValuesImpl {
    private int start;
    private int finish;
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
