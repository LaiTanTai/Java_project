import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "SignUp",urlPatterns = {"/Signup"})

public class SignUpServlet extends HttpServlet {
//    doGet : Phương thức
//    GET : Không bảo mật tham số mà client truyền lên
//        Cách truyền tham số : ? tên tham số = giá trị
//    Có giới hạn về tham số gọi trên trình duyệt
//    POST : Tham số sẽ được truyền ngầm .Tham so sẽ được bảo mật
//      Tham số sẽ được truyền thông qua code và form data trong html
//      Không có giới hạn về sóo lượng
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("Hello "+ username + " Đây là page đăng ký " + password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.print("Hello do Post");
    }
}
