package movie;

import movie.view.admin.A_GraphView;
import movie.view.admin.A_MemberView;
import movie.view.admin.A_TimeTableView;

import javax.swing.*;

public class AdminStart extends JFrame {

    //멤버필드 - 뷰 클래스 선언
    A_MemberView member;
    A_TimeTableView timeTable;
    A_GraphView graph;


    public AdminStart() {
        // 뷰 클래스 객체 생성
        member = new A_MemberView();
        timeTable = new A_TimeTableView();
        graph = new A_GraphView();

        JTabbedPane  pane = new JTabbedPane();

        pane.addTab("회원 검색", member); //0
        pane.addTab("시간표 관리", timeTable); //1
        pane.addTab("관객수", graph); //3

        pane.setSelectedIndex(0); // 첫 화면에 뜨는 탭 (회원관리)

        getContentPane().add("Center", pane ); // 탭 중앙에 글자 위치
        pack();
        setSize(1000, 700);
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    public static void main(String[] args) {
        new AdminStart();
    }



}