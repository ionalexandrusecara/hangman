import static org.junit.Assert.*;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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

    @Test
    public void zeroCategoryGetRandomNameTest() {
        int category = 0;
        String cityName = Dictionary.getRandomName(category);
        assertEquals(category, 0);
        assertTrue(Arrays.asList(Dictionary.cityNames).contains(cityName));
    }

    @Test
    public void getRandomCustomNameTestOne() throws IOException{
        String wordSource = "oneName.txt";
        String targetName = Dictionary.getRandomCustomName(wordSource);
        assertEquals(targetName, "London");
        assertEquals(Dictionary.customNames.size(), 1);
    }

    @Test
    public void getRandomCustomNameTestTwo() throws IOException{
        String wordSource = "twoNames.txt";
        ArrayList<String> possibleNames = new ArrayList<>();
        possibleNames.add("London");
        possibleNames.add("Edinburgh");

        String targetName = Dictionary.getRandomCustomName(wordSource);

        assertEquals(Dictionary.customNames.size(), 2);
        assertEquals(Dictionary.customNames, possibleNames);
        assertTrue(possibleNames.contains(targetName));
    }

    @Test
    public void specialCharactersGetRandomCustomNameTest() throws IOException{
        String wordSource = "specialCharacters.txt";
        ArrayList<String> possibleNames = new ArrayList<>();
        possibleNames.add("123%");
        possibleNames.add("*****");

        String targetName = Dictionary.getRandomCustomName(wordSource);

        assertEquals(Dictionary.customNames.size(), 2);
        assertEquals(Dictionary.customNames, possibleNames);
        assertTrue(possibleNames.contains(targetName));
    }

    @Test
    public void emptyLineGetRandomCustomNameTest() throws IOException{
        String wordSource = "emptyLine.txt";
        ArrayList<String> possibleNames = new ArrayList<>();
        possibleNames.add("London");
        possibleNames.add("Edinburgh");

        String targetName = Dictionary.getRandomCustomName(wordSource);

        assertEquals(Dictionary.customNames.size(), 2);
        assertEquals(Dictionary.customNames, possibleNames);
        assertTrue(possibleNames.contains(targetName));
    }

    @Test
    public void whiteSpaceLineGetRandomCustomNameTest() throws IOException{
        String wordSource = "whiteSpace.txt";
        ArrayList<String> possibleNames = new ArrayList<>();
        possibleNames.add("London");
        possibleNames.add("Edinburgh");

        String targetName = Dictionary.getRandomCustomName(wordSource);
        //System.out.println(Arrays.asList(Dictionary.customNames));

        assertEquals(Dictionary.customNames.size(), 2);
        assertEquals(Dictionary.customNames, possibleNames);
        assertTrue(possibleNames.contains(targetName));
    }

    @Test
    public void whiteSpaceInNameGetRandomCustomNameTest() throws IOException{
        String wordSource = "whiteSpace2.txt";
        ArrayList<String> possibleNames = new ArrayList<>();
        possibleNames.add("London");
        possibleNames.add("Edinburgh");

        String targetName = Dictionary.getRandomCustomName(wordSource);

        assertEquals(Dictionary.customNames.size(), 2);
        assertEquals(Dictionary.customNames, possibleNames);
        assertTrue(possibleNames.contains(targetName));
    }

    @Test
    public void sameLineNameGetRandomCustomNameTest() throws IOException{
        String wordSource = "sameLine.txt";

        String targetName = Dictionary.getRandomCustomName(wordSource);

        assertEquals(targetName, "Los Angeles");
        assertEquals(Dictionary.customNames.size(), 1);
    }

    @Test
    public void emptyFileGetRandomCustomNameTest() throws IOException{
        String wordSource = "emptyFile.txt";

        String targetName = Dictionary.getRandomCustomName(wordSource);

        assertEquals(targetName, "");
        assertEquals(Dictionary.customNames.size(), 0);
    }

    @Test(expected = FileNotFoundException.class)
    public void wrongFileGetRandomCustomNameTest() throws IOException {
        String wordSource = "asd";

        String targetName = Dictionary.getRandomCustomName(wordSource);

        assertEquals(targetName, "");
        assertEquals(Dictionary.customNames.size(), 0);
    }

    @Test(expected = FileNotFoundException.class)
    public void wrongFileGetRandomCustomNameTest2() throws IOException {
        String wordSource = "";

        String targetName = Dictionary.getRandomCustomName(wordSource);

        assertEquals(targetName, "");
        assertEquals(Dictionary.customNames.size(), 0);
    }

    @Test(expected = NullPointerException.class)
    public void nullFileGetRandomCustomNameTest2() throws IOException {
        String wordSource = null;

        String targetName = Dictionary.getRandomCustomName(wordSource);

        assertEquals(targetName, "");
        assertEquals(Dictionary.customNames.size(), 0);
    }

}
