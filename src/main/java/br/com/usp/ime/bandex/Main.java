package br.com.usp.ime.bandex;

import br.com.usp.ime.bandex.bo.RestaurantBO;
import br.com.usp.ime.bandex.repository.LineRepository;
import br.com.usp.ime.bandex.repository.RestaurantRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public LineRepository lineRepository() {
        return new LineRepository();
    }

    @Bean
    public RestaurantBO restaurantBO() {
        return new RestaurantBO();
    }

    @Bean
    public RestaurantRepository restaurantRepository() {
        return new RestaurantRepository();
    }
}
