import java.io.*;
import java.util.ArrayList;

public class Dictionary {

    static String[] countyNames = {"Argyll and Bute", "Caithness", "Kingdom of Fife",
            "East Lothian", "Highland", "Dumfries and Galloway",
            "Renfrewshire", "Scottish Borders", "Perth and Kinross"};
    static String[] countryNames = {"Scotland", "England", "Wales", "Northern Ireland", "Ireland",
            "France", "Germany", "Netherlands", "Spain", "Portugal",
            "Belgium", "Luxembourg", "Switzerland", "Italy", "Greece"};
    static String[] cityNames = {"St Andrews", "Edinburgh", "Glasgow", "Kirkcaldy", "Perth",
            "Dundee", "Stirling", "Inverness", "Aberdeen", "Falkirk"};

    static ArrayList<String> customNames;

    /**
     * Randomly selects a county, country or city name, based on the category choice
     *
     * @param category
     * @return random county name if category==1
     * random country name if category==2
     * random city name if category<1 && category>=3
     */
    public static String getRandomName(int category) {
        if (category == 1)
            return countyNames[(int) (Math.random() * 9)];
        if (category == 2)
            return countryNames[(int) (Math.random() * 15)];
        return cityNames[(int) (Math.random() * 10)];
    }

    /**
     * Uses method 'getFileReader()' to get a BufferedReader, linked to the input file - wordsource
     * Tries to read every single line in the file, looking for name.
     * Empty lines are not read and the names are trimmed
     *
     * @param wordSource
     * @return empty string if there are no names in the file
     * otherwise, a random name from the input file
     * @throws IOException
     */
    public static String getRandomCustomName(String wordSource) throws IOException {
        if (wordSource == null) {
            throw new NullPointerException();
        }

        String line;
        customNames = new ArrayList<String>();

        BufferedReader reader = getFileReader(wordSource);

        try {
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    customNames.add(line);
                }
            }
        } catch (IOError e) {
            throw new IOException();
        }

        if (customNames.size() == 0) {
            return "";
        }

        return customNames.get((int) (Math.random() * customNames.size()));
    }

    /**
     * Returns a BufferedReader object linked to input file.
     *
     * @param wordSource
     * @return reader - BufferedReader object linked to input file
     * @throws FileNotFoundException
     */
    public static BufferedReader getFileReader(String wordSource) throws FileNotFoundException {
        FileReader file = null;
        try {
            file = new FileReader(wordSource);
            BufferedReader reader = new BufferedReader(file);
            return reader;
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            throw new FileNotFoundException();
        }
    }
}
