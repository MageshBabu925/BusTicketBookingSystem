package com.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classes.Bookinfo;
import com.classes.BookingDao;

@WebServlet("/Historyservlet")
public class Historyservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String user = (String) session.getAttribute("loggedInUser");
			BookingDao bookingDAO = new BookingDao();
			List<Bookinfo> bookingHistory = bookingDAO.getBookingHistory(user); // Assuming your DAO method returns a
																				// List<Booking>
			request.setAttribute("bookingHistory", bookingHistory); // Set the booking history list as a request
																	// attribute
			request.getRequestDispatcher("Bookinghistory.jsp").forward(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not logged in");
		}
	}

}
