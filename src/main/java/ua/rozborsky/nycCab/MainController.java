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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by roman on 15.03.2017.
 */
@Controller
public class MainController {

    @Autowired
    DAO dao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView setCoordinates(@ModelAttribute("rideValues") RideValuesImpl rideValuesImpl) {
        System.out.println(rideValuesImpl.isStart() + "rideValuesImpl.isStart()");
        System.out.println(rideValuesImpl.getHour() + "rideValuesImpl.isStart()");
        System.out.println(rideValuesImpl.getPickupLatitude() + "rideValuesImpl.isStart()");
        dao.fillTable();
        List <TaxiRide>listTrips;
        if(rideValuesImpl.isStart()) {
            listTrips = dao.getTripsStart(
                    rideValuesImpl.getPickupLatitude(),
                    rideValuesImpl.getPickupLongtitude(),
                    rideValuesImpl.getHour());
        } else {
            listTrips = dao.getTripsFinish(
                    rideValuesImpl.getDropoffLatitude(),
                    rideValuesImpl.getPickupLongtitude(),
                    rideValuesImpl.getHour());
        }

        Map districts = tripsToDistrict(listTrips, rideValuesImpl.isStart());
        System.out.println(districts.get("brooklyn") + " brooklyn");
        System.out.println(districts.get("manhattan") + " manhattan");
        System.out.println(districts.get("queens") + " queens");
        System.out.println(districts.get("bronx") + " bronx");
        System.out.println(districts.get("statenIsland") + " statenIsland");

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("rideValues", rideValuesImpl);
        int[] hours = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        modelAndView.addObject("hours", hours);
        modelAndView.addObject("listTrips", listTrips);
        modelAndView.addObject("districts", districts);

        return modelAndView;
    }

    private Map<String, Float> tripsToDistrict(List <TaxiRide>listTrips, boolean isStart){
        int brooklyn = 0;
        int manhattan = 0;
        int queens = 0;
        int bronx = 0;
        int statenIsland = 0;

        double longtitude;
        double latitude;
        for (int i = 0; i < listTrips.size(); i++) {
            if (isStart) {
                longtitude = listTrips.get(i).getDropoffLongtitude();
                latitude = listTrips.get(i).getDropoffLatitude();
            } else {
                longtitude = listTrips.get(i).getPickupLongtitude();
                latitude = listTrips.get(i).getPickupLongtitude();
            }

            if ((longtitude < -74.05) && (longtitude > -74.24) && (latitude < 40.65) && (latitude > 40.5)){
                statenIsland++;
            } else if (((longtitude < -74.04) && (longtitude > -74.85) && (latitude < 40.69) && (latitude > 40.57))
                    || ((longtitude < -73.91) && (longtitude > -73.97) && (latitude < 40.74) && (latitude > 40.69))){
                brooklyn++;
            }else if (((longtitude < -73.96) && (longtitude > -74.02) && (latitude < 40.77) && (latitude > 40.7))
                    || ((longtitude < -73.92) && (longtitude > -73.98) && (latitude < 40.9) && (latitude > 40.77))){
                manhattan++;
            }else if (((longtitude < -73.71) && (longtitude > -73.87) && (latitude < 40.8) && (latitude > 40.57))
                    || ((longtitude < -73.87) && (longtitude > -73.95) && (latitude < 40.78) && (latitude > 40.69))){
                queens++;
            }else if ((longtitude < -73.76) && (longtitude > -73.92) && (latitude < 40.93) && (latitude > 40.8)){
                bronx++;
            }
        }

        int summ = bronx + brooklyn + manhattan + queens + statenIsland;
        summ = (summ > 0 ? summ : 1);
        Map <String, Float> districts = new HashMap<>();
        districts.put("brooklyn",  ((float)brooklyn / summ));
        districts.put("manhattan", ((float)manhattan / summ));
        districts.put("queens",  ((float)queens / summ));
        districts.put("bronx",  ((float)bronx / summ));
        districts.put("statenIsland",  ((float)statenIsland / summ));

        return districts;
    }
}
