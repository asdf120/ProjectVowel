package  videoshop.view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

public class RentView extends JPanel 
{
	JTextField tfRentTel, tfRentCustName,tfRentVideoNum,tfReturnVideoNum;
	JButton bRent, bReturn;
	JTable tableRecentList;
	TableRecentListModel tbRecentListModel;

	public RentView(){
		addLayout();
	}

	public void connectDB(){

	}

	public void addLayout() {
		//멤버변수의 객체 생성
		tfRentTel = new JTextField();
		tfRentVideoNum = new JTextField();
		tfRentCustName = new JTextField();
		tfReturnVideoNum = new JTextField(15);

		bRent = new JButton("대여");
		bReturn = new JButton("반납");

		tbRecentListModel = new TableRecentListModel();
		tableRecentList = new JTable(tbRecentListModel);

		//******** **********************************
		//화면구성 - 큰 틀부터 작은거
		setLayout(new BorderLayout());

		//위쪽 영역
		JPanel pNorth = new JPanel();
		pNorth.setLayout(new GridLayout(1,2));

		//위쪽의 왼쪽 (대여)
		JPanel pNorthWest = new JPanel(new BorderLayout());
		pNorthWest.setBorder(new TitledBorder("대여"));

		JPanel pNorthWest1 = new JPanel(new GridLayout(4,2));
		pNorthWest1.add(new JLabel("전 화 번 호"));
		pNorthWest1.add(tfRentTel);
		pNorthWest1.add(new JLabel("고 객 명"));
		pNorthWest1.add(tfRentCustName);
		pNorthWest1.add(new JLabel("비디오 번호"));
		pNorthWest1.add(tfRentVideoNum);
		pNorthWest1.add(bRent);
		pNorthWest.add(pNorthWest1,BorderLayout.CENTER);

		//위쪽의 오른쪽 (반납)
		JPanel pNorthEast = new JPanel();
		pNorthEast.setBorder(new TitledBorder("반납"));
		pNorthEast.add(new JLabel("비디오 번호"));
		pNorthEast.add(tfReturnVideoNum);
		pNorthEast.add(bReturn);

		pNorth.add(pNorthWest); //대여 부분  위쪽영역에 붙이기
		pNorth.add(pNorthEast); //반납 부분 위쪽영역에 붙이기

		//중앙 테이블 영역
		JPanel pCenter = new JPanel(new BorderLayout());
		pCenter.add(new JScrollPane(tableRecentList),BorderLayout.CENTER);

		add(pNorth,BorderLayout.NORTH);
		add(pCenter,BorderLayout.CENTER);

	}
	/**
	 * 이벤트 실행함수
	 */
	public void eventProc(){

	}
	class TableRecentListModel extends AbstractTableModel{
		ArrayList data = new ArrayList();
		String[] columnName = {"비디오번호","비디오제목","고객명","전화번호","반납예정일","반납여부"};

		@Override
		public int getColumnCount() {
			return columnName.length;
		}

		@Override
		public int getRowCount() {
			return data.size();
		}

		@Override
		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList)data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columnName[col];
		}
	}
}
