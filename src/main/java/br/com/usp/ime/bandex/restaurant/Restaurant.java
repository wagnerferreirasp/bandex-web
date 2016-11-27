package br.com.usp.ime.bandex.restaurant;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Class to represent the restaurant.
 */
public class Restaurant {

    private int restaurantId;
    private List<OperatingHour> operatingHours;
    private List<ClosingDate> closingDates;

    public Restaurant(int restaurantId,
                      @NotNull List<OperatingHour> operatingHours,
                      @NotNull List<ClosingDate> closingDates) {
        this.restaurantId = restaurantId;
        this.operatingHours = operatingHours;
        this.closingDates = closingDates;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public List<OperatingHour> getOperatingHours() {
        return operatingHours;
    }

    public List<ClosingDate> getClosingDates() {
        return closingDates;
    }
}