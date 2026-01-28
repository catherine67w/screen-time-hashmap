import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class App {
    // create a hashmap to store platform popularity
    private static HashMap<String, Integer> platformPopularity = new HashMap<>();

    public static void main(String[] args) {
        ReadCSV reader = new ReadCSV("StudentsSocialMediaAddiction.csv");
        HashMap<String, ScreentimeDataInfo> dataMap = reader.data_CSV();
        ScreentimeDataInfo maxPerson = dataMap.get(1);

        for (int i = 0; i < ReadCSV.maxID; i++){
            ScreentimeDataInfo person = dataMap.get(String.valueOf(i));
            if (person != null) {
                if (person.num_hours_screen > maxPerson.num_hours_screen){
                    maxPerson = dataMap.get(String.valueOf(i));
                }
            }
        }
        System.out.println("Screen time data for person:");
        System.out.println("Screen Time: " + String.valueOf(maxPerson.getScreenTime()));
        System.out.println("Gender: " + maxPerson.getGender());
        System.out.println("Age: " + String.valueOf(maxPerson.getAge()));
        System.out.println("Country: " + maxPerson.getCountry());
        System.out.println("No data found for person.");
   }
}