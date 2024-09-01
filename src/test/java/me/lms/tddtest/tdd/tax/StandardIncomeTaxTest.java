package me.lms.tddtest.tdd.tax;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardIncomeTaxTest {

    public static Stream<Object[]> data() {
        return Stream.of(new Object[][]{
                {0, 2008, 0},
                {1000, 2008, 80},
                {1200, 2008, 96},
                {1205, 2008, 96},
                {1206, 2008, 97},
                {4600, 2008, 674},
                {5000, 2008, 778}
        });
    }

    @ParameterizedTest
    @MethodSource("data")
    void testGetTaxAmount(int income, int year, int expectedTaxAmount) throws Exception {
        StandardTax standardIncomeTax = new StandardTax();
        assertEquals(expectedTaxAmount, standardIncomeTax.getTaxAmount(income));
    }
}
