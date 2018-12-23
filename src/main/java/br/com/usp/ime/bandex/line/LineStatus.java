package br.com.usp.ime.bandex.line;

import br.com.usp.ime.bandex.restaurant.Restaurant;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

/**
 * Class to represent the line status of a restaurant.
 */
@Getter
@Builder
@Entity
public class LineStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Min(0) @Max(4)
    int status;

    @Temporal(TemporalType.TIMESTAMP)
    Date time;

    @OneToOne
    Restaurant restaurant;

    @PrePersist
    private void prePersistNowDate() {
        this.time = new Date();
    }
}
