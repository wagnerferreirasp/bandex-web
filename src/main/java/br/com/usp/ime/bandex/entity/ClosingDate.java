package br.com.usp.ime.bandex.entity;

import br.com.usp.ime.bandex.Period;

import java.util.ArrayList;
import java.util.Date;

/**
 * Class to represent a closing date of a restaurant
 */
public class ClosingDate {
    Date date;
    Period period;

    public ClosingDate(Date date, Period period) {
        this.date = date;
        this.period = period;
    }
}
