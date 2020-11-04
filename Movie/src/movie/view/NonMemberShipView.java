package movie.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NonMemberShipView extends JFrame {

    JTextField non_member_field[];
    JLabel non_member_label[];
    JPanel non_member_panel[];
    JPanel non_membership_panel;
    JLabel title_label;
    JButton join_button, before_button;

    //x,y,z setbounds 배열 초기화시 사용
    int x = 50;
    int y = 55;
    int z = 250;

    public NonMemberShipView(){
        super("비회원가입");
        String s[] = new String[] {"이름             ", "비밀번호     ", "전화번호     ", "이메일         ", "생년월일     "};

        //이메일까지 초기화 생년월일은 따로 초기화
        non_member_field = new JTextField[5];
        for(int i = 0; i<non_member_field.length-1; i++){
            non_member_field[i] = new JTextField("내용을 입력해주세요");
        }
        non_member_field[4] = new JTextField("YY/MM/DD 는 생략");

        //라벨 String s로 초기화
        non_member_label = new JLabel[5];
        for(int i = 0; i<non_member_label.length; i++){
            non_member_label[i]=new JLabel(s[i]);
        }

        //멤버 패널 초기화
        non_member_panel = new JPanel[5];
        for(int i=0; i<non_member_panel.length; i++){
            non_member_panel[i] = new JPanel(new BorderLayout());
        }
        //나머지 초기화
        non_membership_panel = new JPanel();
        join_button = new JButton(new ImageIcon("Movie/src/img/MemberShipView/Join.png"));
        before_button = new JButton(new ImageIcon("Movie/src/img/before.png"));
        title_label = new JLabel("비회원가입");

        //멤버쉽 좌표
        non_membership_panel.setLayout(null);
        title_label.setBounds(150,0,60,50);
        join_button.setBounds(130, 380, 100, 40);
        before_button.setBounds(130,450,100,40);

        //멤버 패널 좌표, 크기 설정
        for(int i=0; i<non_member_panel.length; i++){

            non_member_panel[i].setBounds(x, y, z, x);
            y+=60;
            System.out.println(y);
        }

        //멤버쉽 패널에 멤버 패널 추가
        for(int i=0; i<non_member_panel.length; i++) {
            non_membership_panel.add(non_member_panel[i]);
        }

        //멤버 패널에 라벨 추가
        for(int i=0; i<non_member_label.length; i++){
            non_member_panel[i].add(non_member_label[i], BorderLayout.WEST);
            non_member_panel[i].setBackground(Color.white);
        }
        //맴버 패널에 텍스트필드 추가
        for(int i=0; i<non_member_field.length; i++){
            non_member_panel[i].add(non_member_field[i], BorderLayout.CENTER);
        }
        //이벤트 받음
        join_button.addActionListener(new EventListner());
        before_button.addActionListener(new EventListner());

        non_membership_panel.add(join_button);
        non_membership_panel.add(before_button);
        non_membership_panel.add(title_label);
        non_membership_panel.setBackground(Color.white);
        add(non_membership_panel);
        setVisible(true);
        setSize(360,550);   //Frame size
    }

    //이벤트 처리
    class EventListner extends Component implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JButton input = (JButton) e.getSource();

            if (input.equals(join_button)) {

                System.out.println("가입");
                int ans = JOptionPane.showConfirmDialog(this, "비회원 가입을 진행하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(this, "비회원 가입 성공!!", "비회원가입", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                MovieView mv = new MovieView();
            }

            if(input.equals(before_button)){
                System.out.println("이전");
                dispose();

            }

        }
    }
}
