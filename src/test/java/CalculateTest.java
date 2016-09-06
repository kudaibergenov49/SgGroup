import org.junit.Test;

import java.util.Random;

import static junit.framework.Assert.assertEquals;


/**
 * Created by Storm on 06.09.2016.
 */
public class CalculateTest {


    @Test
    public void testTriangle() throws Exception {
        Calculate calculate = new Calculate();
        Random random = new Random();

        // int a = random.nextInt(10);
        // int b = random.nextInt(10);
        // int c = random.nextInt(10);

        // double s = a*b* Math.pow( (    1 - Math.pow(  (a*a + b*b - c*c)/(2*a*b)  ,2)    ), 0.5) / 2;
        double expected = calculate.triangle(3,4,5);
        // c^2 = a^2 + b^2 - 2*a*b*cos(x)

        assertEquals(expected, 6.0);
    }

    @Test
    public void testCircle() throws Exception {
        Calculate calculate = new Calculate();
        double expected = calculate.circle(0);
        assertEquals(expected, 0.0);
    }

    @Test
    public void testSquare() throws Exception {
        Calculate calculate = new Calculate();
        double expected = calculate.square(4);
        assertEquals(expected,16.0);
    }

    @Test
    public void testRectangle() throws Exception {
        Calculate calculate = new Calculate();
        double expected = calculate.rectangle(3,4);
        assertEquals(expected, 12.0);
    }

}