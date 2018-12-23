package br.com.usp.ime.bandex.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * Created by wagner on 21/11/16.
 */
@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant findById(Long restaurantId) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantId);
        Assert.isTrue(optionalRestaurant.isPresent(), "Restaurante não encontrado");
        return optionalRestaurant.get();
    }
}

