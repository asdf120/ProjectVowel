package movie.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SearchIDView extends JFrame {

    JTextField member_field[];
    JLabel member_label[];
    JPanel member_panel[];

    JTextArea id_area;
    JLabel title_label;
    JPanel searchid_panel;
    JButton before_button, search_button;

    int x = 50;
    int y = 55;
    int z = 250;
    public SearchIDView(){
    super("아이디 찾기");
        String s[] = new String[] {"이름             ", "전화번호     "};

        //TextField 초기화
        member_field = new JTextField[2];
        for(int i = 0; i<member_field.length; i++){
            member_field[i] = new JTextField("내용을 입력해주세요");
        }

        //라벨 String s로 초기화
        member_label = new JLabel[2];
        for(int i = 0; i<member_label.length; i++){
            member_label[i]=new JLabel(s[i]);
        }

        //멤버 패널 초기화
        member_panel = new JPanel[2];
        for(int i=0; i<member_panel.length; i++){
            member_panel[i] = new JPanel(new BorderLayout());
        }

        id_area = new JTextArea("아이디 : ?\ntestestsetst\nsdfasadsaddsa\nsdasdsa\n" );
        title_label = new JLabel("아이디 찾기");
        searchid_panel = new JPanel();
        search_button = new JButton(new ImageIcon("Movie/src/img/LoginView/찾기.png"));
        before_button = new JButton(new ImageIcon("Movie/src/img/before.png"));


        //멤버 패널 좌표, 크기 설정
        for(int i=0; i<member_panel.length; i++){

            member_panel[i].setBounds(x, y, z, x);
            y+=60;
            System.out.println(y);
        }
        searchid_panel.setLayout(null);
        title_label.setBounds(150,0,80,50);
        search_button.setBounds(130, 180, 100, 40);
        before_button.setBounds(130,400,100,40);
        id_area.setBounds(80,250,100,80);
        searchid_panel.setBackground(Color.white);

        for(JPanel data : member_panel){
            searchid_panel.add(data);
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
        search_button.addActionListener(new EventListner());
        before_button.addActionListener(new EventListner());
        searchid_panel.add(before_button);
        searchid_panel.add(search_button);
        searchid_panel.add(title_label);
        searchid_panel.add(id_area);
        add(searchid_panel);
        setVisible(true);
        setSize(360,500);   //Frame size
    }

    class EventListner extends Component implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JButton input = (JButton) e.getSource();

            if (input.equals(search_button)) {

                System.out.println("검색");
                JOptionPane.showMessageDialog(this, "검색 성공!!", "검색완료", JOptionPane.INFORMATION_MESSAGE);

            }

            if(input.equals(before_button)){
                System.out.println("이전");
                dispose();  //프레임 종료

            }

        }
    }
}
