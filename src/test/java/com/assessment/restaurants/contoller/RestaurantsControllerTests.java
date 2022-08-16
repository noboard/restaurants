package com.assessment.restaurants.contoller;

import com.assessment.restaurants.controller.RestaurantsController;
import com.assessment.restaurants.entity.generated.tables.pojos.Restaurants;
import com.assessment.restaurants.service.RestaurantsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestaurantsController.class)
public class RestaurantsControllerTests {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    RestaurantsService restaurantsService;

    Restaurants restaurantOne = new Restaurants();
    Restaurants restaurantTwo = new Restaurants();
    Restaurants restaurantThree = new Restaurants();

    @BeforeEach
    public void setup(){
        //Pre-fill some restaurant data
        //we don't need all of it
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
    public void testGetAllRestaurantsReturnsAllRestaurants() throws Exception {
        int expectedNumberOfRestaurants = 3;
        List<Restaurants> allRestaurants = new ArrayList<>(
                Arrays.asList(restaurantOne, restaurantTwo, restaurantThree)
        );

        Mockito.when(restaurantsService.getAllRestaurants())
                .thenReturn(allRestaurants);

        mockMvc.perform( MockMvcRequestBuilders
                        .get("/api/get-all-restaurants")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$", hasSize(expectedNumberOfRestaurants))
        );
    }

    @Test
    public void testGetAllRestaurantsReturnsCorrectRestaurantName() throws Exception {
        String expectedRestaurantName = "Restaurant One";
        List<Restaurants> allRestaurants = new ArrayList<>(
                Arrays.asList(restaurantOne, restaurantTwo, restaurantThree)
        );

        Mockito.when(restaurantsService.getAllRestaurants())
                .thenReturn(allRestaurants);

        mockMvc.perform( MockMvcRequestBuilders
                        .get("/api/get-all-restaurants")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$[0].dba", is(expectedRestaurantName) )
        );
    }

    @Test
    public void testGetAllRestaurantsHandlesNoDataBeingReturned() throws Exception {

        List<Restaurants> allRestaurants = new ArrayList<>();

        Mockito.when(restaurantsService.getAllRestaurants())
                .thenReturn(allRestaurants);

        mockMvc.perform( MockMvcRequestBuilders
                        .get("/api/get-all-restaurants")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk()
                );
    }

    @Test
    public void testGetRestaurantsByGradeReturns404WhenNoGradeEntered() throws Exception {

        Mockito.when(restaurantsService.getAllRestaurants())
                .thenReturn(null);

        mockMvc.perform( MockMvcRequestBuilders
                        .get("/api/get-restaurants-by-grade")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()
                );
    }

    @Test
    public void testGetRestaurantsByGradeReturnsTwoRecords() throws Exception {

        int expectedNumberOfRestaurants = 2;

        List<Restaurants> twoRestaurants = new ArrayList<>(
                Arrays.asList(restaurantTwo, restaurantThree)
        );

        Mockito.when(restaurantsService.getRestaurantsByGrade("A"))
                .thenReturn(twoRestaurants);

        mockMvc.perform( MockMvcRequestBuilders
                        .get("/api/get-restaurants-by-grade/A")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(expectedNumberOfRestaurants))
        );
    }

    @Test
    public void testGetRestaurantsByGradeHandlesNoRecordsBeingReturned() throws Exception {

        Mockito.when(restaurantsService.getRestaurantsByGrade("none"))
                .thenReturn(null);

        mockMvc.perform( MockMvcRequestBuilders
                        .get("/api/get-restaurants-by-grade/none")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()
                );
    }
}
