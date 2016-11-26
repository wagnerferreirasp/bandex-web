package br.com.usp.ime.bandex.line;

import br.com.usp.ime.bandex.restaurant.Restaurant;

import java.util.Date;

/**
 * Class to represent the line status of a restaurant.
 */
public class LineStatus {
    private int status;
    private Date time;
    private Restaurant restaurant;

    public LineStatus(int status, Date time, Restaurant restaurant) {
        this.status = status;
        this.time = time;
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public int getStatus() {
        return status;
    }

    public Date getTime() {
        return time;
    }

    @Override
    public String toString() {
        return super.toString()
            + "["
                + "status=" + status
                + ", restaurantId=" + restaurant.getRestaurantId()
                + ", time=" + time
            + "]";
    }
}
