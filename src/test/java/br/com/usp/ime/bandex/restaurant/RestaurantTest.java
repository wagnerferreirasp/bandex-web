package br.com.usp.ime.bandex.restaurant;

import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.NotNull;
import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RestaurantTest {
    Restaurant restaurant;

    @Before
    public void setUp() {
        @NotNull List<ClosingDate> closingDates = new ArrayList<>();
        closingDates.add(new ClosingDate(null,
                LocalDate.of(2018, Month.DECEMBER, 30)));
        @NotNull List<OperatingHour> operatingHours = Arrays.asList(
                getDefaultLunchHours(),
                getDefaultDinnerHours(),
                getDefaultWkdLunchHours(),
                getDefaultWkdDinnerHours()
        );
        restaurant = new Restaurant.RestaurantBuilder()
                .closingDates(closingDates)
                .operatingHours(operatingHours)
                .build();
    }

    private OperatingHour getDefaultWkdDinnerHours() {
        return new OperatingHour.OperatingHourBuilder()
                .startTime(LocalTime.of(17,40))
                .endTime(LocalTime.of(19,55))
                .daysOfWeek(Collections.singletonList(
                        DayOfWeek.SATURDAY
                ))
                .build();
    }

    private OperatingHour getDefaultWkdLunchHours() {
        return new OperatingHour.OperatingHourBuilder()
                .startTime(LocalTime.of(11,45))
                .endTime(LocalTime.of(14,0))
                .daysOfWeek(Arrays.asList(
                        DayOfWeek.SATURDAY,
                        DayOfWeek.SUNDAY
                ))
                .build();
    }

    private OperatingHour getDefaultDinnerHours() {
        return new OperatingHour.OperatingHourBuilder()
                .startTime(LocalTime.of(17,30))
                .endTime(LocalTime.of(20,0))
                .daysOfWeek(Arrays.asList(
                        DayOfWeek.MONDAY,
                        DayOfWeek.TUESDAY,
                        DayOfWeek.WEDNESDAY,
                        DayOfWeek.THURSDAY,
                        DayOfWeek.FRIDAY
                ))
                .build();
    }

    private OperatingHour getDefaultLunchHours() {
        return new OperatingHour.OperatingHourBuilder()
                .startTime(LocalTime.of(11,40))
                .endTime(LocalTime.of(14,10))
                .daysOfWeek(Arrays.asList(
                        DayOfWeek.MONDAY,
                        DayOfWeek.TUESDAY,
                        DayOfWeek.WEDNESDAY,
                        DayOfWeek.THURSDAY,
                        DayOfWeek.FRIDAY
                ))
                .build();
    }

    @Test
    public void testIsOpen() {
        assertFalse(restaurant.isOpen(
                LocalDateTime.of(
                        2018, Month.DECEMBER, 30,
                        12, 0, 0)));
        assertTrue(restaurant.isOpen(
                LocalDateTime.of(
                        2018, Month.DECEMBER, 31,
                        12, 0, 0)));
        assertFalse(restaurant.isOpen(
                LocalDateTime.of(
                        2018, Month.DECEMBER, 31,
                        21, 0, 0)));
    }
}