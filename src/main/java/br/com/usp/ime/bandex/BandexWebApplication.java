package br.com.usp.ime.bandex;

import br.com.usp.ime.bandex.line.LineStatusBO;
import br.com.usp.ime.bandex.line.LineStatusRepository;
import br.com.usp.ime.bandex.restaurant.OperatingHour;
import br.com.usp.ime.bandex.restaurant.Restaurant;
import br.com.usp.ime.bandex.restaurant.RestaurantBO;
import br.com.usp.ime.bandex.restaurant.RestaurantRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

@SpringBootApplication
public class BandexWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BandexWebApplication.class, args);
    }

    @Bean
    public RestaurantBO restaurantBO() {
        return new RestaurantBO();
    }

    @Bean
    public LineStatusBO lineStatusBO() {
        return new LineStatusBO();
    }

    @Bean
    public LineStatusRepository lineStatusRepository() {
        return new LineStatusRepository();
    }

    @Bean
    public RestaurantRepository restaurantRepository() {
        return new RestaurantRepository();
    }

    @Bean
    public Restaurant fakeRestaurant() {
        LocalTime start = LocalTime.parse("20:10:15");
        LocalTime end = LocalTime.parse("21:40:15");
        ArrayList<DayOfWeek> days = new ArrayList<>();
        days.add(DayOfWeek.SATURDAY);
        OperatingHour operatingHour = new OperatingHour(start, end, days);

        ArrayList<OperatingHour> operatingHours = new ArrayList<>();
        operatingHours.add(operatingHour);
        return new Restaurant(2, operatingHours, new ArrayList<>());
    }
}
