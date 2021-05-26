package by.silebin.information_handling.util;

import by.silebin.information_handling.exception.PostfixCalculatorException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PostfixCalculatorTest {

    @DataProvider(name = "calculate-data-provider")
    public Object[][] calculateDataProvider() {
        return new Object[][] {
                {"6 ~ 9 & 3 4 & | ", ~6&9|(3&4)},
                {"5 1 2 & 3 4 1 5 ^ 6 47 & | & 3 | | 89 ~ 4 & 42 7 & | | & 1 | | ", 5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1)}
        };
    }

    @Test(dataProvider = "calculate-data-provider")
    public void testCalculate(String expression, int expected) throws PostfixCalculatorException {
        PostfixCalculator postfixCalculator = new PostfixCalculator();
        postfixCalculator.parseExpression(expression);
        int actual = postfixCalculator.calculate();
        Assert.assertEquals(actual, expected);
    }
}
