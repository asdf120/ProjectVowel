package movie.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;

public class SeatCountView extends JFrame {

    String title;
    String info;
    String movie_Time;

    JButton[] b_Normal;
    JButton[] b_Teenager;
    JButton[] b_Benefit;
    JButton b_seatChoose;
    JButton b_before;
    JPanel p_SeatCount, p_Imgpanel;
    JLabel l_Imglabel;

    JLabel[] l_Label;

    public SeatCountView(String title, String info, String movie_Time){
        super("인원 선택");
        this.title = title;
        this.info = info;
        this.movie_Time = movie_Time;

        b_seatChoose = new JButton(new ImageIcon("Movie/src/img/좌석선택.png"));
        b_before = new JButton(new ImageIcon("Movie/src/img/이전.png"));
        l_Imglabel = new JLabel(new ImageIcon( "Movie/src/img/좌석내용.png"));

        b_Normal = new JButton[8];
        b_Teenager = new JButton[8];
        b_Benefit = new JButton[8];
        l_Label = new JLabel[3];

        p_SeatCount = new JPanel();
        p_Imgpanel = new JPanel();

        p_SeatCount.setLayout(null);

        p_Imgpanel.setBounds(10, 150, 350,100);
        b_before.setBounds(0, 380, 180, 40);
        b_seatChoose.setBounds(190, 380, 180, 40);

        p_Imgpanel.add(l_Imglabel);
        p_Imgpanel.setBackground(Color.white);

        p_SeatCount.add(b_seatChoose);
        p_SeatCount.add(b_before);

        p_SeatCount.add(p_Imgpanel);

        add(p_SeatCount);
        p_SeatCount.setBackground(Color.white);
        setSize(380,460);
        setVisible(true);
    }

}
