import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ReadCSV {
    HashMap<String, ScreentimeDataInfo> map;
    String filename;
    public static int maxID = 0;
    public static String maxGender = "";
    public static String maxCountry = "";
    ReadCSV(String filename){
        this.filename = filename;
        this.map = data_CSV();
    }

    public HashMap<String, ScreentimeDataInfo> data_CSV(){
        Scanner scanner;
        HashMap <String, ScreentimeDataInfo> map = new HashMap<String, ScreentimeDataInfo>();

        try{
            scanner = new Scanner(new File(filename));

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String [] values = line.split(",");

                if(values[0].equals("Student_ID")){
                    continue;
                }
                else{
                    ScreentimeDataInfo screentimeInfo = new ScreentimeDataInfo(values);
                    map.put(values[0], screentimeInfo);
                
                    maxID = Math.max(maxID, Integer.parseInt(values[0]));

                }
                
            }
            scanner.close();
        } catch (FileNotFoundException a){
            a.printStackTrace();
        }

        return map;
    }

    public Object get(String person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
}
