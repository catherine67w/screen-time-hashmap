import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        ReadCSV reader = new ReadCSV("StudentsSocialMediaAddiction.csv");
        HashMap<String, ScreentimeDataInfo> dataMap = reader.data_CSV();

        // HashMaps to track max screen time by category
        HashMap<Integer, ScreentimeDataInfo> maxByAge = new HashMap<>();
        HashMap<String, ScreentimeDataInfo> maxByCountry = new HashMap<>();
        HashMap<String, ScreentimeDataInfo> maxByGender = new HashMap<>();

        for (ScreentimeDataInfo person : dataMap.values()) {

            double screenTime = person.getScreenTime();

            // ---- AGE ----
            int age = person.getAge();
            if (!maxByAge.containsKey(age) ||
                screenTime > maxByAge.get(age).getScreenTime()) {
                maxByAge.put(age, person);
            }

            // ---- COUNTRY ----
            String country = person.getCountry();
            if (!maxByCountry.containsKey(country) ||
                screenTime > maxByCountry.get(country).getScreenTime()) {
                maxByCountry.put(country, person);
            }

            // ---- GENDER ----
            String gender = person.getGender();
            if (!maxByGender.containsKey(gender) ||
                screenTime > maxByGender.get(gender).getScreenTime()) {
                maxByGender.put(gender, person);
            }
        }

        // ---- PRINT RESULTS ----
        System.out.println("Highest Screen Time by Age:");
        for (Map.Entry<Integer, ScreentimeDataInfo> entry : maxByAge.entrySet()) {
            ScreentimeDataInfo p = entry.getValue();
            System.out.println(
                "Age: " + entry.getKey() +
                " | Screen Time: " + p.getScreenTime() +
                " | Gender: " + p.getGender() +
                " | Country: " + p.getCountry()
            );
        }

        System.out.println("\nHighest Screen Time by Country:");
        for (Map.Entry<String, ScreentimeDataInfo> entry : maxByCountry.entrySet()) {
            ScreentimeDataInfo p = entry.getValue();
            System.out.println(
                "Country: " + entry.getKey() +
                " | Screen Time: " + p.getScreenTime() +
                " | Age: " + p.getAge() +
                " | Gender: " + p.getGender()
            );
        }

        System.out.println("\nHighest Screen Time by Gender:");
        for (Map.Entry<String, ScreentimeDataInfo> entry : maxByGender.entrySet()) {
            ScreentimeDataInfo p = entry.getValue();
            System.out.println(
                "Gender: " + entry.getKey() +
                " | Screen Time: " + p.getScreenTime() +
                " | Age: " + p.getAge() +
                " | Country: " + p.getCountry()
            );
        }
    }
}