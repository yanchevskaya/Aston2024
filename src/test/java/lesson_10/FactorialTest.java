package lesson_10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static lesson_10.Factorial.factorial;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {

    @Test
    public void testFactorialZero() {
        assertEquals(BigInteger.valueOf(1), factorial(0));
    }

    @Test
    public void testFactorialOne() {
        assertEquals(BigInteger.valueOf(1), factorial(1));
    }

    @Test
    public void testFactorialFive() {
        assertEquals(BigInteger.valueOf(5), factorial(100));
    }

    @Test
    public void testFactorialOneHundret() {
        assertEquals(new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"), factorial(100));
    }

    @Test
    public void testFactorialNegative() {

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> factorial(-1));

        assertEquals("Number must be positive", exception.getMessage());
    }
}
