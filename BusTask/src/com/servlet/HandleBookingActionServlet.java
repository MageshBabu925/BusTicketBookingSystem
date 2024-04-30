package com.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import com.classes.ConfirmDao;
import com.classes.CancelDao;

@WebServlet("/HandleBookingActionServlet")
public class HandleBookingActionServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Get the parameters from the form
	        String[] actions = request.getParameterValues("action");

	        // Check if parameters are not null
	        if (actions != null) {
	            ConfirmDao confirmDao = new ConfirmDao();
	            CancelDao cancelDao = new CancelDao();

	            // Iterate through each action
	            for (String action : actions) {
	                // Extract userId from action value
	                String userId = action.substring(action.lastIndexOf("_") + 1);
	                action = action.substring(0, action.lastIndexOf("_"));

	                // Perform action based on the selected option
	                if (action.equals("confirm")) {
	                    confirmDao.confirm(userId);
	                } else if (action.equals("cancel")) {
	                    cancelDao.cancel(userId);
	                }
	            }

	            // Redirect back to the same booking info page
	            response.sendRedirect("booking.jsp");
	        } else {
	            // Handle invalid input or missing parameters
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input or missing parameters");
	        }
	    }
	}


