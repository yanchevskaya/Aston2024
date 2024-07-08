import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigInteger;

import static lesson_10.Factorial.factorial;


public class FactorialTest {

    @Test(description = "check input for factorial", dataProvider = "factorials")
    void testFactorial(int input, BigInteger expected) {
        BigInteger result = factorial(input);
        Assert.assertEquals(result, expected, "Input is " + expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void testFactorialNegative() {
        factorial(-1);
    }

    @DataProvider
    public Object[][] factorials() {
        return new Object[][]{
                {1, BigInteger.valueOf(1)},
                {0, BigInteger.valueOf(1)},
                {10, BigInteger.valueOf(3628800)},
                {20, new BigInteger("2432902008176640000")}
        };
    }

}
