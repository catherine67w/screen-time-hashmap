import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<ScreentimeDataInfo> screentimes = new ArrayList<>();

        ReadCSV csv = new ReadCSV("Students Social Media Addiction.csv");

        // ArrayList counting way
        countryCounts(screentimes);

        // HashMap counting way
        countryCountsHashMap(screentimes);
    }

    // display counts of students per country
    // need 2 "parallel" arraylists. one for countries, one for counts
    public static void countryCounts(ArrayList<ScreentimeDataInfo> students) {
        System.out.println("Array List way: ");

        ArrayList<String> countries = new ArrayList<>();
        ArrayList<Integer> numStudents = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {

            ScreentimeDataInfo student = students.get(i);

            if (countries.contains(student.country)) {
                System.out.println("Country: " + student.country);
                int index = countries.indexOf(student.country);
                int count = numStudents.get(index) + 1;
                numStudents.set(index, count);
            } else {
                countries.add(student.country);
                numStudents.add(1);
            }
        }

        for (int i = 0; i < countries.size(); i++) {
            String country = countries.get(i);
            int count = numStudents.get(i);
            System.out.println("Country " + country + " count: " + count);
        }
    }

    // hashmap combines the two parallel array(lists) already
    public static void countryCountsHashMap(ArrayList<ScreentimeDataInfo> students) {
        System.out.println("Hashmap way:");

        HashMap<String, Integer> countryCounts = new HashMap<>();

        for (int i = 0; i < students.size(); i++) {

            ScreentimeDataInfo student = students.get(i);

            if (countryCounts.containsKey(student.country)) {
                int count = countryCounts.get(student.country) + 1;
                countryCounts.put(student.country, count);
            } else {
                countryCounts.put(student.country, 1);
            }
        }

        for (String country : countryCounts.keySet()) {
            int count = countryCounts.get(country);
            System.out.println("Country " + country + " count: " + count);
        }
    }
}