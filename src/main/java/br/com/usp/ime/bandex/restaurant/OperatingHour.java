package br.com.usp.ime.bandex.restaurant;

import lombok.Data;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

/**
 * Class that represents the operating hours of a restaurant.
 */
@Entity
@Data
public class OperatingHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime startTime;
    private LocalTime endTime;
    @ElementCollection(targetClass = DayOfWeek.class)
    private List<DayOfWeek> daysOfWeek;
}
