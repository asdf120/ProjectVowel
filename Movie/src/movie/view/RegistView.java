package movie.view;

import movie.HintTextField;
import movie.data.MemberDAO;
import movie.data.vo.MemberVO;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class RegistView extends JFrame {

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

    MemberDAO memberDao;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");

    public RegistView(){
        super("회원가입");

        try{
            memberDao = new MemberDAO();
            System.out.println("RegistView 디비연결 성공");
        }catch (Exception e){
            System.out.println("RegistView 디비연결 실패 " + e.toString());
        }

        String s[] = new String[] {"아이디         ", "비밀번호     " ,"이름             ", "전화번호     ", "이메일         ", "생년월일     "};

        //텍스트필드 이메일까지 초기화 생년월일은 따로 초기화
        member_field = new HintTextField[6];
        for(int i = 0; i<member_field.length; i++){
            member_field[i] = new HintTextField("");
        }
        member_field[3] = new HintTextField("000-0000-0000 방식으로 표기");
        member_field[5] = new HintTextField("6자리 숫자로 표기");

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
        join_button = new JButton(new ImageIcon("Movie/src/img/MemberShipView/Join.png"));
        before_button = new JButton(new ImageIcon("Movie/src/img/before.png"));
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
        member_field[5].addActionListener(new EventListner());

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

            Object input = (Object) e.getSource();

            if (input.equals(join_button) || input.equals(member_field[5])) {   // 가입 버튼 클릭 또는 생년월일까지 입력후 엔터
                doRegist();
            }else if(input.equals(before_button)){
                System.out.println("이전");
                dispose();  //프레임 종료

            }
        }
    }

    /**
     * 레지스트 버튼 클릭 뷰
     */
    public void doRegist(){
        try{
            String id = member_field[0].getText();
            String password = member_field[1].getText();
            String name = member_field[2].getText();
            String tel =member_field[3].getText();
            String email = member_field[4].getText();

            validationTel(tel); //전화번호 유효성검증
            validationEmail(email); // 이메일 유효성 검증
            validationDate(member_field[5].getText());  // 생년월일 유효성

            Date birth = dateFormat.parse(member_field[5].getText()); // Util.date 포맷으로 생년월일 변경해서 birth에 저장
            System.out.println("143행" + birth);
            java.sql.Date sqlBirth = new java.sql.Date(birth.getTime());        // sql.date 포맷으로 변경

            MemberVO memberVo = new MemberVO(id,password,name,tel,sqlBirth,email);
            memberDao.regist(memberVo,1);
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
     * 이메일 유효성체크
     */
    public boolean validationEmail(String email){
        boolean flag = false;
        if(email == null){
            return flag;
        }else{
            Pattern pattern = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                flag = true;
            }
        }
        if (!flag) {
            JOptionPane.showMessageDialog(null,"이메일 형식에 맞게 작성해주세요");
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
