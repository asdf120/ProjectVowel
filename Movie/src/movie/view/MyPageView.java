package movie.view;
import movie.HintTextField;
import movie.data.MemberDAO;
import movie.data.vo.MemberVO;
import movie.data.vo.ReserveVO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyPageView extends JFrame{
    JTextField member_field[];
    JLabel member_label[];
    JPanel member_panel[];
    JPanel mypageview_panel;
    JLabel title_label;
    JButton change_button, before_button, identify_button;

    boolean flag;
    MemberDAO memberDao;
    ReserveVO reserveVO;
    MemberVO memberVo;

    //x,y,z setbounds 배열 초기화시 사용
    int x = 50;
    int y = 55;
    int z = 250;

    public MyPageView(){
        super("마이페이지");

        try{
            memberDao = new MemberDAO();
            reserveVO = new ReserveVO();
            memberVo = new MemberVO();
        }catch (Exception e){
            System.out.println("MyPageView 디비 연결 실패 : " + e.toString());
        }

        String s[] = new String[] {"아이디         ", "비밀번호     " ,"이름             ", "이메일         ", "비밀번호     " };

        //이메일까지 초기화 생년월일은 따로 초기화
        member_field = new JTextField[5];
        for(int i = 0; i<member_field.length-1; i++){
            member_field[i] = new HintTextField("내용을 입력해주세요");
        }
        member_field[1] = new JPasswordField();
        member_field[3] = new HintTextField("aaa@aaa.aaa 형식으로 입력");
        member_field[4] = new JPasswordField();
        //라벨 String s로 초기화
        member_label = new JLabel[5];
        for(int i = 0; i<member_label.length; i++){
            member_label[i]=new JLabel(s[i]);
        }

        //멤버 패널 초기화
        member_panel = new JPanel[5];
        for(int i=0; i<member_panel.length; i++){
            member_panel[i] = new JPanel(new BorderLayout());
        }
        //나머지 초기화
        mypageview_panel = new JPanel();
        change_button = new JButton(new ImageIcon("Movie/src/img/MemberShipView/수정.png"));
        identify_button = new JButton(new ImageIcon("Movie/src/img/MemberShipView/확인.png"));
        before_button = new JButton(new ImageIcon("Movie/src/img/before.png"));
        title_label = new JLabel("마이페이지");

        //멤버쉽 좌표
        mypageview_panel.setLayout(null);
        title_label.setBounds(150,0,80,50);
        identify_button.setBounds(130, 180, 100,40);
        change_button.setBounds(130, 490, 100, 40);
        before_button.setBounds(130,550,100,40);

        //멤버 패널 좌표, 크기 설정
        for(int i=0; i<member_panel.length; i++){
            if(i==2) y+=60;
            member_panel[i].setBounds(x, y, z, x);
            y+=60;
            System.out.println(y);
        }

        //멤버쉽 패널에 멤버 패널 추가
        for(int i=0; i<member_panel.length; i++) {
            mypageview_panel.add(member_panel[i]);
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
        change_button.addActionListener(new EventListner());
        identify_button.addActionListener(new EventListner());
        before_button.addActionListener(new EventListner());
        member_field[1].addActionListener(new EventListner());
        member_field[4].addActionListener(new EventListner());

        mypageview_panel.add(identify_button);
        mypageview_panel.add(change_button);
        mypageview_panel.add(before_button);
        mypageview_panel.add(title_label);
        mypageview_panel.setBackground(Color.white);
        add(mypageview_panel);
        setVisible(true);
        setSize(360,700);   //Frame size
    }

    //이벤트 처리
    class EventListner extends Component implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Object input = e.getSource();

            if(input.equals(identify_button) || input.equals(member_field[1])){
                doConfirm();
            }
            if (input.equals(change_button) || input.equals(member_field[4])) {
                doModify();
                JOptionPane.showConfirmDialog(this, "해당 내용을 수정하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(this, "수정 성공!!", "수정완료", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            if(input.equals(before_button)){
                System.out.println("이전");
                dispose();
            }
        }
    }

    /**
     * 회원정보 확인 처리
     */
    public void doConfirm(){
        String id = member_field[0].getText();
        String pass = member_field[1].getText();
        try{
            reserveVO = memberDao.login(id,pass);
            JOptionPane.showMessageDialog(null,"회원정보 확인완료");
        }catch (Exception e){
            System.out.println("MyPageView 141행: "+ e.toString());
        }
    }

    /**
     * 회원정보 수정 처리
     */
    public void doModify(){
        memberVo.setName(member_field[2].getText());
        memberVo.setEmail(member_field[3].getText());
        memberVo.setPassword(member_field[4].getText());
        try{
            memberDao.modifyInfo(memberVo,reserveVO);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"회원정보 변경 실패");
        }
    }

}
