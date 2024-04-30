package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.CancelDao;


public class Cancelservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CancelDao cancel = new CancelDao();
		String userId = request.getParameter("userId");
		boolean result = cancel.cancel(userId);
		if(result) {
			RequestDispatcher rd = request.getRequestDispatcher("bookingInfo.jsp");
			rd.forward(request, response);
		}else {
			System.out.println("cancel fail");
		}
		
		
	}

}
