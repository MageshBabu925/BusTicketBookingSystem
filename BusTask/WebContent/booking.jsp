<%@ page language="java" import="com.classes.BookingInfo, java.util.List, com.classes.Bookinfo" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Info</title>
<link rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
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
    .back-button {
        position: absolute;
        top: 10px;
        right: 10px;
    }
</style>
</head>
<body>
    <h2 class="m-3">Booking Info</h2>
    <form action="HandleBookingActionServlet" method="post">
    <table class="m-auto">
        <thead>
            <tr>
                <th>User Id</th>
                <th>Bus No</th>
                <th>Bus Type</th>
                <th>Start</th>
                <th>Destination</th>
                <th>Start time</th>
                <th>End time</th>
                <th>Action</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <% 
                BookingInfo info = new BookingInfo(); 
                List<Bookinfo> books = info.allBookInfo();
                for(Bookinfo book : books) {
            %>
            <tr>
                <td><%= book.getUserId() %></td>
                <td><%= book.getBno() %></td>
                <td><%= book.getBtype() %></td>
                <td><%= book.getStart() %></td>
                <td><%= book.getDestination() %></td>
                <td><%= book.getStartTime() %></td>
                <td><%= book.getEndTime() %></td>
                <td>
                    <input type="radio" id="confirm_<%= book.getUserId() %>" name="action" value="confirm_<%= book.getUserId() %>">
                    <label for="confirm_<%= book.getUserId() %>" class="btn btn-outline-success px-2 mt-2">Confirm</label>

                    <input type="radio" id="cancel_<%= book.getUserId() %>" name="action" value="cancel_<%= book.getUserId() %>">
                    <label for="cancel_<%= book.getUserId() %>" class="btn btn-outline-danger px-2 mt-2">Cancel</label>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <input type="submit" value="Submit" class="btn btn-primary mt-3">
</form>

    <a class="btn btn-outline-secondary px-2 m-3 back-button" href="admin.jsp" role="button">Back</a>
</body>
</html>
