package jtable;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class JtableTest extends JFrame { // JFrame의 defualt 레이아웃은 borderLayout
    // 멤버변수
    JButton btn;
    JTable table;

    MyTable_Model tableModel;

    public JtableTest() {
        // 객체생성
        btn = new JButton("확인");
        tableModel = new MyTable_Model();
        table = new JTable(tableModel);

        // 화면구성
        add(btn, BorderLayout.NORTH);
        add(new JScrollPane(table),BorderLayout.CENTER);    //TODO table 붙일때는 반드시 JScrollPane 쓸것

        // 화면출력
        setBounds(100,100,600,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 버튼 이벤트
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change();
            }
        });

        // jTable에 마우스 이벤트
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                System.out.println(row + " : " + col);
            }
        });

    } // end of JtableTest();

    void change(){
        // 나중에 DB에서 데이터를 가져왔다고 가정
        ArrayList data = new ArrayList();
        for(int i = 0; i<5; i++){
            ArrayList temp = new ArrayList();
            for(int j=0; j<4; j++){
                temp.add(i+ ", " + j);
            }
            data.add(temp);
        }

        tableModel.list=data;
        table.setModel(tableModel);
        tableModel.fireTableDataChanged();
    }

    // 테이블모델 - JTable의 데이터를 관리
    class MyTable_Model extends AbstractTableModel {
        ArrayList list = new ArrayList<>(); // 실제 저장될 값
        String[] columnNames = {"하나","둘","Third","4"};

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return list.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            ArrayList temp = (ArrayList)list.get(rowIndex);
            return temp.get(columnIndex);
        }

        @Override
        public String getColumnName(int column) {   // 사용자가 지정한 컬럼이름 지정하는 함수
            return columnNames[column];
        }

    }

    public static void main(String[] args) {
        new JtableTest();
    }
}
