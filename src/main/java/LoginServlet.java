import model.Users;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

///monolithic
// <%! %> Thẻ dùng để khai báo biến
// <% %> Thẻ dùng để xử lý logic code , thẻ đa năng
// <%= %> Thẻ dùng để xuất giá trị
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        yêu cầu sử dụng giao diện và trả giao diện cho browser của client
        int a = 5;
        int b = 10;
        int result = a + b ;

        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("Password");
        if(Objects.equals(username, "nguyenvana@gmail.com")){
            System.out.print(username);
            req.setAttribute("kq",username);
        }
        Users a = new Users();
        a.setUsername("name");
        a.setPassword(password);
        req.setAttribute("msg",a);
        List<String> list = Arrays.asList("cybersoft","Java","JSP");
        req.setAttribute("list",list);
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

}
