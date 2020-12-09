package mvc.simple;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String jspDir = "/05_mvc_class/1_mvcSimple/";

    public SimpleControl() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 사용자로부터 요청값 얻어오기
        String type = request.getParameter("type");

        // 2. 사용자요청값에 따라 알맞은 기능 수행
        String value = "";
        if (type == null) {
            value = "안녕하세요";
        } else if (type.equals("first")) {
            value="반갑습니다.";
        }
        // 3. *** 중요 *** 처리결과를 request나 session에 저장
        request.setAttribute("value",value);

        // 4. 결과페이지(뷰페이지) 포워딩
        // <jsp:foward page='' />
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspDir + "simpleView.jsp");
        dispatcher.forward(request,response);


    }
}
