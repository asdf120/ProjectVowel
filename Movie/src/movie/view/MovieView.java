package movie.view;

import movie.data.DbSingleton;
import movie.data.TheaterDAO;
import movie.data.vo.ReserveVO;
import movie.data.vo.TheaterVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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

    TheaterDAO theaterDao;
    List<TheaterVO> movieList = new ArrayList<>();
    List<String> movietitle_list = new ArrayList<>();

    ReserveVO reserveVo;

    public MovieView(ReserveVO reserveVo) {
        super("영화 목록");
        try{
            this.reserveVo = reserveVo;
            theaterDao = new TheaterDAO();
            /**
             * 로그인 성공시 MovieTheater를 통해 Thaeter 테이블의 영화목록을 가져옴
             */
            movieList = theaterDao.showMovie();
            for(TheaterVO theaterInfo : movieList){
                System.out.println("상영 중 영화 목록 : " + theaterInfo.getTitle());
                movietitle_list.add(theaterInfo.getTitle());
            }
        }catch (Exception e){
            System.out.println("TheaterView() 디비 연결 실패 " + e.toString());
        }
        movie_panel = new JPanel();

        movie_button = new JButton[2];

        before_button = new JButton(new ImageIcon("Movie/src/img/before.png"));

        //TODO 비회원이면 setVisible(false) 처리할것
        mypage_button = new JButton(new ImageIcon("Movie/src/img/MemberShipView/마이페이지.png"));

        title_label = new JLabel("현재 상영작");

//
//        //TODO 없앨것
//        영화 버튼 초기화
        for(int i=0; i<movie_button.length; i++){
            movie_button[i] = new JButton(new ImageIcon("Movie/src/img/MovieView/"+i+".png"));
        }

        // 상영중인 영화 포스터 나타내기
//        for(int i = 0; i<movietitle_list.size(); i++){
//            movie_button[i] = new JButton(new ImageIcon("Movie/src/img/movie/"+movietitle_list.get(i)+".png"));
//        }

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
        setSize(500,600);
        setVisible(true);
    }

    class EventListner extends Component implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JButton input = (JButton) e.getSource();

            for(int i = 0; i< movie_button.length; i++){
                if(input.equals(movie_button[i])){   // 영화 선택
                    // 상영관 설정
                    reserveVo.setTheater_no(String.valueOf(i+1));
                    //TODO movieList(title,stat_time,theater_no) 같이 넘겨주기
                    System.out.println("MovieView 128행 선택한영화 : " + movietitle_list.get(i));
                    new ReserveView(movietitle_list.get(i),reserveVo);   //영화 선택시 예약 뷰를 띄움
                }
            }
            if(input.equals(before_button)){
                dispose();  //프레임 종료
            }
            if(input.equals(mypage_button)){
                new MyPageView();   // 마이페이지 창 띄움
            }
        }
    }
}

