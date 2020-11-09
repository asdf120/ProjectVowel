package movie;

import movie.view.LoginView;

import javax.swing.*;

public class Start extends JFrame {

    LoginView pnl;

    public Start() {
        pnl = new LoginView();
        pnl.output();
    }

    public static void main(String[] args) {
        new Start();
    }
}


