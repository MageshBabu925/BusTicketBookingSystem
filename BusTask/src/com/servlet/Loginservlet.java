package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.Login;
import com.classes.Record;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Login log  = new Login();
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        
        Record result = log.login(uname, pwd);
        if(result != null) {
            String roll = result.getRoll();
            int userId = result.getuId();
            if(roll.equals("admin")) {
                RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("uname", uname);
                request.setAttribute("userId", userId); 
                RequestDispatcher rd = request.getRequestDispatcher("userDashBoard.jsp");
                rd.forward(request, response);
            }
            
        } else {
            System.out.println("fail");
        }
    }

}
