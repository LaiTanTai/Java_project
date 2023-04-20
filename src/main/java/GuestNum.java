
import model.Guest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="GuestNum",urlPatterns = {"/GuestNum"})
public class GuestNum extends HttpServlet{
    Random rand = new Random();
    int id = 0;
    int count = 0 ;
    int randnum = 1 + rand.nextInt(10);
    List<Guest> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("GuestNum.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num = 0;
        if(req.getParameter("Number")!=null){
            num = Integer.parseInt(req.getParameter("Number"));
        }
        String msg;
        if(num == 0){
            msg = "Đáp án không được để trống";
        }else if( num == randnum ){
            id++;
            count++;
            msg = "Đáp án chính xác";
            Guest g1 = new Guest();
            g1.setCount(count);
            g1.setId(id);
            list.add(g1);
            count = 0 ;
        }else if(num > randnum){
            count++;
            msg = "Số vừa chọn lớn hơn";
        }else {
            count++;
            msg = "Số vừa chọn nhỏ hơn";
        }
        list.sort(((o1, o2) -> o1.getCount() - o2.getCount()));
        req.setAttribute("msg",msg);
        req.setAttribute("list",list);
        req.getRequestDispatcher("GuestNum.jsp").forward(req,resp);
    }
}
