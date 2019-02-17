import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;

public class DictionaryTest {

    @Test
    public void getRandomCountyNameTest() {
        int category = 1;
        String countyName = Dictionary.getRandomName(category);
        assertEquals(category, 1);
        assertTrue(Arrays.asList(Dictionary.countyNames).contains(countyName));
    }

    @Test
    public void getRandomCountryNameTest() {
        int category = 2;
        String countryName = Dictionary.getRandomName(category);
        assertEquals(category, 2);
        assertTrue(Arrays.asList(Dictionary.countryNames).contains(countryName));
    }

    @Test
    public void getRandomCityNameTest() {
        int category = 3;
        String cityName = Dictionary.getRandomName(category);
        assertEquals(category, 3);
        assertTrue(Arrays.asList(Dictionary.cityNames).contains(cityName));
    }

    @Test
    public void outOfBoundsCategoryGetRandomNameTest() {
        int category = 10;
        String cityName = Dictionary.getRandomName(category);
        assertEquals(category, 10);
        assertTrue(Arrays.asList(Dictionary.cityNames).contains(cityName));
    }

    @Test
    public void negativeCategoryGetRandomNameTest() {
        int category = -1;
        String cityName = Dictionary.getRandomName(category);
        assertEquals(category, -1);
        assertTrue(Arrays.asList(Dictionary.cityNames).contains(cityName));
    }


}
