package br.com.usp.ime.bandex.entity;

import java.util.ArrayList;

/**
 * Class to represent the restaurant.
 */
public class Restaurant {

    private int restaurantId;
    private OperatingHours lunchHours, dinnerHours;
    private ArrayList<ClosingDate> closingDates;

    public Restaurant(int restaurantId, OperatingHours lunch, OperatingHours dinnerHours, ArrayList<ClosingDate> closingDates) {
        this.restaurantId = restaurantId;
        this.lunchHours = lunch;
        this.dinnerHours = dinnerHours;
        this.closingDates = closingDates;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public OperatingHours getLunchHours() {
        return lunchHours;
    }

    public OperatingHours getDinnerHours() {
        return dinnerHours;
    }

    public ArrayList<ClosingDate> getClosingDates() {
        return closingDates;
    }
}