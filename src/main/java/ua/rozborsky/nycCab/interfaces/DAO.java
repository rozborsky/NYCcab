package ua.rozborsky.nycCab.interfaces;

import ua.rozborsky.nycCab.classes.TaxiRide;

import java.util.List;

/**
 * Created by roman on 17.03.2017.
 */
public interface DAO {
    void fillTable();
    List<TaxiRide> getTripsStart(double pickupLatitude, double pickupLongtitude, int hour);
    List<TaxiRide> getTripsFinish(double pickupLatitude, double pickupLongtitude, int hour);
}
