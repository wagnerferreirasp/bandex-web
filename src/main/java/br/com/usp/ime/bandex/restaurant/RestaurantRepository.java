package br.com.usp.ime.bandex.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;

/**
 * Created by wagner on 21/11/16.
 */
public class RestaurantRepository implements Repository<Restaurant, Long> {

    @Autowired
    private Restaurant restaurant;

    public Restaurant get(int restaurantId) {
        return restaurant;
    }
}
