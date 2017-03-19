package ua.rozborsky.nycCab.classes;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.rozborsky.nycCab.interfaces.DAO;
import ua.rozborsky.nycCab.server.HibernateUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by roman on 17.03.2017.
 */
@Component
public class DAOpostgreSQL implements DAO{
    static SessionFactory sessionFactory = null;
    static{
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Autowired
    TaxiRide taxiRide;

    @Autowired
    CopyDataFromCsv copyDataFromCsv;

    public DAOpostgreSQL(){

    }

    private void writeTripsToDB(String fileName) {
        List <String> rowValues;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine();                                                         //skip row with names of columns
            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                rowValues = new ArrayList<>(Arrays.asList(currentLine.split(",")));
                initTaxiRide(taxiRide, rowValues);
                writeToDB(taxiRide);
            }
        } catch (IOException e) {
            e.printStackTrace();//todo log4j
        }
    }


    private void initTaxiRide(TaxiRide taxiRide, List <String> rowValues){
        taxiRide.setMedallion(rowValues.get(0));
        taxiRide.setHackLicense(rowValues.get(1));
        taxiRide.setVendorId(rowValues.get(2));
        try{
            taxiRide.setRateCode(Byte.valueOf(rowValues.get(3)));
        }catch (NumberFormatException e){
            taxiRide.setRateCode((byte) -1);
        }
        try{
             taxiRide.setStoreAndFwdFlag(rowValues.get(4).charAt(0));
        } catch (StringIndexOutOfBoundsException e){
            taxiRide.setStoreAndFwdFlag(' ');
        }
        taxiRide.setPickupDatetime(rowValues.get(5));
        taxiRide.setDropoffDatetime(rowValues.get(6));
        try{
            taxiRide.setPassengerCount(Byte.valueOf(rowValues.get(7)));
        }catch (NumberFormatException e){
            taxiRide.setPassengerCount((byte) -1);
        }
        try{
            taxiRide.setTripTimeInSecs(Short.valueOf(rowValues.get(8)));
        }catch (NumberFormatException e){
            taxiRide.setTripTimeInSecs((short) -1);
        }
        try{
            taxiRide.setTripDistanse(Double.valueOf(rowValues.get(9)));
        }catch (NumberFormatException e){
            taxiRide.setTripDistanse((double) -1);
        }
        try{
            taxiRide.setPickupLongtitude(Double.valueOf(rowValues.get(10)));
            taxiRide.setPickupLatitude(Double.valueOf(rowValues.get(11)));
        }catch (NumberFormatException e){
            taxiRide.setPickupLongtitude(-74);                            //todo NYC coordinates properties
            taxiRide.setPickupLatitude(40.71);
        }
        try{
            taxiRide.setDropoffLongtitude(Double.valueOf(rowValues.get(12)));
            taxiRide.setDropoffLatitude(Double.valueOf(rowValues.get(13)));
        }catch (NumberFormatException e){
            taxiRide.setDropoffLongtitude(-74);                           //todo NYC coordinates properties
            taxiRide.setDropoffLatitude(40.71);
        }
    }


    private void writeToDB(TaxiRide taxiRide){
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(taxiRide);
            session.getTransaction().commit();
        } catch (SessionException e) {
            e.printStackTrace();//todo log4j
        }
    }


    public void fillTable() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select count(*) from TaxiRide");//todo tablename properties-----------
        Long numberRows = ((Long) query.iterate().next()).longValue();

        if(numberRows == 0){
            if(!(new File("trip_data.csv")).exists()) {
                copyDataFromCsv.make("trip_data_1.csv", "trip_data.csv", 100000);
            }
            writeTripsToDB("trip_data.csv"); //todo filename properties-----------
        }
    }
}
