package ua.rozborsky.nycCab.interfaces;

/**
 * Created by roman on 18.03.2017.
 */
public interface RideValues {
    boolean isStart();

    void setStart(boolean start);

    double getPickupLatitude();

    void setPickupLatitude(double pickupLatitude);

    double getPickupLongtitude();

    void setPickupLongtitude(double pickupLongtitude);

    int getHour();

    void setHour(int hour);

    double getDropoffLatitude();

    void setDropoffLatitude(double dropoffLatitude);

    double getDropoffLongtitude();

    void setDropoffLongtitude(double dropoffLongtitude);
}
