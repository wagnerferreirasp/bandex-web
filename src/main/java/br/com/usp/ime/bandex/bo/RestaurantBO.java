package br.com.usp.ime.bandex.bo;

import br.com.usp.ime.bandex.entity.Restaurant;
import br.com.usp.ime.bandex.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wagner on 21/11/16.
 */
public class RestaurantBO {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public boolean isValid(Restaurant restaurant) {
        int maxRestaurantId = restaurantRepository.getMaximumRestaurantId();
        return restaurant.getRestaurantId() >= 0
                && restaurant.getRestaurantId() <= maxRestaurantId;
    }

    public Restaurant get(int restaurantId) {
        return restaurantRepository.get(restaurantId);
    }
}
