package br.com.usp.ime.bandex.controller;

import br.com.usp.ime.bandex.bo.LineBO;
import br.com.usp.ime.bandex.bo.RestaurantBO;
import br.com.usp.ime.bandex.entity.Line;
import br.com.usp.ime.bandex.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * The LineController
 */

@RestController
public class LineController {

    @Autowired
    private LineBO lineBO;

    @Autowired
    private RestaurantBO restaurantBO;

    @RequestMapping(value = "post_line_status", method = RequestMethod.POST)
    public ResponseEntity<Line> sendLine(@RequestParam(value = "status") int status, @RequestParam(value = "restaurant_id") int restaurantId) {
        Restaurant restaurant = restaurantBO.get(restaurantId);
        Line line = new Line(status, Calendar.getInstance().getTime(), restaurant);
        try {
            lineBO.insert(line);
        } catch (Exception e) {
            return new ResponseEntity<>(line, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(line, HttpStatus.CREATED);
    }
}
