package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.BookingDao;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			BookingDao booking = new BookingDao();
			String userId = request.getParameter("userId");
			String bno = request.getParameter("bno");
			String btype = request.getParameter("btype");
			String start = request.getParameter("bstart");
			String destination = request.getParameter("des");
			String starttime = request.getParameter("starttime");
			String endtime = request.getParameter("endtime");
			String status = "pending";
			boolean res = booking.booking(userId, bno, btype, start, destination, starttime, endtime,status);
			if(res) {
				request.setAttribute("result", true);
				RequestDispatcher rd = request.getRequestDispatcher("buslist.jsp");
	            rd.forward(request, response);
			}
			else {
				System.out.println("booking fail");
			}
		}



}
