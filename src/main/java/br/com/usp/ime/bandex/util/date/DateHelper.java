package br.com.usp.ime.bandex.util.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by wagner on 26/11/16.
 */
public class DateHelper {

    public static LocalDateTime getTodayWithTime(LocalTime localTime) {
        return LocalDateTime.of(LocalDate.now(), localTime);
    }

    public static boolean isDateTimeBetween(LocalDateTime date, LocalDateTime d1, LocalDateTime d2) {
        return d1.isEqual(date)
                || d2.equals(date)
                || (d1.isBefore(date)
                && date.isBefore(d2));
    }
}