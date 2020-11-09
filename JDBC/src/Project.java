import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class GUI extends JFrame
{
	JButton[] jb = new JButton[11];
	JLabel[] jl = new JLabel[3];
	JTextArea ja;
	JTextArea ja2;
	//list대신 table로 변경할 것 
	//JList list;
	//DefaultListModel listModel;
	JTable table;
	DefaultTableModel model;
	int index;
	//JButton String의 라인을 바꾸는데에는 \n대신 <html><p></html>을 사용하면 된다. 생각보다 안이뻐서 바꾸었다.
	String[] menu = {"치킨 8000", "피자 8000", "돈까스 6000", "떡볶이 4000", "도시락 5000", "부대찌개 6000", "국밥 6000", "보쌈 18000", "족발 18000"};
	
	ImageIcon[] icon = new ImageIcon[9]; 
	Image[] img = new Image[9];
	Image[] changeImg = new Image[9];
	ImageIcon[] changeIcon = new ImageIcon[9];
	
	
	GUI()
	{
		//객체생성
		super("오늘 저녁 뭐 먹지? 주문 메뉴판");

		for(int i=0; i<9; i++) {//이미지 생성 및 크기 조정
			icon[i]= new ImageIcon("src/team_project/img/"+Integer.toString(i)+".JPG");
			img[i]= icon[i].getImage();
			changeImg[i] = img[i].getScaledInstance(280, 150, Image.SCALE_SMOOTH);
			changeIcon[i] = new ImageIcon(changeImg[i]);
			
		}
		
		
		for(int i = 0; i < 9; i++)
		{
			jb[i] = new JButton(menu[i], changeIcon[i]);
			jb[i].setFont(new Font("맑은 고딕", Font.BOLD, 20));
			jb[i].setVerticalTextPosition(JButton.BOTTOM);
			jb[i].setHorizontalTextPosition(JButton.CENTER);
		}
		
		jb[9] = new JButton("구매");
		jb[10] = new JButton("전부 제거");
		
//		jl[0] = new JLabel("메뉴");
//		jl[1] = new JLabel("선택 목록");
		jl[2] = new JLabel("결제 금액 : ");
		jl[2].setFont(new Font("고딕", Font.BOLD, 50));
		
		ja = new JTextArea("0원");
		ja.setFont(new Font("고딕", Font.BOLD, 50));
		
//		list = new JList(new DefaultListModel());
//		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		listModel = (DefaultListModel)list.getModel();
//		list.setFont(new Font("고딕",Font.BOLD,14));
		String[] str = {"메뉴", "갯수", "가격"};
		String[][] list = new String[13][3];
		model = new DefaultTableModel(list, str);
		table = new JTable(model);
		table.setFont(new Font("고딕", Font.BOLD, 20));
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setFont(new Font("고딕", Font.BOLD, 30));
		table.getTableHeader().setPreferredSize(new Dimension(50, 30));
		table.setRowHeight(30);
		//모든 테이블값을 Edit불가능하게 설정
		table.setDefaultEditor(Object.class, null);
	}
	void output() 
	{
		//화면 배치
		
		setLayout(new BorderLayout());
		
		//중앙에 메뉴9개
		JPanel c = new JPanel();
		c.setLayout(new GridLayout(3,3));
		for (int i=0 ; i<9; i++) {
			c.add(jb[i]);
		}
		add(c, BorderLayout.CENTER);
		
		//오른쪽에 선택목록, 결제할 금액, 구매,취소 버튼
		
		//큰 패널에 3행1열
		//작은패널에 구매취소 버튼 1행2열
		JPanel e1 = new JPanel();
		
		e1.setLayout(new GridLayout(1,2));
		e1.add(jb[9]);
		e1.add(jb[10]);
		
		JPanel e = new JPanel();
		JPanel listp = new JPanel();
		JPanel areap = new JPanel();
		e.setPreferredSize(new Dimension(500, 600));
		
		e.setLayout(new BorderLayout());
		listp.setLayout(new BorderLayout());
		//listp.add(jl[1], BorderLayout.NORTH);
		JScrollPane js = new JScrollPane(table);
		js.setSize(100, 100);
		listp.add(js);
		//listp.add(table);
		areap.setLayout(null);
		jl[2].setBounds(10, 5, 1000, 100);
		ja.setBounds(280, 18, 1000, 100);
		areap.add(jl[2]);
		areap.add(ja);
		e.add(listp, BorderLayout.NORTH);
		e.add(areap, BorderLayout.CENTER);
		e.add(e1, BorderLayout.SOUTH);
		
		add(e,BorderLayout.EAST);
		
		setBounds(200, 100, 1350, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void eventProc()
	{
		BtnHandler btn = new BtnHandler();
		MosHandler mos = new MosHandler();
		//사용할 버튼.add~~(btn); 사용 할것.
		for(int i = 0; i < 11; i++)
			jb[i].addActionListener(btn);
		table.addMouseListener(mos);
	}
	
	class BtnHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//모든 이벤트
			JButton evt = (JButton)e.getSource();
			String select = evt.getText();
			
			if(select.equals("구매") || select.equals("전부 제거"))
			{
				if(select.equals("구매"))
				{
					if(ja.getText().equals("0원"))						
					{
						JOptionPane.showMessageDialog(null, "주문을 하시고 눌러주세요!");
						return;
					}
					JOptionPane.showMessageDialog(null, "주문 완료 되었습니다. \n조금만 기다려주시면 가져다 드리겠습니다.");
				}
				for(int i = 0; i < index; i++)
				{
					model.removeRow(0);
					String[] temp = {"", ""};
					model.insertRow(model.getRowCount(), temp);
				}
				index = 0;
			}
			else
			{
				//select.split(" ")[0]; split을 사용하여 " "전후로 나누었다. 즉, 이름과 가격으로 나눈것.
				//해당 이름이 목록에 있는지 확인
				Boolean ev = false;
				int num = 0;
				//반복적으로 split을 불러오는걸 막기 위함
				String[] getName = select.split(" ");
				for(int i = 0; i < index; i++)
					if(table.getValueAt(i, 0).equals(getName[0]))
					{
						ev = true;
						num = i;
						break;
					}
				if(ev)
				{
					int temp = Integer.parseInt(table.getValueAt(num, 1).toString())+1;
					table.setValueAt(Integer.toString(temp), num, 1);
					table.setValueAt(temp * Integer.parseInt(getName[1]), num, 2);
				}
				else
				{
					table.setValueAt(getName[0], index, 0);
					table.setValueAt("1", index, 1);
					table.setValueAt(getName[1], index++, 2);
				}
			}
			refresh();
			
		}
	}

	class MosHandler extends MouseAdapter implements MouseListener
	{
		public void mouseClicked(MouseEvent e)
		{
			//2로 했을경우 마우스 클릭간 term이 짧을경우 초기화가 안되기 때문에 2의 배수로 지정.
			if(e.getClickCount() % 2 == 0)
			{
				int temp = table.getSelectedRow();
				//예외처리.
				if(table.getValueAt(temp, 1)==null)
					return;
				if(table.getValueAt(temp, 1).equals("1"))
				{
					model.removeRow(temp);
					String[] str = {"", ""};
					model.insertRow(model.getRowCount(), str);
					index--;
				}
				else
				{
					int cal = Integer.parseInt(table.getValueAt(temp, 1).toString());
					table.setValueAt(Integer.toString(cal-1), temp, 1);
					table.setValueAt((Integer.parseInt(table.getValueAt(temp, 2).toString())/cal)*(cal-1), temp, 2);
				}
				refresh();
			}
		}
	}
	
	void refresh()
	{
		int cal = 0;
		for(int i = 0; i < index; i++)
		{
			cal += Integer.parseInt(table.getValueAt(i, 2).toString());
		}
		
		ja.setText(Integer.toString(cal)+"원");
	}
}

public class Project
{
	public static void main(String[] args) 
	{
		GUI gui = new GUI();
		gui.output();
		gui.eventProc();
	}
}
