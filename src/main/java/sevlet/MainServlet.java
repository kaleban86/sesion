package sevlet;

import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/test")
public class MainServlet extends javax.servlet.http.HttpServlet {


    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {


        String session = req.getLocalAddr();

        System.out.println("Ip " + session);




    }


    public void test(){

        System.out.println("rrr");
    }


    public void test(String s){

    }



}











