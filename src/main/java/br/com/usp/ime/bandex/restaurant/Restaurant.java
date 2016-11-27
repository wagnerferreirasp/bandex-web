package br.com.usp.ime.bandex.restaurant;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

/**
 * Class to represent the restaurant.
 */
public class Restaurant {

    private int restaurantId;
    private ArrayList<OperatingHour> operatingHours;
    private ArrayList<ClosingDate> closingDates;

    public Restaurant(int restaurantId,
                      @NotNull ArrayList<OperatingHour> operatingHours,
                      @NotNull ArrayList<ClosingDate> closingDates) {
        this.restaurantId = restaurantId;
        this.operatingHours = operatingHours;
        this.closingDates = closingDates;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public ArrayList<OperatingHour> getOperatingHours() {
        return operatingHours;
    }

    public ArrayList<ClosingDate> getClosingDates() {
        return closingDates;
    }
}