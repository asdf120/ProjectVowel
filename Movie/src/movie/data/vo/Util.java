package movie.data.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Util {

    public String[] week = {"일","월","화","수","목","금","토"};
    public String[] week2 = {"일","월","화","수","목","금","토", "일","월","화","수","목","금","토"};
    public String[] weeks;
    public String today, today_n;
    public String day;
    public String date;
    public int  max_day;
    public String[] date_name;
    public Util(){

    SimpleDateFormat format1 = new SimpleDateFormat("yyyy. MM. dd ");
    SimpleDateFormat format2 = new SimpleDateFormat("dd");

    Date time = new Date();
    Calendar cal = Calendar.getInstance();

    date = format1.format(time);
    day = format2.format(time);

    max_day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    weeks = new String[7];

    String[] days = new String[] {"01", "02","03","04","05","06","07","08","09"};


    //0 제거
    for(int i=0; i<days.length; i++){
        if(days[i].equals(day))
            day = String.valueOf(days[i].charAt(1));
    }


    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) -1;
    String korDayofWeek = "";
       for(int i=0; i<weeks.length; i++){
            weeks[i] = week[dayOfWeek];
            ++dayOfWeek;
            if(dayOfWeek==7)
                dayOfWeek=0;
        }

        today = date + "("+week[dayOfWeek]+")";


        weeks[0] = "오늘";
        weeks[1] = "내일";

        System.out.println(today);
        System.out.println(day);


    }
    public int reserve_Count(){
        return 6;
    }

    public int seat_Count() {
        return 6;
    }

    public String[] time_Count_Html() {
        String[] test = new String[]{
                "<HTML><body><center>17:45~19:45",  "<HTML><body><center>19:30~21:30", "<HTML><body><center>21:45~23:45", "<HTML><body><center>00:00~02:00", "<HTML><body><center>02:15~04:15", "<HTML><body><center>04:30~06:30"
        };

        return test;
    }

    public String[] time_Count() {
        String[] test = new String[]{
                "17:45~19:45",  "19:30~21:30", "21:45~23:45", "00:00~02:00", "02:15~04:15", "04:30~06:30"
        };

        return test;
    }

}