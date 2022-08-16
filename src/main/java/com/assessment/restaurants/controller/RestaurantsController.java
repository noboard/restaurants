package com.assessment.restaurants.controller;

import com.assessment.restaurants.RestaurantsApplication;
import com.assessment.restaurants.entity.generated.tables.pojos.Restaurants;
import com.assessment.restaurants.service.RestaurantsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantsController {

    private final RestaurantsService restaurantsService;
    private final Logger LOGGER= LoggerFactory.getLogger(RestaurantsApplication.class);
    public RestaurantsController(
            @Autowired RestaurantsService restaurantsService
    ){
        this.restaurantsService = restaurantsService;
    }

    @RequestMapping(value="/get-all-restaurants", method= RequestMethod.GET)
    public List<Restaurants> getAllRestaurants() throws Exception {

        //Don't really need to use try catch, as nothing throws an exception
        //But we'll keep it incase the api gets more complex, we need to handle exceptions
        try{
            return restaurantsService.getAllRestaurants();
        }catch(Exception ex){
            LOGGER.error("There was an error retrieving all restaurants records.", ex);
            throw new Exception("General error page being displayed");
        }
    }

    @RequestMapping(value="/get-restaurants-by-grade/{grade}", method= RequestMethod.GET)
    public List<Restaurants> getRestaurantsByGrade(@PathVariable(value="grade") String grade) throws Exception {
        try {
            return restaurantsService.getRestaurantsByGrade(grade);
        }catch(Exception ex){
            LOGGER.error("There was an error retrieving records by grade.", ex);
            throw new Exception("Should tie this in better, but for now we can return the general error page");
        }
    }
}
