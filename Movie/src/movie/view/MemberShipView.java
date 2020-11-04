package movie.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MemberShipView extends JFrame {

    JTextField member_field[];
    JLabel member_label[];
    JPanel member_panel[];
    JPanel membership_panel;
    JLabel title_label;
    JButton join_button, before_button;

    //x,y,z setbounds 배열 초기화시 사용
    int x = 50;
    int y = 55;
    int z = 250;
    public MemberShipView(){
        super("회원가입");

        String s[] = new String[] {"아이디         ", "비밀번호     " ,"이름             ", "전화번호     ", "이메일         ", "생년월일     "};


        //텍스트필드 이메일까지 초기화 생년월일은 따로 초기화
        member_field = new JTextField[6];
        for(int i = 0; i<member_field.length-1; i++){
            member_field[i] = new JTextField("내용을 입력해주세요");
        }
        member_field[5] = new JTextField("YY/MM/DD 는 생략");

        //라벨 String s로 초기화
        member_label = new JLabel[6];
        for(int i = 0; i<member_label.length; i++){
            member_label[i]=new JLabel(s[i]);
        }

        //멤버 패널 초기화
        member_panel = new JPanel[6];
        for(int i=0; i<member_panel.length; i++){
            member_panel[i] = new JPanel(new BorderLayout());
        }
        //나머지 초기화
        membership_panel = new JPanel();
        join_button = new JButton(new ImageIcon("src/img/MemberShipView/Join.png"));
        before_button = new JButton(new ImageIcon("src/img/before.png"));
        title_label = new JLabel("회원가입");

        //멤버쉽 좌표, 사이즈
        membership_panel.setLayout(null);
        title_label.setBounds(150,0,50,50);
        join_button.setBounds(130, 430, 100, 40);
        before_button.setBounds(130,500,100,40);

        //멤버 패널 좌표, 크기 설정
        for(int i=0; i<member_panel.length; i++){

            member_panel[i].setBounds(x, y, z, x);
            y+=60;
            System.out.println(y);
        }
       /* 위에랑 같은거임
        member_panel[0].setBounds(50,50, 250, 50);
        member_panel[1].setBounds(50,110, 250, 50);
        member_panel[2].setBounds(50,170, 250, 50);
        member_panel[3].setBounds(50,230, 250, 50);
        member_panel[4].setBounds(50,290, 250, 50);
        member_panel[5].setBounds(50,350, 250, 50);
        */

        //멤버쉽 패널에 멤버 패널 추가
        for(JPanel data : member_panel){
            membership_panel.add(data);
        }

        //멤버 패널에 라벨 추가
        for(int i=0; i<member_label.length; i++){
            member_panel[i].add(member_label[i], BorderLayout.WEST);
            member_panel[i].setBackground(Color.white);
        }
        //맴버 패널에 텍스트필드 추가
        for(int i=0; i<member_field.length; i++){
            member_panel[i].add(member_field[i], BorderLayout.CENTER);
        }
        //이벤트 받음
        join_button.addActionListener(new EventListner());
        before_button.addActionListener(new EventListner());

        membership_panel.add(join_button);
        membership_panel.add(before_button);
        membership_panel.add(title_label);
        membership_panel.setBackground(Color.white);
        add(membership_panel);
        setVisible(true);
        setSize(360,600);   //Frame size
    }

    //이벤트 처리
    class EventListner extends Component implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JButton input = (JButton) e.getSource();

            if (input.equals(join_button)) {

                System.out.println("가입");
                int ans = JOptionPane.showConfirmDialog(this, "회원 가입을 진행하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(this, "회원 가입 성공!!", "회원가입", JOptionPane.INFORMATION_MESSAGE);
                dispose();  //프레임 종료

            }

            if(input.equals(before_button)){
                System.out.println("이전");
                dispose();  //프레임 종료

            }

        }
    }
}
