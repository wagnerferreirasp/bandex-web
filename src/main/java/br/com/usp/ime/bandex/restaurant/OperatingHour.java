package br.com.usp.ime.bandex.restaurant;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

/**
 * Class that represents the operating hours of a restaurant.
 */
public class OperatingHour {

    private LocalTime startTime;
    private LocalTime endTime;
    private List<DayOfWeek> daysOfWeek;

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public List<DayOfWeek> getDaysOfWeek() {
        return daysOfWeek;
    }

    public OperatingHour(LocalTime startTime, LocalTime endTime, List<DayOfWeek> daysOfWeek) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.daysOfWeek = daysOfWeek;
    }
}
