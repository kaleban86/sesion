package sevlet;

import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@ServletSecurity
public class MainServlet extends javax.servlet.http.HttpServlet {


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.isNew()) {
            request.setAttribute("sessionVal", "this is a new session");

            System.out.println("new");
        } else {
            request.setAttribute("sessionVal", "Welcome Back!");

            System.out.println("old");
        }

        destroy(request, response, session);
    }

    private void destroy(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, HttpSession session) throws IOException {
        PrintWriter writer = response.getWriter();

        String name = request.getParameter("name");

        if (name.equals("logout")){

            session.invalidate();
        }

        try {
            writer.println("<h2>Name: " + name + "; Age: " + "</h2>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}








