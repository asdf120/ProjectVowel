package movie.view;

import movie.data.SeatDAO;
import movie.data.vo.ReserveVO;
import movie.data.vo.SeatVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SeatRegistView extends JFrame {

    //버튼, 좌석 이름 2차원 배열 선언
    JButton[][] b_Seat;
    String[][] str_Seat;
    JButton b_Pay, b_PayCancel;

    JLabel l_Screen, l_Theater_no, l_Title, l_TypeCount, l_Price;
    JPanel p_Seat, p_Center, p_info;
    SeatDAO seatDAO;
    SeatVO[][] sv;
    //영화표 가격들
    int benefit = 7000;
    int teenager = 9000;
    int normal = 11000;

    ReserveVO reserveVo;
    String[] type;      //인자로 받은 사람 타입으르 저장
    StringBuffer str;   //화면에 사람 타입 + 수량을 찍기 위한 StringBuffer 선언 ex) 일반 3

    int[] count;        //영화표 계산을 위한 인자로 받은 수량을 저장하기 위함
    int price;

    //좌표값 임의 지정
    int x = 50;
    int y = 50;
    int z = 30;


    //좌석 저장
    ArrayList<String> seatList;
    public SeatRegistView(ReserveVO reserveVo, String[] type, int[] count) {

        super("좌석");

        this.reserveVo = reserveVo;
        this.type = type;
        this.count = count;

        System.out.println("SeatRegistView 51행  : " + reserveVo.getTheater_no());

        sv = new SeatVO[5][9];
        try {
            seatDAO = new SeatDAO();

            sv = seatDAO.regist(reserveVo.getStart_time());

        } catch (Exception e) {
            e.printStackTrace();
        }


        //8*3 인원선택시 24까지만 추가할 수 있음
        seatList = new ArrayList();

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
        reserveVo.setPay_money(price);

        String theather_no = "    " + reserveVo.getTheater_no() + "(KOSMO) 6층";

        b_Seat = new JButton[5][9];
        String status = "N";
        //좌석 버튼 초기화
        loop:
        for (int i = 0; i < sv.length; i++) {
            for (int j = 0; j < sv[i].length; j++) {
                if (i == 4 && j == 4) {
                    break loop;
                }
                b_Seat[i][j] = new JButton(sv[i][j].addColRow(sv[i][j].getRow(), sv[i][j].getCol()));
//                System.out.println("SeatRegistView 95행 : " +sv[i][j].getStatus());
                if(sv[i][j].getStatus().equals(status)){
                    System.out.println("status if들어옴");
                    b_Seat[i][j].setEnabled(false);
                }


            }
        }

        //패널, 버튼, 라벨 초기화
        p_Seat = new JPanel();
        p_Center = new JPanel();
        p_info = new JPanel();

        b_Pay = new JButton(new ImageIcon("Movie/src/img/결제하기.png"));
        b_PayCancel = new JButton(new ImageIcon("Movie/src/img/결제취소.png"));

        l_Theater_no = new JLabel(theather_no);
        //TODO ReserveVO 확인
        l_Title = new JLabel("    " + "SeatRegistView 115행");
        l_TypeCount = new JLabel("    " + String.valueOf(str));
        l_Price = new JLabel(String.valueOf(price) + "원");

        l_Screen = new JLabel(new ImageIcon("Movie/src/img/screen.png"));
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
                b_Seat[i][j].addMouseListener(new ClickListenr());
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
    class ClickListenr extends MouseAdapter implements MouseListener{
        //TODO 다시 클릭하면 취소되기
        @Override
        public void mouseClicked(MouseEvent e) {
            JButton jButton = (JButton) e.getSource();
            for (int i = 0; i < b_Seat.length; i++) {
                for (int j = 0; j < b_Seat[i].length; j++) {
                    if (jButton.equals(b_Seat[i][j])) {
                        if(seatList.contains(sv[i][j].addColRow(sv[i][j].getRow(), sv[i][j].getCol()))){
                            seatList.remove(sv[i][j].addColRow(sv[i][j].getRow(), sv[i][j].getCol()));
                            b_Seat[i][j].setEnabled(true);
                        }else{
                            seatList.add(sv[i][j].addColRow(sv[i][j].getRow(), sv[i][j].getCol()));
                            b_Seat[i][j].setEnabled(false);
                        }
                        System.out.println("SeatRegistView 205행 seatList 크기 : " +seatList.size());
                        if (reserveVo.getPerson_num() == seatList.size()) {
                            JOptionPane.showMessageDialog(null,"인원수만큼 클릭 완료");
                        }
                    }
                }

            }
        }
    }

    class EventListner extends Component implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JButton input = (JButton) e.getSource();

            if (input.equals(b_Pay)) {
                System.out.println(seatList.size());
                if (reserveVo.getPerson_num() != seatList.size()) {
                    JOptionPane.showMessageDialog(null, "좌석을 선택해주세요");
                }else{
                    //TODO 바꿀것
                    new PayView(seatList, str, reserveVo);
                }
                for(String result : seatList){
                    System.out.println("결과 :"+result);
                }
            }

            if (input.equals(b_PayCancel)) {
                System.out.println("결제취소");
                dispose();
            }
        }
    }
}


