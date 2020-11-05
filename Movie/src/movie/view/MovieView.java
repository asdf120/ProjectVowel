package movie.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovieView extends JFrame{

    JPanel movie_panel;
    JLabel title_label;
    JButton before_button, mypage_button;
    JButton movie_button[];

    //영화 좌표값들 임의설정
    int x = 50;
    int y = 120;
    int z = 150;
    int zz = 200;

    public MovieView() {
        super("영화 목록");
        movie_panel = new JPanel();
        movie_button = new JButton[6];
        before_button = new JButton(new ImageIcon("Movie/src/img/before.png"));
        mypage_button = new JButton(new ImageIcon("Movie/src/img/RegistView/마이페이지.png"));
        title_label = new JLabel("현재 상영작");

        //영화 버튼 초기화
        for(int i=0; i<movie_button.length; i++){
            movie_button[i] = new JButton(new ImageIcon("Movie/src/img/MovieView/"+i+".png"));
        }


        //영화패널, 라벨, 버튼 좌표, 사이즈
        movie_panel.setLayout(null);
        title_label.setBounds(200,50,70,50);
        before_button.setBounds(180,780,100,40);
        mypage_button.setBounds(400,0,74,32);
        mypage_button.setBackground(Color.white);

        //패널에 라벨 버튼 추가
        movie_panel.add(title_label);
        movie_panel.add(before_button);
        movie_panel.add(mypage_button);


        //영화 배열 버튼 좌표, 사이즈
           for(int i=0; i<movie_button.length; i++){
               movie_button[i].setBounds(x, y, z, zz);
               if(i%2==1){
                   x=50;
                   y+=210;
               }
               else  x+=210;

            System.out.println(y);
        }

           //패널에 버튼 추가
        for(int i=0; i<movie_button.length; i++) {
            movie_panel.add(movie_button[i]);
        }

        // 메뉴 버튼 이벤트
        for(JButton data : movie_button){
            data.addActionListener(new EventListner());
        }

        mypage_button.addActionListener(new EventListner());
        before_button.addActionListener(new EventListner());

        movie_panel.setBackground(Color.white);
        add(movie_panel);
        setSize(500,900);
        setVisible(true);
    }

    class EventListner extends Component implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JButton input = (JButton) e.getSource();


            for(int i = 0; i< movie_button.length; i++){
                if(input.equals(movie_button[i])){   // 메뉴선택
                    System.out.println("영화" + i + "번 버튼 클릭");
                }
            }

            if(input.equals(before_button)){
                dispose();  //프레임 종료
            }

            if(input.equals(mypage_button)){
                MyPageView mv = new MyPageView();   // 마이페이지 창 띄움
            }
        }
    }
}

