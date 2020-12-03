<%@ page language="java" import="java.sql.*" %>
<%
    String driver = "oracle.jdbc.driver.OracleDriver";
    String user = "kosmo_04";
    String pass = "kosmo";
    String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";

    request.setCharacterEncoding("utf-8");

    String name = request.getParameter("name");
    String age = request.getParameter("age");
    String tel = request.getParameter("tel");
    String addr = request.getParameter("addr");


    Class.forName(driver);
    Connection connection = DriverManager.getConnection(dbURL, user, pass);

//    String sql = "insert into ajax_temp(name, age, tel, addr) values(";
//    sql += "'" + name + "','" + age + "','" + tel + "','" + addr + "')";

//    Statement stmt = connection.createStatement();
//    int result = stmt.executeUpdate(sql);
    String sql = "INSERT INTO ajax_temp(name,age,tel,addr) VALUES(?,?,?,?)";
    PreparedStatement stmt = connection.prepareStatement(sql);
    stmt.setString(1,name);
    stmt.setInt(2,Integer.parseInt(age));
    stmt.setString(3,tel);
    stmt.setString(4,addr);

    int result = stmt.executeUpdate();

    stmt.close();
    connection.close();

    out.write(String.valueOf(result));
%>