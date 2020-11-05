package movie;

import movie.data.vo.ReserveVO;
import movie.view.LoginView;

import javax.swing.*;

public class Start extends JFrame {

    LoginView pnl;
    ReserveVO reserveVO = new ReserveVO();

    public Start() {
        LoginView pnl = new LoginView();
        //  RegistView mv = new RegistView();
        pnl.output();
    }

    public static void main(String[] args) {
        Start mv = new Start();

    }
}


