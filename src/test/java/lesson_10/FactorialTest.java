package lesson_10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FactorialTest {
    private Factorial factorial;

    @BeforeEach
    public void setUp() {
        factorial = new Factorial();
    }

    @AfterEach
    public void tearDown() {
        factorial = null;
    }

    @Test
    public void testFactorialZero() {
        Assertions.assertEquals(1, factorial.factorial(0));
    }

    @Test
    public void testFactorialOne() {
        Assertions.assertEquals(1, factorial.factorial(1));
    }

    @Test
    public void testFactorialFive() {
        Assertions.assertEquals(120, factorial.factorial(5));
    }

//    @Test
//    public void testFactorialNegative() {
//
//        ApplicationException thrown = Assertions.assertThrows(ApplicationException.class, () -> {
//            //Code under test
//        });
//    }
}
