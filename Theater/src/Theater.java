package src;

import src.view.MemberView;
import src.view.MovieTime_View;
import src.view.ReserveView;

import javax.swing.*;

public class Theater extends JFrame {
    MemberView memberView;
    ReserveView reserveView;
    MovieTime_View movieTimeView;

    public Theater() {
        memberView = new MemberView();
        reserveView = new ReserveView();
        movieTimeView = new MovieTime_View();

        JTabbedPane pane = new JTabbedPane();
        pane.addTab("회원관리", memberView);
        pane.addTab("예매", reserveView);
        pane.addTab("영화관리",movieTimeView);

        pane.setSelectedIndex(2);

        getContentPane().add("Center",pane);
        pack();
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Theater();
    }
}
