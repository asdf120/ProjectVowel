package movie.view;

import movie.data.MemberDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPWView extends JFrame {
    MemberDAO memberDao;

    JTextField member_field[];
    JLabel member_label[];
    JPanel member_panel[];

    JLabel title_label;
    JPanel searchpw_panel;
    JButton before_button, search_button, modify_button;

    int x = 50;
    int y = 55;
    int z = 250;
    int zz = 50;

    String email = null;

    public SearchPWView() {
        super("비밀번호 찾기");

        try {
            memberDao = new MemberDAO();
            System.out.println("SearchPWView 디비연결 성공");
        } catch (Exception e) {
            System.out.println("SearchPWView 디비연결 실패 : " + e.toString());
        }

        String s[] = new String[]{"이름             ", "전화번호     ", "새로운 비밀번호  "};
        //TextField 초기화
        member_field = new JTextField[3];
        for (int i = 0; i < member_field.length; i++) {
            member_field[i] = new JTextField();
        }

        //라벨 String s로 초기화
        member_label = new JLabel[3];
        for (int i = 0; i < member_label.length; i++) {
            member_label[i] = new JLabel(s[i]);
        }

        //멤버 패널 초기화
        member_panel = new JPanel[3];
        for (int i = 0; i < member_panel.length; i++) {
            member_panel[i] = new JPanel(new BorderLayout());
        }

        title_label = new JLabel("비밀번호 찾기");
        searchpw_panel = new JPanel();
        search_button = new JButton(new ImageIcon("Movie/src/img/LoginView/찾기.png"));
        modify_button = new JButton(new ImageIcon("Movie/src/img/RegistView/수정.png"));
        before_button = new JButton(new ImageIcon("Movie/src/img/before.png"));

        for (int i = 0; i < member_panel.length; i++) {
            member_panel[i].setBounds(x, y, z, zz);
            if (i == 1) {
                x = 20;
                y = 250;
                z = 270;
            } else y += 60;
            System.out.println(y);
        }


        searchpw_panel.setLayout(null);
        title_label.setBounds(150, 0, 80, 50);
        search_button.setBounds(130, 180, 100, 40);
        before_button.setBounds(130, 370, 100, 40);
        modify_button.setBounds(130, 310, 100, 40);
        searchpw_panel.setBackground(Color.white);

        for (JPanel data : member_panel) {
            searchpw_panel.add(data);
        }

        //멤버 패널에 라벨 추가
        for (int i = 0; i < member_label.length; i++) {
            member_panel[i].add(member_label[i], BorderLayout.WEST);
            member_panel[i].setBackground(Color.white);
        }

        //맴버 패널에 텍스트필드 추가
        for (int i = 0; i < member_field.length; i++) {
            member_panel[i].add(member_field[i], BorderLayout.CENTER);
        }
        //이벤트 받음
        search_button.addActionListener(new EventListner());
        before_button.addActionListener(new EventListner());
        modify_button.addActionListener(new EventListner());
        member_field[1].addActionListener(new EventListner());
        member_field[2].addActionListener(new EventListner());

        searchpw_panel.add(before_button);
        searchpw_panel.add(search_button);
        searchpw_panel.add(modify_button);
        searchpw_panel.add(title_label);

        add(searchpw_panel);
        setVisible(true);
        setSize(360, 470);   //Frame size
    }

    /**
     * 버튼 이벤트 리스너
     */
    class EventListner extends Component implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            Object input = e.getSource();
            if (input.equals(search_button) || input.equals(member_field[1])) {
                System.out.println("검색");
                email = doSearchPW();
            } else if (input.equals(before_button)) {
                System.out.println("이전");
                dispose();  //프레임 종료
            } else if (input.equals(modify_button) || input.equals(member_field[2])) {
                System.out.println("122행 email");
                doChangePw(email);  // doSearchPW() 에서 반환받은 email값을 넘겨줌
            }
        }
    }

    /**
     *
     *  계정을 찾는 메소드
     */
    public String doSearchPW() {
        String name = member_field[0].getText(); // 이름 얻어오기
        String tel = member_field[1].getText(); // 전화번호값 얻어오기
        try {
            email = memberDao.searchPw(name, tel); // 0이면 비밀번호 수정가능 -1이면 비밀번호 수정불가
            System.out.println("143행 : " + email);
            if (email != null) {
                System.out.println("회원 찾기 성공" + email);
            } else {
                System.out.println("회원을 찾을 수 없음 ");
//                        JOptionPane.showMessageDialog(this,"회원정보가 없습니다.");
            }
        } catch (Exception ex) {
            System.out.println("회원을 찾을 수 없음 : " + ex.toString());
//                    JOptionPane.showMessageDialog(this,"회원정보가 없습니다.");
        }

        return email;
    }

    /**
     * 계정 비밀번호 변경 메소드
     */
    public void doChangePw(String email){
        String password = member_field[2].getText();
        try {
            memberDao.changePw(email, password);
            System.out.println("SearchPWView 121행 비밀번호 변경 성공 : " + password);
        } catch (Exception ex) {
            System.out.println("SearchPWView 비밀번호 변경 실패 :" + ex.toString());
        }
    }
}

