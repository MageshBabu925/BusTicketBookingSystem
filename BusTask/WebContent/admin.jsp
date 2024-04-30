<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container mt-3">
		<div class="row justify-content-center m-5">
			<div class="col">
				<h2 class="">Welcome, Admin DashBoard</h2>
				<div>
					<a class="btn btn-outline-secondary px-2 mt-2" href="addbus.jsp" role="button">Add Bus</a>
					<a class="btn btn-outline-secondary px-2 mt-2" href="userRecord.jsp" role="button">Users Info</a>
						<a class="btn btn-outline-secondary px-2 mt-2" href="booking.jsp" role="button">Booking Information</a>
					<a class="btn btn-outline-secondary px-2 mt-2" href="adminbuslist.jsp" role="button">All Bus List </a>				</div>
			</div>
		</div>
		<a href="index.jsp">Logout</a>
	</div>
	<% if (request.getAttribute("result") != null && (boolean)request.getAttribute("result")) { %>
    <script>
        alert("New Bus Added Successfully!");
    </script>
    <% } %>
</body>
</html>