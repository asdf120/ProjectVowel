package movie.view;

import movie.data.vo.ReserveVO;
import movie.data.vo.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReserveView extends JFrame{

    JButton b_before;
    JButton[] b_date;
    JButton[] b_reserve;
    String title;   //제목
    String info;    //2020.11.2(월) 21:45~23:45

    String day;

    String movie_time;
    String [] s;    // 날짜
    String [] s2;   // 영화 상영 시각
    String theather_time;

    ReserveVO reserveVO;

    int theather_no;


    public ReserveView(String title){   // MovieView로부터 영화 title 받음

        super("영화 예매");

        this.title = title;

        Util u = new Util();
        reserveVO = new ReserveVO();

        //달력 버튼 초기 좌표값
        int b1_x=40;
        int b1_y=150;
        int b1_z=50;
        int b1_zz=40;

        //에매 버튼 초기 좌표값
        int b2_x=70;
        int b2_y=250;
        int b2_z=110;
        int b2_zz=60;

        //라벨 초기 좌표값
        int l_x=55;
        int l_y=200;
        int l_z=50;
        int l_zz=40;

        int width=500;
        int height=600;
        int count=0;
        int reserve_count;

        //패널, 라벨 등 초기화
        JPanel p_reserve = new JPanel();
        JPanel p_date = new JPanel();
        b_date = new JButton[7];
        JLabel[] l_date = new JLabel[7];
        b_reserve = new JButton[u.reserve_Count()];
        b_before = new JButton(new ImageIcon("Movie/src/img/before.png"));

        //화면에 날짜 시간을 띄우기 위해 info에 util에 today를 저장
        info = u.today;

        s = u.time_Count_Html();
        s2 = u.time_Count();

        System.out.println("test"+info);

        //날짜 "일"만 date_count에 담음
        int date_count = Integer.parseInt(u.day);
        for(int i=0; i<7; i++){
            //버튼을 만들건데 달마다 마지막 일이 다르고 마지막일을 넘기는 숫자를 버튼에 담으면 안되서 처리..
            if(u.max_day <= date_count){
                System.out.println(date_count);
                date_count=1;
                b_date[i] = new JButton(String.valueOf(date_count));
                count = 1;
                b_date[i].setBackground(Color.pink);
            }
            else {
                date_count += count;
                b_date[i] = new JButton(String.valueOf(date_count));
                count = 1;
                b_date[i].setBackground(Color.pink);
            }
        }

        //라벨 초기화
        for(int i=0; i<7; i++){ ;
            l_date[i] = new JLabel(u.weeks[i]);
        }

        //버튼 초기화
        for(int i=0; i<b_reserve.length; i++){
          int seat_count = u.seat_Count();
          b_reserve[i] = new JButton(s[i] + "<br>"+ seat_count +"/40석</center></body></HTML>");

            //  b_reserve[i] = new JButton(+ "\n");
        }
        for(int i=0; i<b_date.length; i++){
            b_date[i].setBounds(b1_x, b1_y, b1_z, b1_zz);
            b1_x+=60;
        }

        for(int i=0; i<l_date.length; i++){
            l_date[i].setBounds(l_x, l_y, l_z, l_zz);
            l_x+=60;
        }

        //예매 버튼 좌표 지정
        for(int i=0; i<b_reserve.length; i++){

            if(b2_x+b2_z>=width){
                b2_x = 70;
                b2_y = 330;
            }
                b_reserve[i].setBounds(b2_x, b2_y, b2_z, b2_zz);
                b2_x += 120;
        }
        b_before.setBounds(190,500,100,40);

       for(JButton data : b_reserve){
           p_reserve.add(data);
           data.addActionListener(new EventListner());
        }
        for(JButton data : b_date){
            p_reserve.add(data);
            data.addActionListener(new EventListner());
        }
        for(JLabel data : l_date){
            p_reserve.add(data);
        }

        b_before.addActionListener(new EventListner());

        p_reserve.setLayout(null);

        //패널에 붙이는 작업들..
        p_date.add(new JLabel(u.today));
        p_reserve.add(b_before);
        p_date.setBounds(160,80,150,80);
        p_date.setBackground(Color.white);

        p_reserve.add(p_date);

        add(p_reserve);
        p_reserve.setBackground(Color.white);
        setSize(width,height);
        setVisible(true);

    }

    class EventListner extends Component implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JButton input = (JButton) e.getSource();

            if (input.equals(b_before)) {
                System.out.println("이전");
                dispose();
            }

            for(int i = 0; i< b_date.length; i++){
                if(input.equals(b_date[i])){   // 메뉴선택
                    System.out.println("날짜" + i + "번 버튼 클릭");
                }
            }

            //예매 버튼을 눌렀을때 SeatCountView를 띄우고 SeatCountView에서
            //필요한 정보들을 vo에 담아서 reserveVO, info, movie_time을 넘겨줌
            for(int i = 0; i< b_reserve.length; i++){
                if(input.equals(b_reserve[i])){   // 메뉴선택
                    day = s[i];
                    movie_time = s2[i];
                    System.out.println("ReserveView 180행 영화시간 : " + movie_time);
                    System.out.println("ReserveView 180행 날짜: " + day);
                    theather_time = s2[i].substring(0,5);
                    reserveVO.setTheater_time(theather_time);
                    theather_no = i+1;
                    reserveVO.setTheater_no(theather_no +"관");
                    new SeatCountView(reserveVO, info, movie_time);
                }
            }

        }
    }
}
