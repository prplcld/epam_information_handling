package by.silebin.information_handling.util;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PostfixConverterTest {

    @DataProvider(name = "convert-data-provider")
    public Object[][] convertDataProvider() {
        return new Object[][] {
                {"~6&9|(3&4)", "6 ~ 9 & 3 4 & | "},
                {"5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1)", "5 1 2 & 3 4 1 5 ^ 6 47 & | & 3 | | 89 ~ 4 & 42 7 & | | & 1 | | "}
        };
    }

    @Test(dataProvider = "convert-data-provider")
    public void testConvert(String expression, String expected) {
        String actual  = PostfixConverter.convert(expression);
        Assert.assertEquals(actual, expected);
    }
}
