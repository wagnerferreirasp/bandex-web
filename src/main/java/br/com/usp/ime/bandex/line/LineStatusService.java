package br.com.usp.ime.bandex.line;

import br.com.usp.ime.bandex.restaurant.Restaurant;
import br.com.usp.ime.bandex.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

/**
 * Service class of the LineStatus
 */
@Component
public class LineStatusService {
    private final String NOT_OPEN_RESTAURANT = "Não foi possível inserir o status da fila, pois o restaurante %s não está aberto";

    @Autowired
    LineStatusRepository lineStatusRepository;
    @Autowired
    RestaurantService restaurantService;

    public void save(LineStatusDTO lineStatusDTO) {
        LineStatus lineStatus = new LineStatus.LineStatusBuilder()
                .restaurant(restaurantService.findById(lineStatusDTO.getRestaurantId()))
                .status(lineStatusDTO.getStatus())
                .build();
        Restaurant restaurant = lineStatus.getRestaurant();
        Assert.isTrue(
                restaurant.isOpen(LocalDateTime.now()),
                String.format(NOT_OPEN_RESTAURANT, restaurant.getName())
        );
        lineStatusRepository.save(lineStatus);
    }

}
