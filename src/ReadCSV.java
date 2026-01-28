import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ReadCSV {

    ArrayList<ScreentimeDataInfo> students;
    HashMap<Short, ScreentimeDataInfo> studentMap;
    String filename;

    ReadCSV(String filename) {
        this.filename = filename;
        students = new ArrayList<>();
        studentMap = new HashMap<>();
        readCSV();
    }

    public void readCSV() {
        try {
            Scanner scanner = new Scanner(new File(filename));

            // Skip header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                ScreentimeDataInfo student = new ScreentimeDataInfo();

                // Adjust indices if your CSV differs
                student.studentId = Short.parseShort(values[0]);
                student.age = Short.parseShort(values[1]);
                student.sex = values[2];
                student.country = values[3];

                // Add to ArrayList
                students.add(student);

                studentMap.put(student.studentId, student);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ScreentimeDataInfo getStudentById(short id) {
        return studentMap.get(id);
    }
}
