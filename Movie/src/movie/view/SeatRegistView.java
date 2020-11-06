package movie.view;

import movie.data.vo.ReserveVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeatRegistView extends JFrame {

    //버튼, 좌석 이름 2차원 배열 선언
    JButton[][] b_Seat;
    String[][] str_Seat;
    JButton b_Pay, b_PayCancel;

    JLabel l_Screen, l_Theater_no, l_Title, l_TypeCount, l_Price;
    JPanel p_Seat, p_Center, p_info;

    //영화표 가격들
    int benefit = 7000;
    int teenager = 9000;
    int normal = 11000;

    ReserveVO vo;
    String[] type;      //인자로 받은 사람 타입으르 저장
    StringBuffer str;   //화면에 사람 타입 + 수량을 찍기 위한 StringBuffer 선언 ex) 일반 3

    int[] count;        //영화표 계산을 위한 인자로 받은 수량을 저장하기 위함
    int price;

    //좌표값 임의 지정
    int x = 50;
    int y = 50;
    int z = 30;


    //좌석 저장
    String[] list;


    public SeatRegistView(ReserveVO vo, String[] type, int[] count) {

        super("좌석");

        this.vo = vo;
        this.type = type;
        this.count = count;

        //8*3 인원선택시 24까지만 추가할 수 있음
        list = new String[24];

        str = new StringBuffer();
        //타입과 카운트를 붙임
        for (int i = 0; i < 3; i++) {
            System.out.println(type[i] + "" + count[i]);
            if (count[i] > 0) {
                str.append(type[i] + " " + String.valueOf(count[i]) + " ");
            }
        }

        //총가격 계산
        price = count[0] * normal + count[1] * teenager + count[2] * benefit;
        vo.setPay_money(price);

        String theather_no = "    " + vo.getTheater_no() + "(KOSMO) 6층";


        b_Seat = new JButton[5][9];
        str_Seat = new String[][]{{"A01", "A02", "A03", "A04", "A05", "A06", "A07", "A08", "A09"}, {"B01", "B02", "B03", "B04", "B05", "B06", "B07", "B08", "B09"},
                {"C01", "C02", "C03", "C04", "C05", "C06", "C07", "C08", "C09"}, {"D01", "D02", "D03", "D04", "D05", "D06", "D07", "D08", "D09"}, {"F01", "F02", "F08", "F09"}};

        //좌석 버튼 초기화
        loop:
        for (int i = 0; i < b_Seat.length; i++) {
            for (int j = 0; j < str_Seat[i].length; j++) {
                if (i == 4 && j == 4) {

                    break loop;
                }
                b_Seat[i][j] = new JButton(str_Seat[i][j]);
            }
        }

        //패널, 버튼, 라벨 초기화
        p_Seat = new JPanel();
        p_Center = new JPanel();
        p_info = new JPanel();

        b_Pay = new JButton(new ImageIcon("Movie/src/img/결제하기.png"));
        b_PayCancel = new JButton(new ImageIcon("Movie/src/img/결제취소.png"));

        l_Theater_no = new JLabel(theather_no);
        l_Title = new JLabel("SeatRegistView 영화제목 ");
        l_TypeCount = new JLabel("    " + String.valueOf(str));
        l_Price = new JLabel(String.valueOf(price) + "원");

        l_Screen = new JLabel(new ImageIcon("src/img/screen.png"));
        p_Seat.setLayout(null);

        p_info.setBackground(Color.white);
        p_Center.setBackground(Color.black);

        //좌석 버튼 위치 잡기..
        loop2:
        for (int i = 0; i < b_Seat.length; i++) {
            for (int j = 0; j < b_Seat[i].length; j++) {
                if (i == 4 && j == 4) {
                    break loop2;
                }
                b_Seat[i][j].setBounds(x, y, z, z);
                b_Seat[i][j].setBackground(Color.white);
                x += 30;
                if (i == 4 && j == 1) {
                    x = 260;
                }
            }
            x = 50;
            y += 45;
        }

        //패널, 라벨, 버튼 좌표 지정
        p_info.setBounds(0, 300, 380, 82);
        p_info.setLayout(null);
        p_Center.setLayout(null);
        l_Screen.setBounds(2, 0, 130, 40);
        p_Center.setBounds(0, 0, 380, 280);
        b_Pay.setBounds(0, 362, 190, 50);
        b_PayCancel.setBounds(190, 362, 190, 50);

        l_Theater_no.setBounds(5, 0, 150, 13);
        l_Title.setBounds(5, 13, 150, 18);
        l_TypeCount.setBounds(5, 31, 150, 18);
        l_Price.setBounds(300, 31, 150, 18);

        b_Pay.addActionListener(new EventListner());
        b_PayCancel.addActionListener(new EventListner());

        //좌표 버튼 이벤트 처리, 패널에 좌표 넣기
        loop3:
        for (int i = 0; i < b_Seat.length; i++) {
            for (int j = 0; j < b_Seat[i].length; j++) {
                if (i == 4 && j == 4) {

                    break loop3;
                }
                b_Seat[i][j].addActionListener(new EventListner());
                p_Center.add(b_Seat[i][j]);
            }
        }

        p_Center.add(l_Screen);
        p_info.add(l_Theater_no);
        p_info.add(l_Title);
        p_info.add(l_TypeCount);
        p_info.add(l_Price);
        p_Seat.add(b_Pay);
        p_Seat.add(b_PayCancel);
        p_Seat.add(p_info);
        p_Seat.add(p_Center);


        p_Seat.setBackground(Color.white);

        add(p_Seat);

        setSize(380, 450);
        setVisible(true);

    }

    class EventListner extends Component implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JButton input = (JButton) e.getSource();

            if (input.equals(b_Pay)) {
                PayView pv = new PayView(list, str, vo);

            }

            if (input.equals(b_PayCancel)) {
                System.out.println("결제취소");
                dispose();
            }
            loop4:
            for (int i = 0; i < b_Seat.length; i++) {
                for (int j = 0; j < b_Seat[i].length; j++) {
                    if (input.equals(b_Seat[i][j])) {
                        list[i] = str_Seat[i][j];
                        System.out.println(list[i]);

                    }
                }
            }
        }

    }
}


