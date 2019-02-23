package br.com.usp.ime.bandex.restaurant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Class to represent the restaurant.
 */
@Getter
@AllArgsConstructor
@Builder
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull private Long restaurantId;
    @OneToMany
    @NotNull private List<OperatingHour> operatingHours;
    @OneToMany
    @NotNull private List<ClosingDate> closingDates;
    @NotNull private String name;

    public boolean isOpen(LocalDateTime date) {
        return !isThatAClosingDate(date.toLocalDate()) && isThatAnOperatingHour(date);
    }

    private boolean isThatAnOperatingHour(LocalDateTime localDateTime) {
        for (OperatingHour operatingHour : this.getOperatingHours()) {
            List<DayOfWeek> daysOfWeek = operatingHour.getDaysOfWeek();
            if (daysOfWeek.contains(localDateTime.getDayOfWeek())) {
                LocalDateTime opening = LocalDateTime.of(
                        localDateTime.toLocalDate(),
                        operatingHour.getStartTime()
                );
                LocalDateTime closing = LocalDateTime.of(
                        localDateTime.toLocalDate(),
                        operatingHour.getEndTime()
                );

                if (localDateTime.isAfter(opening)
                        && localDateTime.isBefore(closing)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isThatAClosingDate(LocalDate date) {
        for (ClosingDate closingDate : closingDates) {
            if (closingDate.getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }
}