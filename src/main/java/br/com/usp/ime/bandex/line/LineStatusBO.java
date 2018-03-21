package br.com.usp.ime.bandex.line;

import br.com.usp.ime.bandex.restaurant.Restaurant;
import br.com.usp.ime.bandex.restaurant.RestaurantBO;
import br.com.usp.ime.bandex.util.exception.InvalidLineException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * BO class of the LineStatus
 */
@Component
public class LineStatusBO {

    public static final int MINIMUM_LINE_STATUS = 0;
    public static final int MAXIMUM_LINE_STATUS = 4;
    
    @Autowired
    private LineStatusRepository lineStatusRepository;

    @Autowired
    private RestaurantBO restaurantBO;

    public boolean isValid(LineStatus lineStatus) {
        Restaurant restaurant = lineStatus.getRestaurant();
        return 
            (lineStatus.getStatus() >= MINIMUM_LINE_STATUS)
            && (lineStatus.getStatus() <= MAXIMUM_LINE_STATUS)
            && restaurantBO.isOpen(restaurant);
    }

    public void insert(LineStatus lineStatus) throws InvalidLineException {
        if (!isValid(lineStatus)) {
            throw new InvalidLineException();
        }
        lineStatusRepository.save(lineStatus);
    }

}
