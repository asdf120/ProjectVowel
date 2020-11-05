package movie.view;
import java.awt.*;
import javax.swing.*;

public class SelectIdView extends JFrame {

    JTextField member_field[];
    JLabel member_label[];
    JPanel member_panel[];

    JTextArea id_area;
    JLabel title_label;
    JPanel selectid_panel;
    JButton before_button, search_button;
    public SelectIdView(){
    super("아이디 찾기");
        String s[] = new String[] {"이름             ", "전화번호     "};

        //TextField 초기화
        member_field = new JTextField[2];
        for(int i = 0; i<member_field.length-1; i++){
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
        id_area = new JTextArea("test");
        title_label = new JLabel("아이디 찾기");
        selectid_panel = new JPanel();

        selectid_panel.setLayout(null);
        title_label.setBounds(150,0,50,50);
        search_button.setBounds(130, 330, 100, 40);
        before_button.setBounds(130,400,100,40);

        add(selectid_panel);
        setVisible(true);
        setSize(360,500);   //Frame size
    }
}
