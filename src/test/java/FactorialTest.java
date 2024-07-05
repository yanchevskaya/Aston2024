import org.testng.annotations.Test;

import java.math.BigInteger;

import static lesson_10.Factorial.factorial;
import static org.testng.Assert.assertEquals;

public class FactorialTest {

    @Test
    void testFactorialOne () {
        assertEquals(factorial(1), BigInteger.valueOf(1));
    }

    @Test
    void testFactorialNull (){
        assertEquals(factorial(0), BigInteger.valueOf(1));
    }

    @Test
    void testFactorialTen () {
        assertEquals(factorial(10), BigInteger.valueOf(3628800));
    }

    @Test
    void testFactorialTwenty () {
        assertEquals(factorial(20), new BigInteger("2432902008176640000"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void testFactorialNegative() {
        factorial(-1);
    }
}
