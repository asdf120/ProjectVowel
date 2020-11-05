package movie;

import movie.view.LoginView;

import javax.swing.*;

public class Start extends JFrame {

    LoginView pnl;

    public Start() {
        LoginView pnl = new LoginView();
        //  RegistView mv = new RegistView();
        pnl.output();
    }

    public static void main(String[] args) {
        Start mv = new Start();
    }
}


