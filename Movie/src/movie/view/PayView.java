package movie.view;

import movie.data.ReserveDAO;
import movie.data.vo.ReserveVO;
import movie.data.vo.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PayView extends JFrame {

    JButton b_Pay_Card, b_Pay_Phone, b_Pay_Receipt;

    JLabel l_Pay, l_PayKind, l_Title, l_Date, l_Seat, l_Count, l_Price;

    JPanel p_Pay;
    ReserveVO reserveVo;
    ReserveDAO reserveDao;
    StringBuffer str;
    ArrayList<String> list;
    Util util;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yy/mm/dd/ hh24:mm:ss");

    public PayView(ArrayList<String> list, StringBuffer str, ReserveVO ReserveVo) {
        super("결제");
        try{
            reserveDao = new ReserveDAO();
        }catch (Exception e){
            System.out.println("PayView 디비 연결 실패 :"+ e.toString());
        }

        this.reserveVo = ReserveVo;
        this.str = str;
        this.list = list;
        util = new Util();

        StringBuffer sb = new StringBuffer(ReserveVo.getTheater_no()+"관");

        //좌석을 StringBuffer에 append
        loop:
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                sb.append(" " + list.get(i) + ",");
            }
        }
        //마지막 , 제거
        String seat_no = sb.substring(0, sb.length()-1);
        // ReserveVo에 좌석 저장
        reserveVo.setSeat_no(seat_no);
        System.out.println("44행 : " + seat_no);

        //초기화
        b_Pay_Card = new JButton(new ImageIcon("Movie/src/img/카드.png"));
        b_Pay_Phone = new JButton(new ImageIcon("Movie/src/img/휴대폰결제.png"));
        b_Pay_Receipt = new JButton(new ImageIcon("Movie/src/img/영수증메일.png"));

        l_Pay = new JLabel(new ImageIcon("src/img/결제.png"));
        l_PayKind = new JLabel(new ImageIcon("src/img/결제수단.png"));

        p_Pay = new JPanel();
        //라벨에 제목, 시간, 좌석, 가격 등의 정보를 담음
        l_Title = new JLabel("    " + "영화제목");
        l_Date = new JLabel("    " + util.today + " - " + ReserveVo.getStart_time() + "~ " +ReserveVo.getStart_time());
        l_Seat = new JLabel(String.valueOf("    " + seat_no));
        l_Count = new JLabel(String.valueOf("    " + str));
        l_Price = new JLabel("    " + ReserveVo.getPay_money() + "원");

        //좌표설정
        l_Title.setBounds(10, 50, 300, 50);
        l_Date.setBounds(10, 70, 300, 50);
        l_Seat.setBounds(10, 90, 300, 50);
        l_Count.setBounds(10, 110, 300, 50);
        l_Price.setBounds(270, 110, 300, 50);

        l_Pay.setBounds(10, 10, 50, 50);
        l_PayKind.setBounds(10, 200, 100, 50);
        b_Pay_Card.setBounds(50, 260, 120, 50);
        b_Pay_Phone.setBounds(190, 260, 120, 50);
        b_Pay_Receipt.setBounds(110, 330, 150, 50);

        b_Pay_Card.addActionListener(new EventListner());
        b_Pay_Phone.addActionListener(new EventListner());
        b_Pay_Receipt.addActionListener(new EventListner());

        p_Pay.setLayout(null);
        p_Pay.setBackground(Color.white);

        p_Pay.add(b_Pay_Card);
        p_Pay.add(b_Pay_Phone);
        p_Pay.add(b_Pay_Receipt);

        p_Pay.add(l_Pay);
        p_Pay.add(l_PayKind);
        p_Pay.add(l_Count);
        p_Pay.add(l_Price);
        p_Pay.add(l_Date);
        p_Pay.add(l_Seat);
        p_Pay.add(l_Title);

        add(p_Pay);

        setSize(380, 450);
        setVisible(true);
    }
    class EventListner extends Component implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            JButton input = (JButton) e.getSource();
            if (input.equals(b_Pay_Card)) {
                System.out.println("PayView 인원 " + reserveVo.getPerson_num()); // 인원
                System.out.println("PayView 상영관" + reserveVo.getTheater_no()); // 상영관
                System.out.println("PayView 시각" + reserveVo.getStart_time()); // 시작시각
                System.out.println("PayView 가격" + reserveVo.getPay_money());  // 가격
                System.out.println("PayView 좌석번호" + reserveVo.getSeat_no());    // 좌석
                System.out.println("PayView 전화번호" + reserveVo.getMember_tel()); // 전화번호
                System.out.println("PayView 비회원전화번호" + reserveVo.getNon_member_tel()); // 비회원번호

                doReserve("카드");
                JOptionPane.showMessageDialog(this, "카드를 넣어주세요!", "카드", JOptionPane.INFORMATION_MESSAGE);
            }
            if (input.equals(b_Pay_Phone)) {
                JOptionPane.showMessageDialog(this, "ㅇㅅㅇ!!", "ㅍ", JOptionPane.INFORMATION_MESSAGE);
            }

            if (input.equals(b_Pay_Receipt)) {
                JOptionPane.showMessageDialog(this, "으악!!", "으악", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void doReserve(String pay_sys){
        try{
            System.out.println("PayView 139행 상영관번호 : " + reserveVo.getTheater_no());
            System.out.println("PayView 140행  상영시각 : " +reserveVo.getStart_time());
//            Date start_time = dateFormat.parse(reserveVo.getStart_time());
//            java.sql.Date sql_time= new java.sql.Date(start_time.getTime());
//            System.out.println("PayView 136행 " + reserveVo.getStart_time()); // 시작시각
            reserveDao.reserveMovie(reserveVo, pay_sys);
        }catch (Exception e){
            System.out.println("예매실패 : "+ e.toString());
        }
    }
}
