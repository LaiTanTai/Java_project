package controller;

import config.Mysqlconfig;
import model.UsersModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginController",urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        //        bƯỚC 1 : Lấy tham số username và password người dùng
        String email = req.getParameter("username");
        String password = req.getParameter("password");
//        Viết câu quẻry
//        ? là tham số sẽ được truyền jdbc
        String sql = "select * from users u where u.email = ? and u.password = ?";
        try {
            connection = Mysqlconfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
//            Truyền tham s cho dấu chấm hỏi ?
            statement.setString(1,email);
            statement.setString(2,password);
//            Bước 4 : Thực thi câu query
//            statement có 2 loại thực thi
//            excuteQuery : select
//            excuteUpdate : insert ,delete,update...
            ResultSet resultSet = statement.executeQuery();
            List<UsersModel> list = new ArrayList<>();
//          Bước 5 : lưu từng dòng dữ liệu và lưu vào trong model
            while(resultSet.next()){
//                Duyệt từng dòng dữ liệu
                UsersModel usersModel = new UsersModel();
                usersModel.setId(resultSet.getInt("id"));
                usersModel.setEmail(resultSet.getString("email"));
                usersModel.setFullname(resultSet.getString("fullname"));
                usersModel.setRoleId(resultSet.getInt("role_id"));
                list.add(usersModel);
            }
            boolean isSuccess = list.size() > 0;
            PrintWriter writer = resp.getWriter();
            writer.println(isSuccess ? "Login Success" : "Login Fail");
            System.out.print("kiem tra" + list.size());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Lỗi đóng kết nối login" + e.getMessage());
                }
            }
        }
    }
}
