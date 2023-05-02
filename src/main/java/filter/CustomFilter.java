package filter;

import Service.LoginService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Authenticator;
import java.util.logging.LogRecord;
@WebFilter(urlPatterns = {"/user-table"})
public class CustomFilter implements Filter {
    private LoginService loginService = new LoginService();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        Nơi quy định rule

    }
    public void AuthFilter(HttpServletRequest req, HttpServletResponse resp, String email, String password, String remember) throws IOException {
        boolean isSuccess = loginService.checkLogin(email, password);
        if (isSuccess) {
            if(remember != null) {
                HttpSession session = req.getSession();
                session.setAttribute("username", email);
                session.setAttribute("password",password);
            }
            resp.sendRedirect("/demoservlet/user");
        } else {
            resp.sendRedirect("/demoservlet/login");
        }
    }
    @Override
    public void destroy() {
    }

}
