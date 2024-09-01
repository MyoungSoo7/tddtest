package me.lms.tddtest.tdd.csv;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CVSLoaderTest {

    private static CSVLoader csvLoader;

    @BeforeAll
    public static void setUp()  {
        csvLoader = new CSVLoader("src/test/TextData.csv");
    }

    @Test
    void test()  {
        List<Object[]> actualList = csvLoader.loadAll();
        List<Object[]> expectedList = Arrays.asList(new Object[][]{
                {"0","2008","0"},
                {"1000","2008","80"},
                {"1200","2008","96"},
                {"1205","2008","96"},
                {"1206","2008","97"},
                {"4600","2008","674"},
                {"5000","2008","778"}
        });
        assertEquals(expectedList.size(), actualList.size());
        assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    @Test
    void testCommaSeparatedStringsToObjects(){
        assertArrayEquals(new Object[]{"0", "2008", "0"}, csvLoader.commaSeperatedStringsToObjects("0,2008,0"));
    }


}
