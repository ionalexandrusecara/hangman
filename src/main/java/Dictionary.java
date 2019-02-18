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
     * @param category
     * @return random county name if category==1
     *         random country name if category==2
     *         random city name if category<1 && category>=3
     */
    public static String getRandomName(int category) {
        if (category == 1)
            return countyNames[(int) (Math.random() * 9)];
        if (category == 2)
            return countryNames[(int) (Math.random() * 15)];
        return cityNames[(int) (Math.random() * 10)];
    }

    public static String getRandomCustomName(String wordSource) throws IOException{
        String line;
        customNames = new ArrayList<String>();

        if(wordSource == null){
            throw new NullPointerException();
        }

        BufferedReader reader = getFileReader(wordSource);

        try{
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    customNames.add(line);
                }
            }
        } catch (IOError e){
            throw new IOException();
        }

        if(customNames.size() == 0){
            return "";
        }

        return customNames.get((int) (Math.random() * customNames.size()));

    }

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
