package ua.rozborsky.nycCab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.rozborsky.nycCab.classes.RideValuesImpl;
import ua.rozborsky.nycCab.interfaces.DAO;
import ua.rozborsky.nycCab.interfaces.RideValues;

/**
 * Created by roman on 15.03.2017.
 */
@Controller
public class MainController {

    @Autowired
    DAO dao;

    @Autowired
    RideValues rideValues;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        dao.fillTable();

        return new ModelAndView("home", "rideValues", rideValues);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView setCoordinates(@ModelAttribute("userForm") RideValuesImpl rideValues) {
        System.out.println(rideValues.getLatitude()+"------------------------");
        System.out.println(rideValues.getLongitude()+"------------------------");
        System.out.println(rideValues.getStart()+"------------------------");
        System.out.println(rideValues.getFinish()+"------------------------");
        return new ModelAndView("home", "rideValues", rideValues);
    }
}