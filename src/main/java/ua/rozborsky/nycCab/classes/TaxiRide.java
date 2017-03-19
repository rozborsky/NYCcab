package ua.rozborsky.nycCab.classes;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by roman on 17.03.2017.
 */
@Entity
@Table(name = "taxi_ride")
@Component
public class TaxiRide {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "medallion")
    private String medallion;

    @Column(name = "hack_license")
    private String hackLicense;

    @Column(name = "vendor_id")
    private String vendorId;

    @Column(name = "rate_code")
    private byte rateCode;

    @Column(name = "store_and_fwd_flag")
    private char storeAndFwdFlag;

    @Column(name = "pickup_datetime")
    private String pickupDatetime;

    @Column(name = "dropoff_datetime")
    private String dropoffDatetime;

    @Column(name = "passenger_count")
    private byte passengerCount;

    @Column(name = "trip_time_in_secs")
    private short tripTimeInSecs;

    @Column(name = "trip_distanse")
    private double tripDistanse;

    @Column(name = "pickup_longtitude")
    private double pickupLongtitude;

    @Column(name = "pickup_latitude")
    private double pickupLatitude;

    @Column(name = "dropoff_longtitude")
    private double dropoffLongtitude;

    @Column(name = "dropoff_latitude")
    private double dropoffLatitude;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedallion() {
        return medallion;
    }

    public void setMedallion(String medallion) {
        this.medallion = medallion;
    }

    public String getHackLicense() {
        return hackLicense;
    }

    public void setHackLicense(String hackLicense) {
        this.hackLicense = hackLicense;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public byte getRateCode() {
        return rateCode;
    }

    public void setRateCode(byte rateCode) {
        this.rateCode = rateCode;
    }

    public char getStoreAndFwdFlag() {
        return storeAndFwdFlag;
    }

    public void setStoreAndFwdFlag(char storeAndFwdFlag) {
        this.storeAndFwdFlag = storeAndFwdFlag;
    }

    public String getPickupDatetime() {
        return pickupDatetime;
    }

    public void setPickupDatetime(String pickupDatetime) {
        this.pickupDatetime = pickupDatetime;
    }

    public String getDropoffDatetime() {
        return dropoffDatetime;
    }

    public void setDropoffDatetime(String dropoffDatetime) {
        this.dropoffDatetime = dropoffDatetime;
    }

    public byte getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(byte passengerCount) {
        this.passengerCount = passengerCount;
    }

    public short getTripTimeInSecs() {
        return tripTimeInSecs;
    }

    public void setTripTimeInSecs(short tripTimeInSecs) {
        this.tripTimeInSecs = tripTimeInSecs;
    }

    public double getTripDistanse() {
        return tripDistanse;
    }

    public void setTripDistanse(double tripDistanse) {
        this.tripDistanse = tripDistanse;
    }

    public double getPickupLongtitude() {
        return pickupLongtitude;
    }

    public void setPickupLongtitude(double pickupLongtitude) {
        this.pickupLongtitude = pickupLongtitude;
    }

    public double getPickupLatitude() {
        return pickupLatitude;
    }

    public void setPickupLatitude(double pickupLatitude) {
        this.pickupLatitude = pickupLatitude;
    }

    public double getDropoffLongtitude() {
        return dropoffLongtitude;
    }

    public void setDropoffLongtitude(double dropoffLongtitude) {
        this.dropoffLongtitude = dropoffLongtitude;
    }

    public double getDropoffLatitude() {
        return dropoffLatitude;
    }

    public void setDropoffLatitude(double dropoffLatitude) {
        this.dropoffLatitude = dropoffLatitude;
    }
}
