package videoshop.view;

import videoshop.model.VideoDAO;
import videoshop.model.vo.VideoVO;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class VideoView extends JPanel {
    //	member field
    JTextField tfVideoNum, tfVideoTitle, tfVideoDirector, tfVideoActor;
    JComboBox comVideoJanre;
    JTextArea taVideoContent;

    JCheckBox cbMultiInsert;
    JTextField tfInsertCount;

    JButton bVideoInsert, bVideoModify, bVideoDelete;

    JComboBox comVideoSearch;
    JTextField tfVideoSearch;
    JTable tableVideo;

    VideoTableModel tbModelVideo;

    VideoVO videoVO;
    //모델 - 비지니스로직
    VideoDAO videoDAO;

    //##############################################
    //	constructor method
    public VideoView() {
        addLayout();    // 화면설계
        initStyle();
        eventProc();
        connectDB();    // DB연결
    }

    public void connectDB() {    // DB연결
        try {
            videoDAO = new VideoDAO();
            System.out.println("DB 연결성공 - 비디오관리");
        } catch (Exception e) {
            System.out.println("DB 연결실패 - 비디오관리" + e.toString());
        }
    }

    public void eventProc() {
        ButtonEventHandler hdlr = new ButtonEventHandler();
        bVideoInsert.addActionListener(hdlr);
        bVideoModify.addActionListener(hdlr);
        bVideoDelete.addActionListener(hdlr);
        tfVideoSearch.addActionListener(hdlr);

        // 다중입고 체크박스 이벤트
        cbMultiInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbMultiInsert.isSelected()) {
                    tfInsertCount.setEditable(true);
                } else {
                    tfInsertCount.setEditable(false);
                }
            }
        });

        // JTable 클릭 시,
        tableVideo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = 0;
                int row = tableVideo.getSelectedRow();
                int video_no = (Integer)tableVideo.getValueAt(row,col);
                System.out.println(video_no);
                try{
                    videoVO = videoDAO.searchByPk(video_no);
                    comVideoJanre.setSelectedItem(videoVO.getGenre());
                    tfVideoTitle.setText(videoVO.getTitle());
                    tfVideoDirector.setText(videoVO.getDirector());
                    tfVideoActor.setText(videoVO.getActor());
                    taVideoContent.setText(videoVO.getDetail());
                }catch (Exception ex){
                    System.out.println("비디오를 찾을 수 없음 : " + ex.toString());
                }
            }
        });
    }

    // 버튼 이벤트 핸들러 만들기
    class ButtonEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            Object o = ev.getSource();

            if (o == bVideoInsert) {
                registVideo();                    // 비디오 등록
            } else if (o == bVideoModify) {
                modifyVideo();                    // 비디오 정보 수정
            } else if (o == bVideoDelete) {
                deleteVideo();                    // 비디오 정보 삭제
            } else if (o == tfVideoSearch) {
                searchVideo();                    // 비디오 검색
            }
        }
    }

    // 입고 클릭시  - 비디오 정보 등록
    public void registVideo() {
        // 1. 사용자 입력값 얻어오기
        String genre = (String) comVideoJanre.getSelectedItem();
        String title = tfVideoTitle.getText();
        String director = tfVideoDirector.getText();
        String actor = tfVideoActor.getText();
        String detail = taVideoContent.getText();
        int video_count = Integer.parseInt(tfInsertCount.getText());
        // 2. VideoVO로 멤버변수로 1번값들을 지정
        videoVO = new VideoVO(title, genre, director, actor, detail);
        // 3. 모델단(VideoDAO) insertVideo() 호출
        try {
            videoDAO.insertVideo(videoVO, video_count);
            JOptionPane.showMessageDialog(null, title + "입고");
        } catch (Exception e) {
            System.out.println("입고 실패 : " + e.toString());
        }
//        JOptionPane.showMessageDialog(null, "입고");

    }

    public void initStyle() {   // 입력하지 못하게 만듬.
        // setEnabled(false) --> 데이터를 못 얻어옴
        tfVideoNum.setEditable(false);
        tfInsertCount.setEditable(false);
        tfInsertCount.setHorizontalAlignment(JTextField.RIGHT);
    }

    // 수정 클릭시 - 비디오 정보 수정
    public void modifyVideo() {
        JOptionPane.showMessageDialog(null, "수정");
    }

    // 삭제 클릭시 - 비디오 정보 삭제
    public void deleteVideo() {

        JOptionPane.showMessageDialog(null, "삭제");
    }

    // 비디오현황검색
    public void searchVideo() {
        ArrayList data = new ArrayList();
//        JOptionPane.showMessageDialog(null, "검색");
        int idx = comVideoSearch.getSelectedIndex();
        String word = tfVideoSearch.getText();
        try {
            if (word.trim().equals("")) { //TODO 공백도 잡을것
                JOptionPane.showMessageDialog(null,"검색어를 입력해주세요");
            }else{
                data = videoDAO.searchVideo(idx, word);
            }
            tbModelVideo.data = data;
            tableVideo.setModel(tbModelVideo);
            tbModelVideo.fireTableDataChanged();
        } catch (Exception e) {
            System.out.println("VideowView 검색 실패 : " + e.toString());
        }
    }


    //  화면설계 메소드
    public void addLayout() {
        //멤버변수의 객체 생성
        tfVideoNum = new JTextField();
        tfVideoTitle = new JTextField();
        tfVideoDirector = new JTextField();
        tfVideoActor = new JTextField();

        String[] cbJanreStr = {"멜로", "액션", "스릴러", "코미디"};
        comVideoJanre = new JComboBox(cbJanreStr);
        taVideoContent = new JTextArea();

        cbMultiInsert = new JCheckBox("다중입고");
        tfInsertCount = new JTextField("1", 5);

        bVideoInsert = new JButton("입고");
        bVideoModify = new JButton("수정");
        bVideoDelete = new JButton("삭제");

        String[] cbVideoSearch = {"제목", "감독"};
        comVideoSearch = new JComboBox(cbVideoSearch);
        tfVideoSearch = new JTextField(15);

        tbModelVideo = new VideoTableModel();
        tableVideo = new JTable(tbModelVideo);

        //*********************************************************************
        // 화면 구성
        setLayout(new GridLayout(1, 2));

        //TODO setBorder와 setLayout의 차이

        // 왼쪽 영역
        JPanel pLeft = new JPanel();
        pLeft.setBorder(new TitledBorder("비디오정보입력"));
        pLeft.setLayout(new BorderLayout());

        // 왼쪽 중앙영역
        JPanel pLeftCenter = new JPanel();
        pLeftCenter.setLayout(new BorderLayout());

        JPanel pLeftCenterNorth = new JPanel();
        pLeftCenterNorth.setLayout(new GridLayout(5, 2));
        pLeftCenterNorth.add(new JLabel("비디오 번호"));
        pLeftCenterNorth.add(tfVideoNum);
        pLeftCenterNorth.add(new JLabel("장르"));
        pLeftCenterNorth.add(comVideoJanre);
        pLeftCenterNorth.add(new JLabel("제목"));
        pLeftCenterNorth.add(tfVideoTitle);
        pLeftCenterNorth.add(new JLabel("감독"));
        pLeftCenterNorth.add(tfVideoDirector);
        pLeftCenterNorth.add(new JLabel("배우"));
        pLeftCenterNorth.add(tfVideoActor);

        JPanel pLeftCenterCenter = new JPanel();
        pLeftCenterCenter.setLayout(new BorderLayout());
        pLeftCenterCenter.add(new JLabel("설명"), BorderLayout.WEST);
        pLeftCenterCenter.add(taVideoContent, BorderLayout.CENTER);

        pLeftCenter.add(pLeftCenterNorth, BorderLayout.NORTH);
        pLeftCenter.add(pLeftCenterCenter, BorderLayout.CENTER);

        // 왼쪽 아래영역
        JPanel pLeftSouth = new JPanel();
        pLeftSouth.setLayout(new GridLayout(2, 1));

        JPanel pLeftSouth1 = new JPanel();
        pLeftSouth1.setBorder(new TitledBorder("다중입력시 선택하세요"));
        pLeftSouth1.add(cbMultiInsert);
        pLeftSouth1.add(tfInsertCount);
        pLeftSouth1.add(new JLabel("개"));

        JPanel pLeftSouth2 = new JPanel();
        pLeftSouth2.setLayout(new GridLayout(1, 3));    // 아래 3개버튼 레이아웃에 꽉차게 설정
        pLeftSouth2.add(bVideoInsert);
        pLeftSouth2.add(bVideoModify);
        pLeftSouth2.add(bVideoDelete);

        pLeftSouth.add(pLeftSouth1);
        pLeftSouth.add(pLeftSouth2);

        pLeft.add(pLeftCenter, BorderLayout.CENTER);
        pLeft.add(pLeftSouth, BorderLayout.SOUTH);

        // 오른쪽 영역
        JPanel pRight = new JPanel();
        pRight.setBorder(new TitledBorder("비디오 검색"));
        pRight.setLayout(new BorderLayout());

        JPanel pRightNorth = new JPanel();
        pRightNorth.add(comVideoSearch);
        pRightNorth.add(tfVideoSearch);
        pRight.add(pRightNorth, BorderLayout.NORTH);
        pRight.add(new JScrollPane(tableVideo), BorderLayout.CENTER);

        add(pLeft);
        add(pRight);

    }

    //화면에 테이블 붙이는 메소드
    class VideoTableModel extends AbstractTableModel {

        ArrayList data = new ArrayList();
        String[] columnNames = {"비디오번호", "제목", "감독", "배우"};

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.size();
        }

        public Object getValueAt(int row, int col) {
            ArrayList temp = (ArrayList) data.get(row);
            return temp.get(col);
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }
    }
}


