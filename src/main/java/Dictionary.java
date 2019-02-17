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

    public static String getRandomName(int category) {
        if (category == 1)
            return countyNames[(int) (Math.random() * 9)];
        if (category == 2)
            return countryNames[(int) (Math.random() * 15)];
        return cityNames[(int) (Math.random() * 10)];
    }

    public static String getRandomCustomName(String wordSource){
        String line;
        customNames = new ArrayList<String>();

        try {
            FileReader file = new FileReader(wordSource);
            BufferedReader reader = new BufferedReader(file);
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    customNames.add(line);
                }
            }
            if(customNames.size() == 0){
                return "";
            }
            return customNames.get((int) (Math.random() * customNames.size()));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return "";
        } catch (IOException e) {
            System.out.println("IO ERROR");
            return "";
        }
    }
}
