import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Average {

    public static Float findAverageTimeBetweenTwoFiveMatchDraws(WeeklyDrawList drawList, AverageTimeBetweenTwoMatchFiveDrawsResult result){
        List timePassedList = new ArrayList<>();

        Integer counter = null;
        for(WeeklyDraw draw : drawList.getDrawListPreparedForDrools()){
            System.out.println(draw.getFiveMatch());
            if( draw.getFiveMatch() != null && draw.getFiveMatch() > 0){
                if(counter == null){
                    counter = 0;
                }else{
                    counter++;
                }
            }else{
                timePassedList.add(counter);
                counter=0;
            }
        }

        return calculateAverage(timePassedList);
    }

    public static float calculateAverage(List arr) {

        int sum = 0;
        for(int n = 0; n < arr.size();n++){
            System.out.println(arr.get(n));
            sum += (Integer)arr.get(n);
        }

        return sum / arr.size();
    }

    private static List<WeeklyDraw> getStubbedDrawList() {

        WeeklyDraw weeklyDraw0 = new WeeklyDraw();
        WeeklyDraw weeklyDraw1 = new WeeklyDraw();
        WeeklyDraw weeklyDraw2 = new WeeklyDraw();
        WeeklyDraw weeklyDraw3 = new WeeklyDraw();
        WeeklyDraw weeklyDraw4 = new WeeklyDraw();
        WeeklyDraw weeklyDraw5 = new WeeklyDraw();
        WeeklyDraw weeklyDraw6 = new WeeklyDraw();
        WeeklyDraw weeklyDraw7 = new WeeklyDraw();
        WeeklyDraw weeklyDraw8 = new WeeklyDraw();
        WeeklyDraw weeklyDraw9 = new WeeklyDraw();

        weeklyDraw0.setYear(1993);
        weeklyDraw1.setYear(1994);
        weeklyDraw2.setYear(1995);
        weeklyDraw3.setYear(1996);
        weeklyDraw4.setYear(1997);
        weeklyDraw5.setYear(1998);

        weeklyDraw0.setWeek(7);
        weeklyDraw0.setWeek(8);
        weeklyDraw0.setWeek(9);
        weeklyDraw0.setWeek(10);
        weeklyDraw0.setWeek(11);
        weeklyDraw0.setWeek(12);

        weeklyDraw0.setFiveMatch(1);
        weeklyDraw0.setThreeMatch(56);
        weeklyDraw0.setTwoMatch(250);

        weeklyDraw1.setFiveMatch(2);
        weeklyDraw1.setThreeMatch(78);
        weeklyDraw1.setTwoMatch(320);

        weeklyDraw2.setFiveMatch(1);
        weeklyDraw2.setFourMatch(2);
        weeklyDraw2.setThreeMatch(46);
        weeklyDraw2.setTwoMatch(200);

        weeklyDraw3.setFourMatch(1);
        weeklyDraw3.setThreeMatch(25);
        weeklyDraw3.setTwoMatch(309);

        weeklyDraw4.setFourMatch(1);
        weeklyDraw4.setThreeMatch(65);
        weeklyDraw4.setTwoMatch(456);

        weeklyDraw4.setThreeMatch(41);
        weeklyDraw4.setTwoMatch(246);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");
            String dateInString0 = "31_08_1993";
            String dateInString1 = "12_07_1994";
            String dateInString2 = "23_05_1995";
            String dateInString3 = "11_08_1986";
            String dateInString4 = "04_02_1997";
            String dateInString5 = "01_04_1998";
            Date date0 = sdf.parse(dateInString0);
            Date date1 = sdf.parse(dateInString1);
            Date date2 = sdf.parse(dateInString2);
            Date date3 = sdf.parse(dateInString3);
            Date date4 = sdf.parse(dateInString4);
            Date date5 = sdf.parse(dateInString5);
            weeklyDraw0.setDrawDate(date0);
            weeklyDraw1.setDrawDate(date1);
            weeklyDraw2.setDrawDate(date2);
            weeklyDraw3.setDrawDate(date3);
            weeklyDraw4.setDrawDate(date4);
            weeklyDraw5.setDrawDate(date5);
        } catch (ParseException e) {
            System.out.println("Dátum formátum parse-olásánál fellépő probléma.");
        }

        List<WeeklyDraw> weeklyDrawList = new ArrayList<>();
        weeklyDrawList.add(weeklyDraw0);
        weeklyDrawList.add(weeklyDraw1);
        weeklyDrawList.add(weeklyDraw2);
        weeklyDrawList.add(weeklyDraw3);
        weeklyDrawList.add(weeklyDraw4);
        weeklyDrawList.add(weeklyDraw5);
        weeklyDrawList.add(weeklyDraw6);
        weeklyDrawList.add(weeklyDraw7);
        weeklyDrawList.add(weeklyDraw8);
        weeklyDrawList.add(weeklyDraw9);

        return weeklyDrawList;
    }

    public static void main(String[] args) {

        WeeklyDrawList weeklyDrawList = new WeeklyDrawList();
        weeklyDrawList.setDrawListPreparedForDrools(getStubbedDrawList());
        AverageTimeBetweenTwoMatchFiveDrawsResult result = new AverageTimeBetweenTwoMatchFiveDrawsResult();
        System.out.println(findAverageTimeBetweenTwoFiveMatchDraws(weeklyDrawList, result));
    }

}

