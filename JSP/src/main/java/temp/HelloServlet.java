//package temp;
//
//import javax.servlet.annotation.WebServlet;
//import java.io.IOException;
//import java.io.PrintWriter;
//
////servlet은 웹서버에서 구동
//@WebServlet(name = "HelloServlet", urlPatterns = {"/HelloServlet"})
//public class HelloServlet extends javax.servlet.http.HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    public HelloServlet() {
//        super();
//    }
//
//    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        doGet(request,response);
//
//    }
//
//    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
//
//        PrintWriter out = response.getWriter(); // 응답하는 통로에서 데이터를 받아옴
//        out.write("<html>");
//        out.write("<head><title>나의 첫 서블릿</title></head>");
//        out.write("<body>");
//        out.write("<h1>나의 첫 서블릿 프로그램 </h1>");
//        out.write("</body>");
//        out.write("</html>");
//
//        out.close();
//    }
//}
