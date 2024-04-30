package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.ConfirmDao;


public class Confirmservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ConfirmDao confirm = new ConfirmDao();
		String userId = request.getParameter("userId");
		boolean result = confirm.confirm(userId);
		if(result) {
			RequestDispatcher rd = request.getRequestDispatcher("bookingInfo.jsp");
			rd.forward(request, response);
		}else {
			System.out.println("confirm fail");
		}
		
	}

}
