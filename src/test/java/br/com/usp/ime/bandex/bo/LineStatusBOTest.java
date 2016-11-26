package br.com.usp.ime.bandex.bo;

import br.com.usp.ime.bandex.line.LineStatus;
import br.com.usp.ime.bandex.line.LineStatusRepository;
import br.com.usp.ime.bandex.restaurant.Restaurant;
import br.com.usp.ime.bandex.line.LineStatusBO;
import br.com.usp.ime.bandex.restaurant.RestaurantBO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import java.util.Date;

/**
 * Test class of the LineStatusBO class
 */
@RunWith(MockitoJUnitRunner.class)
public class LineStatusBOTest {

    @Mock
    private RestaurantBO restaurantBO;

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private LineStatusRepository lineStatusRepository;

    @InjectMocks
    private LineStatusBO lineStatusBO;

    @Test
    public void isValidWhenRestaurantIsValidAndLineIsNot() {
        when(restaurantBO.isValid(Matchers.any(Restaurant.class))).thenReturn(true);
        LineStatus lineStatus = new LineStatus(7, new Date(), null);
        Assert.assertFalse(lineStatusBO.isValid(lineStatus));
    }

    @Test
    public void isValidWhenRestaurantIsNotValidAndLineIsNot() {
        when(restaurantBO.isValid(Matchers.any(Restaurant.class))).thenReturn(false);
        LineStatus lineStatus = new LineStatus(7, new Date(), null);
        Assert.assertFalse(lineStatusBO.isValid(lineStatus));
    }

    @Test
    public void testIsValidWhenRestaurantIsValidAndLineIs() {
        when(restaurantBO.isValid(Matchers.any(Restaurant.class))).thenReturn(true);
        when(restaurantBO.isOpen(Matchers.any(Restaurant.class))).thenReturn(true);
        LineStatus lineStatus = new LineStatus(2, new Date(), null);
        Assert.assertTrue(lineStatusBO.isValid(lineStatus));
    }

}
