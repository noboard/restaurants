package com.assessment.restaurants.service;

import com.assessment.restaurants.entity.generated.tables.pojos.Restaurants;
import com.assessment.restaurants.repository.RestaurantsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RestaurantsServiceTests {

    Restaurants restaurantOne = new Restaurants();
    Restaurants restaurantTwo = new Restaurants();
    Restaurants restaurantThree = new Restaurants();

    @BeforeEach
    public void setup(){
        restaurantOne.setGrade("A");
        restaurantOne.setCuisineDescription("Cold food");
        restaurantOne.setDba("Restaurant One");

        restaurantTwo.setGrade("B");
        restaurantTwo.setCuisineDescription("As far from food as you can get");
        restaurantTwo.setDba("Restaurant Two");

        restaurantThree.setGrade("");
        restaurantThree.setCuisineDescription("Italian");
        restaurantThree.setDba("Restaurant Three");


    }

    @Test
    public void testGetAllRestaurantsHandlesNullBeingReturnedByTheDatabase(){

        RestaurantsRepository mockedRestaurantsRepository = mock(RestaurantsRepository.class);
        when(mockedRestaurantsRepository.getAllRestaurants())
                .thenReturn(null);

        RestaurantsService restaurantsService = new RestaurantsService(mockedRestaurantsRepository);
        assertNull(  restaurantsService.getAllRestaurants(), "Expected null to be returned when calling getAllRestaurants()!");
    }

    @Test
    public void testGetAllRestaurantsHandlesReturnsExpectedNumberOfRecords(){

        int expectedNumberOfRecords = 3;

        List<Restaurants> allRestaurants = new ArrayList<>(
                Arrays.asList(restaurantOne, restaurantTwo, restaurantThree)
        );

        RestaurantsRepository mockedRestaurantsRepository = mock(RestaurantsRepository.class);
        when(mockedRestaurantsRepository.getAllRestaurants())
                .thenReturn(allRestaurants);

        RestaurantsService restaurantsService = new RestaurantsService(mockedRestaurantsRepository);
        List<Restaurants> returnedRestaurants = restaurantsService.getAllRestaurants();
        assertEquals(returnedRestaurants.size(), expectedNumberOfRecords  , "Expected " + expectedNumberOfRecords + " to be returned. but " + returnedRestaurants.size() + " was returned instead");
    }

    @Test
    public void testGetRestaurantByGradeHandlesNullBeingReturnedByTheDatabase(){

        RestaurantsRepository mockedRestaurantsRepository = mock(RestaurantsRepository.class);
        when(mockedRestaurantsRepository.getRestaurantByGrade("B"))
                .thenReturn(null);

        RestaurantsService restaurantsService = new RestaurantsService(mockedRestaurantsRepository);
        assertNull(  restaurantsService.getRestaurantsByGrade("B"), "Expected null to be returned when calling getRestaurantByGrade()!");
    }

    @Test
    public void testGetRestaurantsByGradeReturnsExpectedNumberOfRecords(){

        int expectedNumberOfRecords = 2;

        List<Restaurants> allRestaurants = new ArrayList<>(
                Arrays.asList(restaurantOne, restaurantThree)
        );

        RestaurantsRepository mockedRestaurantsRepository = mock(RestaurantsRepository.class);
        when(mockedRestaurantsRepository.getAllRestaurants())
                .thenReturn(allRestaurants);

        RestaurantsService restaurantsService = new RestaurantsService(mockedRestaurantsRepository);
        List<Restaurants> returnedRestaurants = restaurantsService.getAllRestaurants();
        assertEquals(returnedRestaurants.size(), expectedNumberOfRecords  , "Expected " + expectedNumberOfRecords + " to be returned. but " + returnedRestaurants.size() + " was returned instead");
    }

}
