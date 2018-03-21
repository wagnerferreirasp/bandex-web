package br.com.usp.ime.bandex.restaurant;

import br.com.usp.ime.bandex.util.date.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by wagner on 21/11/16.
 */
public class RestaurantBO {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public boolean isOpen(Restaurant restaurant) {
        return (!isTodayAClosingDate(restaurant)
                && isNowAnOperatingHour(restaurant));
    }

    private boolean isNowAnOperatingHour(Restaurant restaurant) {
        LocalDateTime now = LocalDateTime.now();
        List<OperatingHour> operatingHours = restaurant.getOperatingHours();

        for (OperatingHour operatingHour : operatingHours) {
            List<DayOfWeek> daysOfWeek = operatingHour.getDaysOfWeek();
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
        List<ClosingDate> closingDates = restaurant.getClosingDates();
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

