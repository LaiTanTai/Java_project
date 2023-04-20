

import model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.servlet.annotation.WebServlet;
import javax.swing.event.ListDataEvent;

@WebServlet(name = "QLSP",urlPatterns = {"/QLSP"})
public class QLSP extends HttpServlet {
    private List<Product> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("QLSP.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product pd = new Product();
        pd.setProduct(req.getParameter("name"));
        pd.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        pd.setPrice(Integer.parseInt(req.getParameter("price")));
        if(pd.getPrice() != 0 && pd.getQuantity() != 0 && pd.getProduct() != ""){
            list.add(pd);
            req.setAttribute("list",list);
        }
        req.getRequestDispatcher("QLSP.jsp").forward(req,resp);
    }
}
