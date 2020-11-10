package movie.view;

import movie.HintTextField;
import movie.data.MemberDAO;
import movie.data.vo.MemberVO;
import movie.data.vo.ReserveVO;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

// 비회원예매 뷰
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

    MemberDAO memberDao;
    ReserveVO reserveVo;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");

    public NonMemberShipView(){
        super("비회원가입");

        try{
            memberDao = new MemberDAO();
            reserveVo = new ReserveVO();
            System.out.println("NonMemberShipView 디비연결 성공");
        }catch (Exception e){
            System.out.println("NonMemberShipView 디비연결 실패 " + e.toString());
        }

        String s[] = new String[] {"전화번호     ", "생년월일     "};

        //이메일까지 초기화 생년월일은 따로 초기화
        non_member_field = new JTextField[2];
        for(int i = 0; i<non_member_field.length-1; i++){
            non_member_field[i] = new JTextField();
        }
        non_member_field[1] = new HintTextField("6자리 숫자로 입력");

        //라벨 String s로 초기화
        non_member_label = new JLabel[2];
        for(int i = 0; i<non_member_label.length; i++){
            non_member_label[i]=new JLabel(s[i]);
        }

        //멤버 패널 초기화
        non_member_panel = new JPanel[2];
        for(int i=0; i<non_member_panel.length; i++){
            non_member_panel[i] = new JPanel(new BorderLayout());
        }
        //나머지 초기화
        non_membership_panel = new JPanel();
        join_button = new JButton(new ImageIcon("Movie/src/img/MembershipView/Join.png"));
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
        non_member_field[1].addActionListener(new EventListner());

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

            Object input = e.getSource();

            if (input.equals(join_button) || input.equals(non_member_field[1])) {
                doRegist();
                System.out.println("가입");
                dispose();
            }
            if(input.equals(before_button)){
                System.out.println("이전");
                dispose();
            }
        }
    }

    /**
     * 레지스트 버튼 클릭 뷰
     */
    public void doRegist(){
        try{
            String tel = non_member_field[0].getText();
            Date birth = dateFormat.parse(non_member_field[1].getText()); // Util.date 포맷으로 생년월일 변경해서 birth에 저장

            validationTel(tel);
            validationDate(non_member_field[1].getText());

            java.sql.Date sqlBirth = new java.sql.Date(birth.getTime());        // sql.date 포맷으로 변경
            MemberVO memberVo = new MemberVO(tel,sqlBirth);
            memberDao.regist(memberVo,2); // 2를 넘겨줌으로써 regist메소드에서 비회워예매로 인식

            reserveVo.setNon_member_tel(tel);
            new MovieView(reserveVo);
        }catch (Exception e){
            System.out.println("회원가입 실패 : " + e.toString());
        }
    }
    /**
     *  연락처 유효성체크
     */
    public boolean validationTel(String tel){
        boolean flag = false;
        Pattern pattern = Pattern.compile("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$");
        Matcher matcher = pattern.matcher(tel);
        if (matcher.matches()) {
            flag = true;
        }else{
            flag = false;
        }
        if (!flag) {
            JOptionPane.showMessageDialog(null,"전화번호 형식에 맞게 작성해주세요");
        }
        return flag;
    }

    /**
     * 생년월일 유효성체크
     */
    public boolean validationDate(String date) {
        try {
            dateFormat.setLenient(false);
            dateFormat.parse(date);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "생년월일이 유효하지않음");
            return false;
        }
    }
}
