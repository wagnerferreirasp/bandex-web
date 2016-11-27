package br.com.usp.ime.bandex.restaurant;

import br.com.usp.ime.bandex.util.date.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by wagner on 21/11/16.
 */
public class RestaurantBO {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public boolean isValid(Restaurant restaurant) {
        int maxRestaurantId = restaurantRepository.getMaximumRestaurantId();
        return restaurant.getRestaurantId() >= 0
                && restaurant.getRestaurantId() <= maxRestaurantId;
    }

    public boolean isOpen(Restaurant restaurant) {
        return (!isTodayAClosingDate(restaurant)
                && isNowAnOperatingHour(restaurant));
    }

    private boolean isNowAnOperatingHour(Restaurant restaurant) {
        LocalDateTime now = LocalDateTime.now();
        ArrayList<OperatingHour> operatingHours = restaurant.getOperatingHours();

        for (OperatingHour operatingHour : operatingHours) {
            ArrayList<DayOfWeek> daysOfWeek = operatingHour.getDaysOfWeek();
            if (daysOfWeek.contains(now.getDayOfWeek())) {
                LocalDateTime opening = DateHelper.getTodayWithTime(operatingHour.getStartTime());
                LocalDateTime closing = DateHelper.getTodayWithTime(operatingHour.getEndTime());
                if (DateHelper.isDateTimeBetween(LocalDateTime.now(), opening, closing)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isTodayAClosingDate(Restaurant restaurant) {
        ArrayList<ClosingDate> closingDates = restaurant.getClosingDates();
        LocalDate today = LocalDate.now();

        for (ClosingDate closingDate : closingDates) {
            if (today.equals(closingDate.getDate())) {
                return true;
            }
        }
        return false;
    }

    public Restaurant get(int restaurantId) {
        return restaurantRepository.get(restaurantId);
    }
}

