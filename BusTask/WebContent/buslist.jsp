<%@ page language="java" import="com.classes.Record, com.classes.BusList, com.classes.Bus, java.util.List" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bus List</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<style>
table {
    width: 100%;
    border-collapse: collapse;
}

th, td {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

th {
    background-color: #f2f2f2;
}
</style>
</head>
<body>
	<div class="d-flex justify-content-around">
		<h2 class="m-3">BUS LIST</h2>
	</div>
    <table class="m-auto">
        <thead>
            <tr>
            	<th>Bus Id</th>
                <th>Bus No</th>
                <th>Bus Type</th>
                <th>Start</th>
                <th>Destination</th>
                <th>Start Time</th>
                <th>End Time</th>
                <th>Available Seat</th>
                <th>Book</th>
            </tr>
        </thead>
        <tbody>
            <%
            BusList fetcher = new BusList();
            List<Bus> buses = fetcher.buslist();
            String userId = request.getParameter("userId");
            if (buses != null) {
                for (Bus bus : buses) {
            %>
            <tr>
            	<td><%= bus.getBid() %></td>
                <td><%= bus.getBno() %></td>
                <td><%= bus.getBtype() %></td>
                <td><%= bus.getStart() %></td>
                <td><%= bus.getDestination() %></td>
                <td><%= bus.getStartTime() %></td>
                <td><%= bus.getEndTime() %></td>
                <td><%= bus.getAvalSeat() %></td>
                <td class="text-center"><a class="btn btn btn-outline-info px-2 mt-2" id="book"
                    href="BookingServlet?userId=<%= userId %>&bno=<%= bus.getBno() %>&btype=<%= bus.getBtype() %>&bstart=<%= bus.getStart() %>&des=<%= bus.getDestination() %>&starttime=<%= bus.getStartTime() %>&endtime=<%= bus.getEndTime() %>"
                    role="button">Booking</a></td>
            </tr>
            <% 
                }
            } else {
            %>
            <tr>
                <td colspan="8">No bus available</td>
            </tr>
            <% } %> 
        </tbody>
    </table>
    <% if (request.getAttribute("result") != null && (boolean) request.getAttribute("result")) { %>
    <script>
        alert("The ticket has been successfully booked! and is currently awaiting confirmation. Utilize the 'Track Status' section to monitor its progress");
    </script>
    <% } %>
    <a href="userDashBoard.jsp">Back</a>
</body>
</html>
