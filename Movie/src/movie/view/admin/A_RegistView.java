package movie.view.admin;

import movie.HintTextField;
import movie.data.AdminDAO;
import movie.data.vo.ManagerVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class A_RegistView extends JFrame{

	//멤버변수 선언
	JButton b_regist;
	JTextField tf_pw,tf_name,tf_birth,tf_tel;
	
	//모델단
	AdminDAO dao;
	
	//날짜 타입 변환
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
	
	public A_RegistView() {
		super("관리자 등록");
		addlayout();
		eventProc();
		
	}
	void addlayout() {
		//객체 생성
		b_regist = new JButton("관리자 등록 완료");
		
		tf_pw = new JPasswordField();
		tf_name = new JTextField();
		tf_tel = new HintTextField("- 포함하여 입력");
		tf_birth = new HintTextField("예 )090201");
		
		try {
			dao = new AdminDAO();
			System.out.println("DB 연결 성공 : A_RegistView");
		} catch (Exception e) {
			System.out.println("DB 연결 실패 : A_RegistView");
			e.printStackTrace();
		}
		
		//**** 화면 구성 ****
		setVisible(true);
		setSize(400, 500);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		setLayout(new BorderLayout());
		
		JPanel center = new JPanel(new GridLayout(4,2)); //입력값 필드
		center.add(new JLabel("이름"));
		center.add(tf_name);
		center.add(new JLabel("전화번호"));
		center.add(tf_tel);
		center.add(new JLabel("생년월일"));
		center.add(tf_birth);
		center.add(new JLabel("비밀번호"));
		center.add(tf_pw);
		
		JPanel down = new JPanel(); //등록 버튼
		down.add(b_regist);
		
		add(center,BorderLayout.CENTER);
		add(down,BorderLayout.SOUTH);
		
	}
	
	//이벤트 핸들러 겸 연결
	void eventProc() {
		b_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mgrRegist();
				clearfd();
				dispose();
				
			}
		});
	}
	
	/*
	 * 역할 : 관리자 등록을 클릭 했을 때 얻어온 값들을 manager테이블에 레코드 생성
	 */
	void mgrRegist() {
		ManagerVO vo = new ManagerVO();
		try {
			vo.setMgrName(tf_name.getText());
			vo.setMgrTel(tf_tel.getText());
			Date birth;
			birth = dateFormat.parse(tf_birth.getText());
			java.sql.Date sqlBirth = new java.sql.Date(birth.getTime());
			vo.setMgrBirth(sqlBirth);
			vo.setMgrPW(tf_pw.getText());
			
			try {
				dao.regist(vo);
				JOptionPane.showMessageDialog(null, "등록이 완료되었습니다.");
				System.out.println("관리자 등록 성공");
			} catch (Exception e) {
				System.out.println("관리자 등록 실패");
				e.printStackTrace();
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 역할 : 텍스트필드 초기화
	 */
	void clearfd() {
		tf_name.setText(null);
		tf_pw.setText(null);
		tf_birth.setText(null);
		tf_tel.setText(null);
	}

}
