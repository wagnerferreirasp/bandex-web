package br.com.usp.ime.bandex.line;

import br.com.usp.ime.bandex.restaurant.RestaurantBO;
import br.com.usp.ime.bandex.restaurant.Restaurant;
import br.com.usp.ime.bandex.util.exception.InvalidLineException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * The LineStatusController
 */

@RestController
public class LineStatusController {

    @Autowired
    private LineStatusBO lineStatusBO;

    @Autowired
    private RestaurantBO restaurantBO;

    @RequestMapping(value = "post_line_status", method = RequestMethod.POST)
    public ResponseEntity<LineStatus> sendLine(@RequestParam(value = "status") int status,
                                               @RequestParam(value = "restaurant_id") int restaurantId) {
        Restaurant restaurant = restaurantBO.get(restaurantId);
        LineStatus lineStatus = new LineStatus(status, Calendar.getInstance().getTime(), restaurant);
        try {
            lineStatusBO.insert(lineStatus);
        } catch (InvalidLineException e) {
            return new ResponseEntity<>(lineStatus, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(lineStatus, HttpStatus.CREATED);
    }
}
