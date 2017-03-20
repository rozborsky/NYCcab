package ua.rozborsky.nycCab.interfaces;

/**
 * Created by roman on 18.03.2017.
 */
public interface RideValues {
    double getPickupLatitude();

    void setPickupLatitude(double pickupLatitude);

    double getPickupLongtitude();

    void setPickupLongtitude(double pickupLongtitude);

    int getStart();

    void setStart(int start);

    int getFinish();

    void setFinish(int finish);

    double getDropoffLatitude();

    void setDropoffLatitude(double dropoffLatitude);

    double getDropoffLongtitude();

    void setDropoffLongtitude(double dropoffLongtitude);
}
