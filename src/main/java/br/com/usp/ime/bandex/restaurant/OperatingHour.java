package br.com.usp.ime.bandex.restaurant;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Class that represents the operating hours of a restaurant.
 */
public class OperatingHour {

    private LocalTime startTime;
    private LocalTime endTime;
    private ArrayList<DayOfWeek> daysOfWeek;

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public ArrayList<DayOfWeek> getDaysOfWeek() {
        return daysOfWeek;
    }

    public OperatingHour(LocalTime startTime, LocalTime endTime, ArrayList<DayOfWeek> daysOfWeek) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.daysOfWeek = daysOfWeek;
    }
}
