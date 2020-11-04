package movie;

import movie.view.LoginView;

import javax.swing.*;

public class Start extends JFrame {

    LoginView pnl;

    public Start() {
        LoginView pnl = new LoginView();
      //  MemberShipView mv = new MemberShipView();
        pnl.output();
    }


    public static void main(String[] args) {
        Start mv = new Start();
    }

}


