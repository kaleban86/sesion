package sevlet;

import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.IOException;
import java.util.*;

@ServletSecurity
public class MainServlet extends javax.servlet.http.HttpServlet {


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        


        MainServlet mainServlet = new MainServlet();

        HttpSession session = request.getSession(false);
        if (session == null) {

            session = request.getSession();

            System.out.println("нет");
        } else {

            System.out.println("Да");
        }



    }

    public class SessionListener implements HttpSessionListener {
        private int sessionCount = 0;

        public void sessionCreated(HttpSessionEvent event) {
            synchronized (this) {
                sessionCount++;
            }

            System.out.println("Session Created: " + event.getSession().getId());
            System.out.println("Total Sessions: " + sessionCount);
        }

        public void sessionDestroyed(HttpSessionEvent event) {
            synchronized (this) {
                sessionCount--;
            }
            System.out.println("Session Destroyed: " + event.getSession().getId());
            System.out.println("Total Sessions: " + sessionCount);
        }
    }
}
