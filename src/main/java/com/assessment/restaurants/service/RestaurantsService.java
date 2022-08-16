package com.assessment.restaurants.service;

import com.assessment.restaurants.entity.generated.tables.pojos.Restaurants;
import com.assessment.restaurants.repository.RestaurantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantsService {

    private final RestaurantsRepository restaurantsRepository;

    public RestaurantsService(
            @Autowired RestaurantsRepository restaurantsRepository
    ){
        this.restaurantsRepository = restaurantsRepository;
    }

    public List<Restaurants> getAllRestaurants() {
        return restaurantsRepository.getAllRestaurants();
    }

    public List<Restaurants> getRestaurantsByGrade(String grade) {
            return restaurantsRepository.getRestaurantByGrade(grade);
    }

}
