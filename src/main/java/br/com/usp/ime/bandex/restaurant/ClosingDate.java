package br.com.usp.ime.bandex.restaurant;


import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Class to represent a closing date of a restaurant
 */
@Getter
@EqualsAndHashCode
@Entity
public class ClosingDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
}
