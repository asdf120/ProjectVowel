package videoshop.view;

import videoshop.model.CustomerDAO;
import videoshop.model.vo.CustomerVO;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerView extends JPanel implements ActionListener {
    JFrame frm;
    JTextField tfCustName, tfCustTel, tfCustTelAid, tfCustAddr, tfCustEmail;
    JButton bCustRegist, bCustModify;

    JTextField tfCustNameSearch, tfCustTelSearch;
    JButton bCustNameSearch, bCustTelSearch;

    CustomerVO customerVO;
    CustomerDAO customerDAO;
    int count = 0;

    public CustomerView() {
        try {
            customerDAO = new CustomerDAO();
            System.out.println("DB 연결성공");
        } catch (Exception e) {
            System.out.println("public CustomerView() : " + e.toString());
        }
        addLayout();
        eventProc();
    }

    /* 화면구성 */
    public void addLayout() {

        tfCustName = new JTextField(20);
        tfCustTel = new JTextField(20);
        tfCustTelAid = new JTextField(20);
        tfCustAddr = new JTextField(20);
        tfCustEmail = new JTextField(20);


        tfCustNameSearch = new JTextField(20);
        tfCustTelSearch = new JTextField(20);

        bCustRegist = new JButton("회원가입");
        bCustModify = new JButton("회원수정");
        bCustNameSearch = new JButton("이름검색");
        bCustTelSearch = new JButton("번호검색");

        // 회원가입 부분 붙이기
        //		( 그 복잡하다던 GridBagLayout을 사용해서 복잡해 보임..다른 쉬운것으로...대치 가능 )
        JPanel pRegist = new JPanel();
        pRegist.setLayout(new GridBagLayout());
        GridBagConstraints cbc = new GridBagConstraints();
        cbc.weightx = 1.0;
        cbc.weighty = 1.0;
        cbc.fill = GridBagConstraints.BOTH;
        cbc.gridx = 0;
        cbc.gridy = 0;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add(new JLabel("	이	름	"), cbc);
        cbc.gridx = 1;
        cbc.gridy = 0;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add(tfCustName, cbc);
        cbc.gridx = 2;
        cbc.gridy = 0;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add(bCustModify, cbc);
        cbc.gridx = 3;
        cbc.gridy = 0;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add(bCustRegist, cbc);

        cbc.gridx = 0;
        cbc.gridy = 1;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add(new JLabel("	전	화	"), cbc);
        cbc.gridx = 1;
        cbc.gridy = 1;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add(tfCustTel, cbc);
        cbc.gridx = 2;
        cbc.gridy = 1;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add(new JLabel(" 추가전화  "), cbc);
        cbc.gridx = 3;
        cbc.gridy = 1;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add(tfCustTelAid, cbc);

        cbc.gridx = 0;
        cbc.gridy = 2;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add(new JLabel("	주	소	"), cbc);
        cbc.gridx = 1;
        cbc.gridy = 2;
        cbc.gridwidth = 3;
        cbc.gridheight = 1;
        pRegist.add(tfCustAddr, cbc);

        cbc.gridx = 0;
        cbc.gridy = 3;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add(new JLabel("	이메일	"), cbc);
        cbc.gridx = 1;
        cbc.gridy = 3;
        cbc.gridwidth = 3;
        cbc.gridheight = 1;
        pRegist.add(tfCustEmail, cbc);


        // 회원검색 부분 붙이기
        JPanel pSearch = new JPanel();
        pSearch.setLayout(new GridLayout(2, 1));
        JPanel pSearchName = new JPanel();
        pSearchName.add(new JLabel("		이 	름	"));
        pSearchName.add(tfCustNameSearch);
        pSearchName.add(bCustNameSearch);
        JPanel pSearchTel = new JPanel();
        pSearchTel.add(new JLabel("	전화번호	"));
        pSearchTel.add(tfCustTelSearch);
        pSearchTel.add(bCustTelSearch);
        pSearch.add(pSearchName);
        pSearch.add(pSearchTel);

        // 전체 패널에 붙이기
        setLayout(new BorderLayout());
        add("Center", pRegist);
        add("South", pSearch);


    }

    void eventProc() {   //  ActionPerformed 메소드와 매핑??
        bCustRegist.addActionListener(this);
        bCustModify.addActionListener(this);
        bCustNameSearch.addActionListener(this);
        bCustTelSearch.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object evt = e.getSource();
        if (evt.equals(bCustRegist)) {  // 회원가입 버튼
            registMember();
        } else if (evt.equals(bCustModify)) {
            modifyMember();
        } else if (evt.equals(bCustTelSearch)) {
            searchByTel();
        } else if (evt.equals(bCustNameSearch)) {
            searchByName();
        }
    }
    /**
     * 함수명
     * 인자
     * 리턴값
     * 역할 : 회원가입을 위해 사용자 입력값을 받아서 모델로 전달
     */
    public void registMember() {
        //TODO
        //1.화면 입력값 받아오기
        String name = tfCustName.getText();
        String tel = tfCustTel.getText();
        String address = tfCustAddr.getText();
        String email = tfCustEmail.getText();
        String extra_tel = tfCustTelAid.getText();

        //2. VO객체의 멤버변수로 화면의 입력값들을 지정
        if (extra_tel != null) {
            customerVO = new CustomerVO(name, tel, address, email, extra_tel);
        } else {
            customerVO = new CustomerVO(name, tel, address, email);
        }
        //3. 모델단의 regist(CustomerVO) 호출
        try {
            customerDAO.regist(customerVO);
            System.out.println("회원가입 성공");
            clearField();
        } catch (Exception e) {
            System.out.println("registMember() : " + e.toString());
        }
    }

    public void modifyMember() {
        String name = tfCustName.getText();
        String tel = tfCustTel.getText();
        String address = tfCustAddr.getText();
        String email = tfCustEmail.getText();
        String extra_tel = tfCustTelAid.getText();
        if (extra_tel != null) {
            customerVO = new CustomerVO(name, tel, address, email, extra_tel);
        } else {
            customerVO = new CustomerVO(name, tel, address, email);
        }
        try {
            int result = customerDAO.modify(customerVO);
            if (result == -1) {
                JOptionPane.showMessageDialog(null,"없는 회원");
            } else {
                System.out.println("회원수정 성공");
            }
            clearField();
        } catch (Exception e) {
            System.out.println("modifyMember() : " + e.toString());
        }
    }

    public void searchByTel() {
        String tel = tfCustTelSearch.getText();
        try {
            customerVO = customerDAO.searchTel(tel);

            if (customerVO == null) {
                JOptionPane.showMessageDialog(null,"더 이상 회원이 없음");
            }else{
                tfCustName.setText(customerVO.getName());
                tfCustTel.setText(customerVO.getTel());
                tfCustAddr.setText(customerVO.getExtra_tel());
                tfCustAddr.setText(customerVO.getAddress());
                tfCustEmail.setText(customerVO.getEmail());
                tfCustTelSearch.setText("");
            }
        } catch (Exception e) {
            System.out.println("searchByTel() : " + e.toString());
        }
    }

    public void searchByName() {
        List<CustomerVO> memberList = new ArrayList<>();
        String name = tfCustNameSearch.getText();
        try{
            memberList = customerDAO.searchName(name);
            if (memberList.size() == count) { // 회원정보 리스트와 count가 같으면 null
                JOptionPane.showMessageDialog(null, "회원정보 없음");
            } else{
                customerVO = memberList.get(count);
                tfCustName.setText(customerVO.getName());
                tfCustTel.setText(customerVO.getTel());
                tfCustAddr.setText(customerVO.getExtra_tel());
                tfCustAddr.setText(customerVO.getAddress());
                tfCustEmail.setText(customerVO.getEmail());
                tfCustTelSearch.setText("");
                count++;
            }
        }catch (Exception e){
            System.out.println("searchByName() : " + e.toString());
        }
    }

    public void clearField() {
        tfCustName.setText(null);
        tfCustTel.setText(null);
        tfCustTelAid.setText(null);
        tfCustAddr.setText(null);
        tfCustEmail.setText(null);
    }
}
				 	
