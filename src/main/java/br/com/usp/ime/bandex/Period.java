package br.com.usp.ime.bandex;

/**
 * Enum to represent the period of the meal.
 */
public enum Period {
    LUNCH(0),
    DINNER(1);

    int id;
    Period(int index) {
        this.id = index;
    }
}
