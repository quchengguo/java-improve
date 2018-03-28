package RememberPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

/**
 * Created by quchengguo on 2018/3/26.
 * 处理登录逻辑
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应编码和输出流对象
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        // 获取用户名
        String username = request.getParameter("username");
        // 获取密码
        String password = request.getParameter("password");
        // 获取复选框记住用户名的值
        String remember = request.getParameter("remember");
        System.out.println("remember: " + remember);
        // 判断用户名和面是否有效
        if("admin".equals(username) && "123".equals(password)){
            // 登录成功
            out.println("登录成功，3秒后跳转到首页");
            response.setHeader("Refresh", "3;URL=/myTomcat/indexServlet");
            if("1".equals(remember)){
                // 需要记住密码
                // 创建cookie对象
                Cookie cookie = new Cookie("username", username);
                // 设置最大有效值
                cookie.setMaxAge(Integer.MAX_VALUE);
                // 添加cookie
                response.addCookie(cookie);
            }else {
                // 不需要记住密码，设置cookie为失效状态
                Cookie cookie = new Cookie("username", "");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }else {
            // 登录失败
            out.println("登录失败，3秒后跳转到首页");
            response.setHeader("Refresh", "3;URL=/myTomcat/loginUI");
        }
    }
}
