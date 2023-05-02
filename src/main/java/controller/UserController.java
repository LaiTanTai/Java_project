package controller;

import Service.UserService;
import model.UsersModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController",urlPatterns ={"/user"})
public class UserController extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UsersModel> usersModelList = userService.UserList();
        req.setAttribute("list",usersModelList);
        req.getRequestDispatcher("user-table.jsp").forward(req,resp);
    }
}
