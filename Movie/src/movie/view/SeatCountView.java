package movie.view;

import movie.data.vo.ReserveVO;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;

public class SeatCountView extends JFrame {

    String info;            //생성자 인자로 받은 info를 저장하기 위함
    String movie_Time;      //생성자 인자로 받은 movie_Time 저장하기 위함

    String person_type[] = { "일반", "청소년", "우대" };     // 예매하시는 분들 타입을 비교해야되기 때문에 선언

    JButton[] b_Normal;     //일반에 해당되는 1~8까지 버튼 선언
    JButton[] b_Teenager;   //청소년에 해당되는 1~8까지 버튼 선언
    JButton[] b_Benefit;    //우대에 해당되는 1~8까지 버튼 선언
    JButton b_SeatChoose, b_Before;

    JPanel p_SeatCount, p_Imgpanel, p_Screen;
    JLabel l_Img, l_Title, l_Screen, l_MovieTime, l_Person;

    JLabel[] l_Label;
    ReserveVO vo;

    //버튼 좌표 임의
    int b_x=100;
    int b_y=371;
    int b_z=30;
    int b_zz=30;

    //예매하시는 분들의 타입마다 count를 저장하기 위함
    int count[];


    public SeatCountView(ReserveVO vo, String info, String movie_Time){
        super("인원 선택");
        this.info = info;
        this.movie_Time = movie_Time;
        this.vo = vo;
        count = new int[3];

        //잘받아왔나 찍어봄..
        String time = info + " " + movie_Time;
        System.out.println("SeatCountView() 47행" +info);
        System.out.println("SeatCountView() 48행" +movie_Time);

        System.out.println("SeatCountView() 50행" +vo.getTheater_time());

        //버튼 라벨 패널 등등 초기화
        b_SeatChoose = new JButton(new ImageIcon("Movie/src/img/좌석선택.png"));
        b_Before = new JButton(new ImageIcon("Movie/src/img/이전.png"));
        l_Person = new JLabel(new ImageIcon("Movie/src/img/person.png"));
        l_Img = new JLabel(new ImageIcon( "Movie/src/img/좌석내용.png"));

        b_Normal = new JButton[8];
        b_Teenager = new JButton[8];
        b_Benefit = new JButton[8];
        l_Label = new JLabel[3];
        l_Title = new JLabel("SeatCountView 62행 영화제목");
        l_MovieTime = new JLabel(time);

        p_Screen = new JPanel();
        l_Screen = new JLabel(new ImageIcon("Movie/src/img/좌석.png"));
        p_SeatCount = new JPanel();
        p_Imgpanel = new JPanel();

        //청소년 카운트 버튼을 설정
        for(int i=0; i<b_Teenager.length; i++){
            b_Teenager[i] = new JButton(String.valueOf(i));
            b_Teenager[i].setBounds(b_x,b_y,b_z,b_zz);
            b_x+=32;
        }
        b_y=401;
        b_x=100;

        //우대 카운트 버튼을 설정
        for(int i=0; i<b_Benefit.length; i++){
            b_Benefit[i] = new JButton(String.valueOf(i));
            b_Benefit[i].setBounds(b_x,b_y,b_z,b_zz);
            b_x+=32;
        }
        b_y=431;
        b_x=100;

        //일반 카운트 버튼을 설정
        for(int i=0; i<b_Normal.length; i++){
            b_Normal[i] = new JButton(String.valueOf(i));
            b_Normal[i].setBounds(b_x,b_y,b_z,b_zz);
            b_x+=32;
        }

        p_SeatCount.setLayout(null);
        l_Title.setBounds(150, 30, 200, 50);
        l_MovieTime.setBounds(100, 65, 300, 70);
        l_Screen.setBounds(120,130,120,120);
        p_Imgpanel.setBounds(10, 250, 350,100);
        b_Before.setBounds(0, 470, 190, 40);
        b_SeatChoose.setBounds(190, 470, 190, 40);
        l_Person.setBounds(25, 375, 70, 80);

        //패널에 버튼 추가 및 이벤트 등록
        for(JButton data : b_Normal) {
            p_SeatCount.add(data);
            data.addActionListener(new EventListner());
        }
        for(JButton data : b_Teenager) {
            p_SeatCount.add(data);
            data.addActionListener(new EventListner());
        }
        for(JButton data : b_Benefit) {
            p_SeatCount.add(data);
            data.addActionListener(new EventListner());
        }

        b_Before.addActionListener(new EventListner());
        b_SeatChoose.addActionListener(new EventListner());

        //패널에 다 때려 박음
        p_Imgpanel.add(l_Img);
        p_Imgpanel.setBackground(Color.white);

        p_SeatCount.add(l_Person);
        p_SeatCount.add(b_SeatChoose);
        p_SeatCount.add(b_Before);
        p_SeatCount.add(l_Screen);
        p_SeatCount.add(l_MovieTime);
        p_SeatCount.add(p_Imgpanel);
        p_SeatCount.add(l_Title);
        add(p_SeatCount);

        p_SeatCount.setBackground(Color.white);
        setSize(380,550);
        setVisible(true);
    }

    class EventListner extends Component implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JButton input = (JButton) e.getSource();

            if (input.equals(b_Before)) {

                System.out.println("이전");
                dispose();

            }
            //각 타입마다 수량을 저장
            for(int i = 0; i< 8; i++) {
                if (input.equals(b_Normal[i])) {
                    count[0] = i + 1;
                    System.out.println(person_type[0]);
                    System.out.println(count[0]);
                    }
                }
            for(int i = 0; i< 8; i++) {
                    if (input.equals(b_Teenager[i])) {
                        count[1] = i + 1;
                        System.out.println(person_type[1]);
                        System.out.println(count[1]);
                    }
                }
            for(int i = 0; i< 8; i++){
                if (input.equals(b_Benefit[i])) {
                    count[2] = i + 1;
                    System.out.println(person_type[2]);
                    System.out.println(count[2]);
                }
            }

         if(input.equals(b_SeatChoose)){
             vo.setPerson_num(count[0] + count[1] + count[2]);  //저장된 총 카운트를 Person_num에 저장함
             System.out.println(vo.getPerson_num());
             System.out.println(vo.getTheater_time());
             System.out.println(vo.getTheater_no());
             new SeatRegistView(vo, person_type, count);   //SeatRegistView에서 필요한 정보들을 넘겨줌

             dispose();
         }

        }
    }

}
