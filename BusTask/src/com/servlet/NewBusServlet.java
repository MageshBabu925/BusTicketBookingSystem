package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.NewBus;


@WebServlet("/NewBusServlet")
public class NewBusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewBus newbus = new NewBus();
		String BusNo = request.getParameter("bno");
		String BusType = request.getParameter("btype");
		String start = request.getParameter("start");
		String destination = request.getParameter("destination");
		String startTime = request.getParameter("starttime");
		String endTime = request.getParameter("endtime");
		String avalSeat = request.getParameter("avalseat");
		boolean result = newbus.newbus(BusNo, BusType, start, destination, startTime, endTime, avalSeat);
		if(result) {
			request.setAttribute("result", true);
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);
		}else {
			System.out.println("fail");
		}
		
	}

}
