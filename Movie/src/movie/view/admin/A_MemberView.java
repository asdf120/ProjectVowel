package movie.view.admin;

import movie.data.AdminDAO;
import movie.data.vo.MemberVO;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class A_MemberView extends JPanel implements ActionListener{
	
	//	member field
	JButton b_regist, b_modify, b_searchMember,b_searchReserve,b_cancelReserve,b_deleteMember;
	JTextField tf_Id,tf_Name,tf_Tel,tf_Birth,tf_Email,tf_SearchMember,tf_SearchReserve;
	JPasswordField tf_Pw, tf_PwConfirm;
	JTextArea ta_reserveComfirm;
	
	JTable table_member;
	JComboBox comMemberSearch;
	MemberTableModel tableModel;
	
	//날짜 포맷 변경(sql에 맞게)
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
	
	//모델단 - 비즈니스 로직
	AdminDAO dao;
	
	//constructor
	public A_MemberView() {
		addlayout();
		eventProc();
		
	}
	
	/*
	 * 화면에 테이블 붙이는 메소드 
	 */
		class MemberTableModel extends AbstractTableModel { 
			  
			ArrayList data = new ArrayList();
			String [] columnNames = {"아이디","이름","전화번호","생년월일"};

			    public int getColumnCount() { 
			        return columnNames.length; 
			    } 
			    public int getRowCount() { 
			        return data.size(); 
			    } 
			    public Object getValueAt(int row, int col) { 
					ArrayList temp = (ArrayList)data.get( row );
			        return temp.get( col ); 
			    }
			    public String getColumnName(int col){
			    	return columnNames[col];
			    }
		}
	
	/*
	 * 레이아웃 구성
	 */
	void addlayout() {
		//모델단 객체 생성
		try {
			dao = new AdminDAO();
			System.out.println("DB 연결성공 : AdminDAO");
		} catch (Exception e) {
			System.out.println("DB 연결실패 :"+e.toString());
			e.printStackTrace();
		}
		
		//멤버변수 객체생성
		b_regist = new JButton("가입");
		b_modify = new JButton("수정");
		b_searchMember = new JButton("검색");
		b_searchReserve = new JButton("예매 검색");
		b_cancelReserve = new JButton("예매 취소");
		b_deleteMember = new JButton("삭제");
		
		tf_Id = new JTextField();
		tf_Name = new JTextField();
		tf_Tel= new JTextField();
		tf_Birth = new JTextField();
		tf_Email = new JTextField();
		tf_SearchMember = new JTextField(20);
		tf_SearchReserve = new JTextField(20);
		
		tf_Pw = new JPasswordField();
		tf_PwConfirm = new JPasswordField();
		
		String [] cbSearchStr = {"이름","전화번호","아이디","생년월일"};
		comMemberSearch = new JComboBox(cbSearchStr);
		
		ta_reserveComfirm = new JTextArea();
		
		tableModel = new MemberTableModel();
		table_member = new JTable(tableModel);
		
	//*********화면구성 ******************
		
		 setLayout(new GridLayout(1,2));
		 
		 //왼쪽 영역 (정보 관리)
		 JPanel left = new JPanel(new BorderLayout());
		 left.setBorder(new TitledBorder("정보 관리"));
		 
		 //회원가입 텍스트필드 판넬
		 JPanel leftUp = new JPanel(new GridLayout(3,4));
		 	leftUp.add(new JLabel("아이디"));
		 	leftUp.add(tf_Id);
		 	leftUp.add(new JLabel("이름"));
		 	leftUp.add(tf_Name);
		 	leftUp.add(new JLabel("비밀번호"));
		 	leftUp.add(tf_Pw);
		 	leftUp.add(new JLabel("전화번호"));
		 	leftUp.add(tf_Tel);
		 	leftUp.add(new JLabel("비밀번호 확인"));
		 	leftUp.add(tf_PwConfirm);
		 	leftUp.add(new JLabel("생년월일"));
		 	leftUp.add(tf_Birth);
		 	left.add(leftUp,BorderLayout.NORTH);
		 	
		 	//회원 관리 버튼과 예매내역 텍스트에리어
		 	JPanel leftCenter = new JPanel(new BorderLayout());
		 		JPanel leftCenter1 = new JPanel(); // 회원 가입, 수정 버튼, 삭제 버튼
		 		leftCenter1.add(b_regist);
		 		leftCenter1.add(b_modify);
		 		leftCenter1.add(b_deleteMember);
		 		leftCenter.add(leftCenter1,BorderLayout.NORTH);
		 	leftCenter.add(new JLabel("예매내역"),BorderLayout.WEST);
		 	leftCenter.add(ta_reserveComfirm,BorderLayout.CENTER);
		 	left.add(leftCenter,BorderLayout.CENTER);
		 	
		 	//예매번호 검색 판넬
		 	JPanel leftDown = new JPanel();
		 	leftDown.add(tf_SearchReserve);
		 	leftDown.add(b_searchReserve);
		 	leftDown.add(b_cancelReserve);
		 	left.add(leftDown,BorderLayout.SOUTH);
		
		 //오른쪽 영역 (검색)
		JPanel right = new JPanel(new BorderLayout());
		right.setBorder(new TitledBorder("검색"));
		
		//검색 버튼 영역
		JPanel rightUp = new JPanel();
		rightUp.add(comMemberSearch);
		rightUp.add(tf_SearchMember);
		rightUp.add(b_searchMember);
		right.add(rightUp,BorderLayout.NORTH);
		
		// 검색 테이블 영역
		JPanel rightCenter = new JPanel(new BorderLayout());
		rightCenter.add(new JScrollPane(table_member));
		right.add(rightCenter,BorderLayout.CENTER);
		
		
		add(left);
		add(right);
	}

	/*
	 * 버튼이랑 이벤트 연결
	 */
	void eventProc() {
		b_modify.addActionListener(this);
		b_regist.addActionListener(this);
		b_searchMember.addActionListener(this);
		b_deleteMember.addActionListener(this);
		tf_SearchMember.addActionListener(this);
		
		//JTable 을 클릭했을 떄,
		table_member.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int col =0;
				int row = table_member.getSelectedRow();//눌려진 곳 행 값
				String id = (String)table_member.getValueAt(row, col);// 눌려진 곳의 아이디 
				System.out.println(id);
				
				MemberVO vo ;
				try {
					vo = dao.searchByID(id);
					tf_Birth.setText(dateFormat.format(vo.getBirth()));
					tf_Email.setText(vo.getEmail());
					tf_Id.setText(vo.getMember_id());
					tf_Pw.setText(vo.getPassword());
					tf_PwConfirm.setText(vo.getPassword());
					tf_Name.setText(vo.getName());
					tf_Tel.setText(vo.getTel());
					System.out.println("회원정보 띄우기 성공");
					
				} catch (Exception e1) {
					System.out.println("회원정보 띄우기 실패");
					e1.printStackTrace();
				}
				

			
			}
		});
	}
	
	//이벤트 처리
	public void actionPerformed(ActionEvent e) {
		Object evt = e.getSource();
		if(evt==b_regist) { //회원가입 버튼 눌렀을 때
			boolean b = registConfirm();
			if(b==true) {
				insertMember();
				selectAll(); //회원목록 노출
				clearTextFields(); 
				JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!");
			}
			
		}else if(evt==b_modify) {//회원수정 버튼 눌렀을 때
			modifyMember();
			clearTextFields();
			JOptionPane.showMessageDialog(null, "회원정보 수정이 완료되었습니다.");
			
		}else if(evt==b_deleteMember) { //회원삭제 버튼 눌렀을 때
			deleteMember();
			selectAll();
			clearTextFields();
		}
		
		else if(evt==b_searchMember || evt==tf_SearchMember) { //검색 버튼 눌렀을 때
			searchMember();
			
		}else if(evt==b_searchReserve || evt == tf_SearchReserve) { //예매검색 시
			searchReserve();
		}
	}
	
	/**
	 *  뷰 : A_MemberView
	 *  역할  : 입력받은 아이디가 DB에 이미 존재하는지 여부 확인하여 중복이 아니면 true, 중복이면 false 리턴
	 */
	boolean memberIDconfirm() {
		boolean b = true;
		
		try {
			int result = dao.idConfirm(tf_Id.getText());
			System.out.println("아이디 중복확인 성공");
			if(result == 0) {
				return b;
			}else if(result ==-1) {
				b = false;
			}
		} catch (Exception e) {
			System.out.println("아이디 중복확인 실패");
			e.printStackTrace();
		}
		return b;
	}
	
	/**
	 *  뷰 : A_MemberView
	 *  역할  : 입력받은 전화번호가 DB에 이미 존재하는지 여부 확인하여 중복이 아니면 true, 중복이면 false 리턴
	 */
	boolean memberTelConfirm() {
		boolean b = true;
		
		try {
			int result = dao.telConfirm(tf_Tel.getText());
			System.out.println("전화번호 중복확인 성공");
			if(result == 0) {
				return b;
			}else if(result ==-1) {
				b = false;
			}
		} catch (Exception e) {
			System.out.println("전화번호 중복확인 실패");
			e.printStackTrace();
		}
		return b;
	}
	
	/**
	 *  뷰 : A_MemberView
	 *  역할 : insertMember()가 실행되기 전 중복이나 빈칸 확인하여 정상이면 true, 문제 있으면 false 반환
	 */
	boolean registConfirm() {
		boolean b = false;
		if(tf_Birth!=null&&tf_Email!=null&&tf_Id!=null&&tf_Name!=null&&tf_Tel!=null
				&&tf_Pw!=null&&tf_PwConfirm!=null&&tf_Pw.getText().equals(tf_PwConfirm.getText())&&memberIDconfirm()&&memberTelConfirm()) {
			b = true;
		}else if(tf_Birth==null||tf_Email==null||tf_Id==null||tf_Name==null||tf_Pw==null||tf_PwConfirm==null||tf_Tel==null) {//빈칸이 있을 때
			JOptionPane.showMessageDialog(null, "모든 항목을 입력해주세요.");
		}else if(tf_Pw.getText().equals(tf_PwConfirm.getText()) == false){ //비밀번호와 비밀번호 확인이 일치하지 않으면
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
		}else if(memberIDconfirm() == false) {	//중복된 아이디를 입력하면
			JOptionPane.showMessageDialog(null, "이미 사용중인 아이디 입니다."); 
		}else if(memberTelConfirm() == false) { //중복된 전화번호를 입력하면
			JOptionPane.showMessageDialog(null, "이미 등록된 전화번호 입니다.");
			
		}
		return b;
	}
	
	/**
	 *  뷰 : A_MemberView
	 *  역할 : 회원 가입을 위해 사용자 입력값을 받아서  모델로 전달
	 */
	void insertMember() {
			MemberVO vo = new MemberVO();
			try {
				vo.setName(tf_Name.getText());
				vo.setPassword(tf_Pw.getText());
				Date birth = dateFormat.parse(tf_Birth.getText());
				vo.setBirth(new java.sql.Date(birth.getTime()));
				vo.setMember_id(tf_Id.getText());
				vo.setTel(tf_Tel.getText());
				vo.setEmail(tf_Email.getText());
			} catch (ParseException e) {
				System.out.println("입력 실패");
			}
			try {
				dao.regist(vo);
				System.out.println("회원가입 성공");
			} catch (Exception e) {
				System.out.println("회원가입 실패");
				e.printStackTrace();
			}
	}
	
	/**
	 * 	뷰 : A_MemberView
	 *  역할 : 콤보박스의 값과 검색키워드를 가져와 해당하는 값들 JTable에 출력
	 */
	void searchMember() {
		int idx = comMemberSearch.getSelectedIndex();
		String word = tf_SearchMember.getText();
		if(idx==3) {
			try {
				ArrayList data = dao.searchMember1(idx, word);
				tableModel.data = data;
				table_member.setModel(tableModel);
				tableModel.fireTableDataChanged();
				System.out.println("생년월일로 검색 성공");
			} catch (Exception e) {
				System.out.println("생년월일로 검색 실패");
				e.printStackTrace();
			}
		}
		else {
		try {
			ArrayList data = dao.searchMember(idx,word);
			tableModel.data = data;
			table_member.setModel(tableModel);
			tableModel.fireTableDataChanged();
			System.out.println("회원검색 성공");
			
		} catch (Exception e) {
			System.out.println("회원검색 실패"+e.toString());
			e.printStackTrace();
			}
		}
	}
	/**
	 * 	뷰 : A_MemberView
	 *  역할 : 회원가입 tf들에서 값 받아와 회원정보 수정
	 */
	void modifyMember() {
		MemberVO vo = new MemberVO();
	
		try {
			Date date = dateFormat.parse(tf_Birth.getText());
			vo.setMember_id(tf_Id.getText());
			vo.setBirth(new java.sql.Date(date.getTime()));
			vo.setEmail(tf_Email.getText());
			vo.setName(tf_Name.getText());
			vo.setTel(tf_Tel.getText());
			vo.setPassword(tf_Pw.getText());
			
		} catch (ParseException e) {
			System.out.println("306열 에러");
			e.printStackTrace();
		}
		
		try {
			dao.modifyMember(vo);
			System.out.println("회원정보 수정 성공");
			
		} catch (Exception e) {
			System.out.println("회원정보 수정 실패");
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 	뷰 : A_MemberView
	 *  역할 : 입력된 전화번호 얻어와 회원정보 DB에서 삭제
	 */
	void deleteMember() {
		String tel = tf_Tel.getText();
		try {
			dao.deleteMember(tel);
			System.out.println("회원삭제 성공");
		} catch (Exception e) {
			System.out.println("회원삭제 실패");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 	뷰 : A_MemberView
	 *  역할 : 예매번호를 얻어와 예매내역 출력
	 */
	void searchReserve() {
		String rNum = tf_SearchReserve.getText();
		if(rNum != null) {
		try {
			ArrayList Reservelist = dao.searchReserve(rNum);
			
			if(Reservelist.size()>0) //받아온 리스트의 내용이 있으면 내역 출력
			{
			for(int i =0;i<Reservelist.size();i++) {
				String s = (String)Reservelist.get(i);
				ta_reserveComfirm.setText(s+"\n");
			}
			System.out.println("예매내역 검색 성공");
			}
			
			else if(Reservelist.size()==0) { // 받아온 리스트의 내용이 없으면 에러 메세지
				JOptionPane.showMessageDialog(null, "예매내역이 존재하지 않습니다.");
			}
		} catch (Exception e) {
			System.out.println("예매내역 검색 실패");
			e.printStackTrace();
			}
		}else if(rNum == null) {
			JOptionPane.showMessageDialog(null, "예매번호를 입력해주세요.");
		}
		
	}
	
	
	/**
	 * 	뷰 : A_MemberView
	 *  역할 : member테이블의 값을 가져와 JTable에 출력
	 */
	void selectAll() {
		try {
			ArrayList data = dao.select();
			tableModel.data = data; //가져온 데이터를 테이블모델에 넣음
			tableModel.fireTableDataChanged(); // 테이블모델에서 내용 바뀌었다고 신호보냄
		} catch (Exception e) {
			System.out.println("회원목록 검색 실패");
			e.printStackTrace();
		}
	}
	
	/**
	 * 	뷰 : A_MemberView
	 *  역할 : 텍스트필드에 값 입력 후 어떤 버튼 클릭 시 텍스트필드 초기화
	 */
	void clearTextFields() {
		tf_Birth.setText(null);
		tf_Email.setText(null);
		tf_Id.setText(null);
		tf_Name.setText(null);
		tf_Pw.setText(null);
		tf_PwConfirm.setText(null);
		tf_Tel.setText(null);
	}
	

}
