import java.io.IOException;
import java.util.HashMap;
public class ScreentimeDataInfo {
    int studentId;
    int age;
    String sex;
    String country;
    double num_hours_screen;
    
    ScreentimeDataInfo (String [] values){
        this.studentId = Integer.parseInt(values[0]);
        this.age = Integer.parseInt(values[1]);
        this.sex = values[2];
        this.country  = values [3];
        this.num_hours_screen = Double.parseDouble(values[4]);
    }
    double getScreenTime(){
        return this.num_hours_screen;
    }
    String getCountry(){
        return this.country;
    }
    String getGender(){
        return this.sex;
    }
    int getAge(){
        return this.age;
    }
}
