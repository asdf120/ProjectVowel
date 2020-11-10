package movie.view.admin;

import movie.data.AdminDAO;
import movie.data.MovieDAO;
import movie.data.vo.MovieVO;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class A_TimeTableView extends JPanel {

    //테이블 모델 구성
    class MovieTableModel extends AbstractTableModel{

        ArrayList data = new ArrayList();
        String[] columnNames = {"영화 제목", "러닝 타임", "감독", "출연진"};

        public int getRowCount() {
            return data.size();
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public Object getValueAt(int row, int col) {
            ArrayList temp = (ArrayList)data.get(row);
            return temp.get(col);
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }
    }

    //변수 선언
    JTextField[] tf_field;

    JLabel[] l_label;
    JPanel[] p_panel;

    JButton b_Add, b_Delete, b_Search;

    JComboBox comMovieSearch;
    JTable table_member;

    MovieTableModel tableModel;

    JPanel p_combo;
    JPanel p_table;

    JTextField tf_combo;

    //x,y,z setbounds 배열 초기화시 사용
    int y=50;

    int p_x = 105;
    int p_y = 120;
    int p_z = 245;
    int p_zz= 30;


    String [] cbSearchStr = {"영화제목","감독","출연진"}; //콤보박스 카테고리
    String[] s = new String[]{"영화 제목     ", "러닝 타임     ","시작 날짜     ", "종료 날짜     ", "감독              ", "출연진          ", "이미지 경로 "};

    MovieDAO movieDao;
    AdminDAO dao;

    public A_TimeTableView(){
        addlayout();
        try{
            movieDao = new MovieDAO();
            System.out.println("TimeTableView 디비연결 성공");
        }catch (Exception e){
            System.out.println("TimeTableView 디비연결 실패 " + e.toString());
        }
        try {
            dao = new AdminDAO();
            System.out.println("TimeTableView 디비연결 성공 어드민 ");
        } catch (Exception e) {
            System.out.println("TimeTableView 디비연결 실패 어드민 " + e.toString());
            e.printStackTrace();
        }

    }

    private void addlayout() {
        comMovieSearch = new JComboBox(cbSearchStr);

        tableModel = new MovieTableModel();
        table_member = new JTable(tableModel);

        p_table = new JPanel();
        p_combo = new JPanel();

        tf_field = new JTextField[7];
        l_label = new JLabel[7];
        p_panel = new JPanel[7];
        tf_combo = new JTextField();

        b_Search = new JButton(new ImageIcon("src/img/admin/검색.png"));

        //초기화
        for (int i = 0; i < p_panel.length; i++) {
            p_panel[i] = new JPanel(new BorderLayout());
            tf_field[i] = new JTextField();
            l_label[i] = new JLabel(s[i]);
        }

        //패널에 라벨 추가
        for(int i=0; i<p_panel.length; i++){
            p_panel[i].add(l_label[i], BorderLayout.WEST);
            p_panel[i].add(tf_field[i], BorderLayout.CENTER);
            p_panel[i].setBackground(Color.white);
            p_panel[i].setBounds(p_x,p_y,p_z,p_zz);
            p_y+=40;
            add(p_panel[i]);
        }


        p_combo.setLayout(null);
        p_combo.setBounds(480,50, 500,200);

        comMovieSearch.setBounds(25, 25, 80, 30);
        tf_combo.setBounds(105, 25, 200, 30);
        b_Search.setBounds(320, 25, 80, 30);
        p_combo.setBackground(Color.white);


        p_table.setBounds(400,130, 600, 500);
        p_table.setBackground(Color.white);
        table_member.setBackground(Color.white);
        b_Add = new JButton("추가");
        b_Delete = new JButton("삭제");

        b_Add.addActionListener(new EventListner());
        b_Delete.addActionListener(new EventListner());
        b_Search.addActionListener(new EventListner());
        tf_combo.addActionListener(new EventListner());

        p_combo.add(comMovieSearch);
        p_combo.add(tf_combo);
        p_combo.add(b_Search);
        p_table.add(new JScrollPane(table_member));

        setLayout(null);
        setBackground(Color.white);
        b_Add.setBounds(105, 430, 110, 50);
        b_Delete.setBounds(245, 430, 110, 50);
        b_Add.setBackground(Color.pink);
        b_Delete.setBackground(Color.pink);
        add(b_Add);
        add(b_Delete);
        add(p_table);
        add(p_combo);
    }

    //이벤트 핸들러
    class EventListner extends Component implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Object input = e.getSource();

            if(input==b_Add){ //영화 추가 버튼을 눌렀을 때
                System.out.println("추가");
                doRegist();
            }

            if (input==b_Delete) {

                System.out.println("삭제");
                doDelete();
                //        JOptionPane.showMessageDialog(this, "삭제 성공!!", "삭제완료", JOptionPane.INFORMATION_MESSAGE);

            }
            if(input==b_Search||input==tf_combo) {//영화 검색 버튼 눌렀을 때
                searchMovie();
            }

        }
    }//end EventListner


    //영화 추가
    void doRegist() {

        try {
            MovieVO vo = new MovieVO();
            vo.setTitle(tf_field[0].getText());
            vo.setRun_time(Integer.parseInt(tf_field[1].getText()));
            vo.setEnd_day(tf_field[2].getText());
            vo.setDirector(tf_field[3].getText());
            vo.setActor(tf_field[4].getText());
            vo.setImg_loc(tf_field[5].getText());

            movieDao.regist(vo);
            System.out.println("영화 추가 실행됨");
        }catch (Exception e){
            System.out.println("영화 추가 실패" + e.toString());
        }


    }// end doRegist

    //영화 삭제

    void doDelete() {

        try {
            String title = tf_field[0].getText();

            movieDao.delete(title);
            System.out.println("영화 삭제 실행됨");
        }catch (Exception e){
            System.out.println("영화 삭제 실패" + e.toString());
        }

    }

    //영화 검색
    void searchMovie() {
        int idx = comMovieSearch.getSelectedIndex();
        String word = tf_combo.getText();
        try {
            ArrayList list = dao.searchMovie(idx,word);
            tableModel.data = list;
            table_member.setModel(tableModel);
            tableModel.fireTableDataChanged();
            System.out.println("영화검색 성공");
        } catch (Exception e) {
            System.out.println("영화검색 실패");
            e.printStackTrace();
        }

    }


}