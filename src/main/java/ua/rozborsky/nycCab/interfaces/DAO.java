package ua.rozborsky.nycCab.interfaces;

import ua.rozborsky.nycCab.classes.TaxiRide;

import java.util.List;

/**
 * Created by roman on 17.03.2017.
 */
public interface DAO {
    void fillTable();
    List<TaxiRide> getTrips(double pickupLatitude, double pickupLongtitude);
}
