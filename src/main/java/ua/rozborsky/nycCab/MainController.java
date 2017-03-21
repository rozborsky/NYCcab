package ua.rozborsky.nycCab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.rozborsky.nycCab.classes.RideValuesImpl;
import ua.rozborsky.nycCab.classes.TaxiRide;
import ua.rozborsky.nycCab.interfaces.DAO;
import ua.rozborsky.nycCab.interfaces.RideValues;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Created by roman on 15.03.2017.
 */
@Controller
public class MainController {

    @Autowired
    DAO dao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView setCoordinates(@ModelAttribute("rideValues") RideValuesImpl rideValuesImpl) {dao.fillTable();
        List listTrips = dao.getTrips(rideValuesImpl.getPickupLatitude(), rideValuesImpl.getPickupLongtitude());
        dropoffCoordinates(listTrips, rideValuesImpl);

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("rideValues", rideValuesImpl);
        modelAndView.addObject("rideValues", rideValuesImpl);
        int[] hours = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        modelAndView.addObject("rideValues", rideValuesImpl);
        modelAndView.addObject("hours", hours);
        return modelAndView;
    }

    private RideValues dropoffCoordinates(List list, RideValues rideValues) {
        double latitude = 0;
        double longtitude = 0;
        double tmplatitude;
        double tmplongtitude;
        int j = 0;

        for (int i = 0; i < list.size(); i++) {
            tmplatitude = ((TaxiRide)list.get(i)).getDropoffLatitude();
            tmplongtitude = ((TaxiRide)list.get(i)).getDropoffLongtitude();
            if(tmplatitude > 40.5 && tmplatitude < 40.75 && tmplongtitude < -73.88 && tmplongtitude > -74.24){ //ignore wrong coordinates
                latitude += tmplatitude;
                longtitude += tmplongtitude;
                j++;
            }
        }

        latitude /= j;
        longtitude /= j;
        try{
            latitude = new BigDecimal(latitude).setScale(3, RoundingMode.UP).doubleValue();
            longtitude = new BigDecimal(longtitude).setScale(3, RoundingMode.UP).doubleValue();
        }catch (NumberFormatException e){
            latitude = 0;
            longtitude = 0;
        }

        rideValues.setDropoffLatitude(latitude);
        rideValues.setDropoffLongtitude(longtitude);

        return rideValues;
    }
}