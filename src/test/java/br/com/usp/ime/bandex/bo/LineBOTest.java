package br.com.usp.ime.bandex.bo;

import br.com.usp.ime.bandex.entity.Line;
import br.com.usp.ime.bandex.entity.Restaurant;
import br.com.usp.ime.bandex.repository.LineRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import java.util.Date;

/**
 * Test class of the LineBO class
 */
@RunWith(MockitoJUnitRunner.class)
public class LineBOTest {

    @InjectMocks
    private LineBO lineBO;

    @Mock
    private RestaurantBO restaurantBO;

    @Mock
    private LineRepository lineRepository;

    @Test
    public void isValidWhenRestaurantIsValidAndLineIsNot() {
        when(restaurantBO.isValid(Matchers.any(Restaurant.class))).thenReturn(true);
        Line line = new Line(7, new Date(), null);
        Assert.assertFalse(lineBO.isValid(line));
    }

    @Test
    public void isValidWhenRestaurantIsNotValidAndLineIsNot() {
        when(restaurantBO.isValid(Matchers.any(Restaurant.class))).thenReturn(false);
        Line line = new Line(7, new Date(), null);
        Assert.assertFalse(lineBO.isValid(line));
    }

    @Test
    public void testIsValidWhenRestaurantIsValidAndLineIs() {
        when(restaurantBO.isValid(Matchers.any(Restaurant.class))).thenReturn(true);
        Line line = new Line(2, new Date(), null);
        Assert.assertTrue(lineBO.isValid(line));
    }

}
