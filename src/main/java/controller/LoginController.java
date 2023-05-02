package controller;

import Service.LoginService;
import com.mysql.cj.xdevapi.Session;
import config.Mysqlconfig;
import filter.CustomFilter;
import model.UsersModel;
import org.apache.taglibs.standard.extra.spath.Path;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "LoginController",urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    private CustomFilter customFilter = new CustomFilter();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = "";
        String password = "";
        System.out.print(session.getAttribute("username"));
        username =(String) session.getAttribute("username");
        password = (String) session.getAttribute("password");
        req.setAttribute("username",username);
        req.setAttribute("password",password);
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        bƯỚC 1 : Lấy tham số username và password người dùng
        String email = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        customFilter.AuthFilter(req,resp,email,password,remember);
    }
}
