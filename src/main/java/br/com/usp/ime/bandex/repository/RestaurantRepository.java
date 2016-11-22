package br.com.usp.ime.bandex.repository;

import br.com.usp.ime.bandex.entity.Restaurant;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by wagner on 21/11/16.
 */
public class RestaurantRepository {

    public int getMaximumRestaurantId() {
        return 5;
    }

    public Restaurant get(int restaurantId) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 3);
        cal.set(Calendar.MINUTE, 1);
        Date abre = cal.getTime();

        cal.set(Calendar.HOUR_OF_DAY, 4);
        cal.set(Calendar.MINUTE, 15);
        Date fecha = cal.getTime();
        return null;
    }
}