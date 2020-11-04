package movie.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginView extends JFrame {

    //로그인 녀석들
    JButton[] logins_button;
    JButton select_id, select_pw;
    JPanel login_panel;
    JPanel id_panel, pw_panel;
    JLabel id_label, pw_label, title_label;
    JTextField id_field, pw_field;


    public LoginView() {
        super("CGV 영화 예매");

        //아이디, 패스워드 입력 패널
        id_panel = new JPanel(new BorderLayout());
        pw_panel = new JPanel(new BorderLayout());

        //로그인, 비회원, 회원가입 버튼
        logins_button = new JButton[3];
        logins_button[0] = new JButton(new ImageIcon("Movie/src/img/LoginView/로그인.png"));
        logins_button[1] = new JButton(new ImageIcon("Movie/src/img/LoginView/비회원.png"));
        logins_button[2] = new JButton(new ImageIcon("Movie/src/img/LoginView/회원가입.png"));


        login_panel = new JPanel();
        title_label = new JLabel("영화 예매");
        id_label = new JLabel(new ImageIcon("Movie/src/img/member/id.png"));
        pw_label = new JLabel(new ImageIcon("Movie/src/img/member/pw.png"));
        id_field = new JTextField("Username");
        pw_field = new JTextField("＊＊＊＊");
        select_id = new JButton(new ImageIcon("Movie/src/img/LoginView/아이디찾기.png"));
        select_pw = new JButton(new ImageIcon("Movie/src/img/LoginView/비밀번호찾기.png"));
    }


    public void output() {
        //panel, button 위치 크기 지정
        login_panel.setLayout(null);
        title_label.setBounds(150, 50, 100, 40);
        logins_button[0].setBounds(135, 280, 90, 40);
        logins_button[1].setBounds(105, 390, 150, 38);
        logins_button[2].setBounds(130, 330, 100, 50);
        logins_button[2].setBackground(Color.white);
        id_panel.setBounds(70, 120, 200, 50);
        pw_panel.setBounds(70, 180, 200, 50);
        select_id.setBounds(110, 240, 60, 25);
        select_pw.setBounds(180, 240, 80, 25);
       // select_pw.setBounds();
       // select_id.setBounds()
        //버튼 이벤트 추가
        for (JButton data : logins_button) {
            data.addActionListener(new EventListner());
        }
        select_id.addActionListener(new EventListner());
        select_pw.addActionListener(new EventListner());

        //패널에 버튼 추가
        for (JButton data : logins_button) {
            login_panel.add(data);
        }

        //아이디 패널에 라벨, 필드 추가
        id_panel.add(id_label, BorderLayout.WEST);
        id_panel.add(id_field, BorderLayout.CENTER);
        pw_panel.add(pw_label, BorderLayout.WEST);
        pw_panel.add(pw_field, BorderLayout.CENTER);

        //로그인 패널에 패널, 라벨 붙이기
        login_panel.add(select_id);
        login_panel.add(select_pw);
        login_panel.add(id_panel);
        login_panel.add(pw_panel);
        login_panel.add(title_label);
        login_panel.setBackground(Color.white);
        login_panel.add(select_id);
        login_panel.add(select_pw);
        //프레임에 패널 붙이기기
        add(login_panel);


       setVisible(true);
        setSize(360, 500);

    }

    //이벤트 처리
   class EventListner extends Component implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JButton input = (JButton) e.getSource();

            if (input.equals(logins_button[0])) {

                System.out.println("로그인 버튼");
                JOptionPane.showMessageDialog(this, "로그인 성공!!", "로그인", JOptionPane.INFORMATION_MESSAGE);
                MovieView mv = new MovieView(); //영화창 띄움
                dispose();  //프레임 종료
            }

            if (input.equals(logins_button[1])) {
                System.out.println("비회원 버튼");
                NonMemberShipView n = new NonMemberShipView();  //비회원창을 띄움
                n.add(n.non_membership_panel);
            }
            if (input.equals(logins_button[2])) {
                System.out.println("회원가입 버튼");
                MemberShipView m = new MemberShipView();    //회원가입창을 띄움
                m.add(m.membership_panel);
            }
            if(input.equals(select_id)){
                System.out.println("아이디찾기 버튼");

            }
            if(input.equals(select_pw)){
                System.out.println("비밀번호찾기 버튼");

            }
        }
    }
}
