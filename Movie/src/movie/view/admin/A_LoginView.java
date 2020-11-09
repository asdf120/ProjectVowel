package movie.view.admin;

import movie.AdminStart;
import movie.HintTextField;
import movie.data.AdminDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A_LoginView extends JFrame implements ActionListener{
	//멤버필드 선언
	
	JButton b_login,b_regist,b_searchID;
	JTextField tf_id,tf_pw,tf_searchID,tf_resultID;
	
	//모델단 - 비즈니스로직
	AdminDAO dao;
	
	//constructor
	public A_LoginView() {
		super("CGV 관리자 로그인");
		try {
			dao = new AdminDAO();
			System.out.println("어드민 DB연결 성공 : A_LoginView");
		} catch (Exception e) {
			System.out.println("어드민 DB연결 실패 A_LoginView:"+e.toString());
			e.printStackTrace();
		}
		addlayout();
		eventProc();
		
		
	}
	//버튼이랑 이벤트 연결
	void eventProc() {
		b_login.addActionListener(this);
		b_regist.addActionListener(this);
		b_searchID.addActionListener(this);
		tf_id.addActionListener(this);
		tf_pw.addActionListener(this);
		tf_searchID.addActionListener(this);
		
	}
	
	//이벤트 핸들러
	public void actionPerformed(ActionEvent e) {
		Object evt = e.getSource();
		if(evt==b_login||evt==tf_pw) { //관리자 로그인 버튼 or 비밀번호입력 후 엔터 눌렀을 떄
			 mgrLogin();
		}else if(evt==b_regist) { //관리자 등록 버튼 눌렀을 때
			A_RegistView r = new A_RegistView(); //등록 화면으로 이동
		}else if(evt==tf_id) { //아이디 입력만 하고 엔터 눌렀을 때
			JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.");
		}else if(evt==b_searchID||evt==tf_searchID) { //사번찾기 버튼 클릭 or 전화번호 입력 후 엔터
			searchID();
		}
	}
	
	/*
	 * 역할 : 입력된 아이디와 비밀번호를 얻어와 manager테이블에 있는지 확인하여 있으면 로그인, 없으면 에러메세지 출력
	 */
	void mgrLogin() {
		
		String id = tf_id.getText();
		String pw = tf_pw.getText();
		try {
			int result = dao.login(id,pw);
			if(result ==0) {
				AdminStart start = new AdminStart(); //관리자 페이지 띄움
				dispose();
			}
			System.out.println("로그인 성공");
		} catch (Exception e) {
			System.out.println("로그인 실패");
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 역할 : 얻어온 전화번호를 이용하여  manager테이블에서 사원번호 가져오기. 있으면 사원번호 출력, 없으면 에러메세지
	 */
	void searchID() {
		String tel = tf_searchID.getText();
		try {
			String result = dao.searchID(tel);
			
			if(result == null) {
				JOptionPane.showMessageDialog(null, "등록되지 않은 전화번호 입니다.");
			}else {
			tf_resultID.setText(dao.searchID(tel));
			System.out.println("사원번호 검색 성공");
			}
		} catch (Exception e) {
			System.out.println("사원번호 검색 실패");
			e.printStackTrace();
		}
	}
	
	
	//레이아웃
	void addlayout() {
		
		// ****** 객체 생성 ********
		b_login = new JButton("관리자 로그인");
		b_regist = new JButton("관리자 등록");
		b_searchID = new JButton("사원번호 찾기");
		tf_id = new HintTextField("사원번호 입력");
		tf_pw = new HintTextField("비밀번호 입력");
		tf_resultID = new JTextField("",15);
		tf_searchID = new HintTextField("전화번호를 입력하세요");
		
		//***** 화면 구성 **********
		setVisible(true);
		setSize(400, 500);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		setLayout(new GridLayout(3,1));
		JPanel up = new JPanel(); // 로고 들어갈 곳
		
		JPanel center = new JPanel(new BorderLayout()); // 로그인 텍스트필드와 버튼
		JPanel center1 = new JPanel(new GridLayout(2,1)); //로그인 텍스트필드
		center1.add(tf_id);
		center1.add(tf_pw);
		center.add(center1,BorderLayout.CENTER);
		
		JPanel center2 = new JPanel(new GridLayout(1,2)); //버튼
		center2.add(b_login);
		center2.add(b_regist);
		center.add(center2,BorderLayout.SOUTH);
		
		JPanel down = new JPanel(new GridLayout(3,1)); //사번찾기 필드와 버튼
		down.add(new JLabel(""));
		down.add(tf_resultID);
			JPanel down2 = new JPanel();
			down2.add(tf_searchID);
			down2.add(b_searchID);
		down.add(down2);
		
		add(up);
		add(center);
		add(down);
		
	}
	
	public static void main(String[] args) {
		new A_LoginView();
	}

	
}
