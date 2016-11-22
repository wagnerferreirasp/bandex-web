package br.com.usp.ime.bandex.bo;

import br.com.usp.ime.bandex.entity.Line;
import br.com.usp.ime.bandex.repository.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * BO class of the Line
 */
@Component
public class LineBO {

    @Autowired
    private LineRepository lineRepository;

    @Autowired
    private RestaurantBO restaurantBO;

    public boolean isValid(Line line) {
        return (line.getStatus() >= 0)
                && (line.getStatus() < 5)
                && restaurantBO.isValid(line.getRestaurant());
    }

    public boolean dateIsValid(Date date) {
        System.out.println("LineBO.dateIsValid");
        return true;
    }

    public Line insert(Line line) throws Exception {
        if (this.isValid(line)) {
            return lineRepository.save(line);
        }
        System.out.println("Fila Inválida!");
        throw new Exception("Fila inválida");
    }

}
