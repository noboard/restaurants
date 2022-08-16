package com.assessment.restaurants.repository;

import com.assessment.restaurants.entity.generated.tables.pojos.Restaurants;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.assessment.restaurants.entity.generated.Tables.RESTAURANTS;

@Repository
public class RestaurantsRepository {

    DSLContext dslContext;

    public RestaurantsRepository(
            @Autowired DSLContext dslContext
            ){
        this.dslContext = dslContext;
    }

    public List<Restaurants> getAllRestaurants()  {
         return dslContext.selectFrom(RESTAURANTS)
                   .fetchInto(Restaurants.class);
     }

    public List<Restaurants> getRestaurantByGrade(String grade) {
        return dslContext.selectFrom(RESTAURANTS)
                    .where(RESTAURANTS.GRADE.equalIgnoreCase(grade))
                    .fetchInto(Restaurants.class);
    }
}
