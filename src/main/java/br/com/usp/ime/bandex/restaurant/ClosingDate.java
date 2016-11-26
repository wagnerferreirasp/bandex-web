package br.com.usp.ime.bandex.restaurant;


import java.time.LocalDate;

/**
 * Class to represent a closing date of a restaurant
 */
public class ClosingDate {
    private LocalDate date;

    public ClosingDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}
