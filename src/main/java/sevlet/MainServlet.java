package sevlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

@ServletSecurity
public class MainServlet extends javax.servlet.http.HttpServlet {


    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        HttpSession session = req.getSession();
        session.setAttribute("name", "<script>\n" +
                "    alert(\"У вас открыта вкладка \")\n" +
                "</script>");
        getServletContext().getRequestDispatcher("/test.jsp").forward(req, response);
    }
}











