package movie.data.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Util {


    public String[] week = {"일","월","화","수","목","금","토"};
    public String[] weeks;
    public String today;
    public String day;
    public String date;
    public int  max_day;
    public Util(){

    SimpleDateFormat format1 = new SimpleDateFormat("yyyy. MM. dd ");   //DateFormat format1 지정
    SimpleDateFormat format2 = new SimpleDateFormat("dd");              //DateFormat format2 지정

    Date time = new Date();
    Calendar cal = Calendar.getInstance();

    date = format1.format(time);    //date변수에 format1 형식으로 저장
    day = format2.format(time);     //day변수에 format2 형식으로 저장

    max_day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);  //달의 마지막날을 저장
    weeks = new String[7];


    //format1을 dd로하면 01~09가 올수있음 그래서 String 배열로 비교해서 0을 없앨거임
    String[] days = new String[] {"01", "02","03","04","05","06","07","08","09"};


    //0 제거
    for(int i=0; i<days.length; i++){
        if(days[i].equals(day))
            day = String.valueOf(days[i].charAt(1));
    }

    //DAY_OF_WEEK은 오늘의 요일을 의미함 1~7까지의 값을 리턴함 String[]배열과 비교를 해야되기 때문에 -1을함
    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) -1;
    String korDayofWeek = "";
       for(int i=0; i<weeks.length; i++){
            weeks[i] = week[dayOfWeek]; //weeks라는 string 배열에 week[dayOfWeek] 오늘의 날짜부터 weeks에 넣음
            ++dayOfWeek;
            if(dayOfWeek==7)            //만약에 오늘날짜가 수요일이면 수 목 금 토 일 월 화를 찍어야되는데
                dayOfWeek=0;            //weeks의 배열엔 월화수목금으로 나열되어 있어서 dayofWeek이 7이되면 0으로 바꿔서 처음부터 다시샘
        }

        today = date + "("+week[dayOfWeek]+")"; //오늘 날짜 + (요일을) 찍기위한 변수 지정

        weeks[0] = "오늘"; //오늘의 요일을 오늘로 바꿈
        weeks[1] = "내일"; //내일의 요일을 내일로 바꿈

        System.out.println(today);
        System.out.println(day);


    }
    /*
     * 함수명 : reserve_Count()
     * 인자 : 상영 버튼 카운트 int[] ?
     * 리턴값 : 상영 버튼 카운트
     * 역할 : 상영 버튼 카운트를 반환해야 reserve_Count 반환된 카운트 만큼 버튼을 생성
     */
    public int reserve_Count(){
        return 6;
    }

    /*
     * 함수명 : seat_Count()
     * 인자 : 좌석 카운트 int[] ?
     * 리턴값 : 좌석 카운트
     * 역할 : 좌석 카운트를 반환해야 ReserView에서 반환된 카운트를 가지고 버튼에 남은 좌석수를 받음
     */
    public int seat_Count() {
        return 6;
    }

    /*
     * 함수명 : time_Count_Html()
     * 인자 : String[] theather_time을 받을것임
     * 리턴값 : theater_time
     * 역할 : theather_time을 가지고 버튼을 만들때 상영시간을 넣기 위함 HTML형식으로 한거는 ..
     * 버튼안에 값을 \n으로 내리지 못함 그래서 html 형식 <br>처리
     */
    public String[] time_Count_Html() {
        String[] theater_time = new String[]{
                "<HTML><body><center>17:45~19:45",  "<HTML><body><center>19:30~21:30", "<HTML><body><center>21:45~23:45", "<HTML><body><center>00:00~02:00", "<HTML><body><center>02:15~04:15", "<HTML><body><center>04:30~06:30"
        };

        return theater_time;
    }

    /*
     * 함수명 : time_Count()
     * 인자 : String[] theather_time을 받을것임
     * 리턴값 : theater_time
     * 역할 : theather_time 반환값을 가지고 substring으로 잘라서 reserveView에서 vo에 theater_time을 넣음
     */
    public String[] time_Count() {
        String[] theater_time = new String[]{
                "17:45~19:45",  "19:30~21:30", "21:45~23:45", "00:00~02:00", "02:15~04:15", "04:30~06:30"
        };

        return theater_time;
    }

}