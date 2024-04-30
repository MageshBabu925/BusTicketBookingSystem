<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.classes.Booking" %>
<%@ page import="com.servlet.Historyservlet" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Booking History</title>
    <!-- Include any necessary CSS or JavaScript libraries -->
</head>
<body>
    <h2>Booking History</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Bus No</th>
                <th>User</th>
                <th>Booking Date</th>
            </tr>
        </thead>
        <tbody>
            <% 
            List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
            if (bookings != null && !bookings.isEmpty()) {
                for (Booking booking : bookings) { %>
                    <tr>
                        <td><%= booking.getId() %></td>
                        <td><%= booking.getBusNo() %></td>
                        <td><%= booking.getUsername() %></td>
                        <td><%= booking.getBookingDate() %></td>
                    </tr>
            <%  }
            } else { %>
                <tr>
                    <td colspan="4">No bookings found.</td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
