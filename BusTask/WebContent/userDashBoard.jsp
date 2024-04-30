<%@ page language="java" import="com.classes.Record" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js">
</script>
</head>
<body>
    <div class="container mt-3">
        <div class="row justify-content-center m-5">
            <div class="col">
                <h2 class="">
                    Welcome,
                    <%= request.getAttribute("uname") %></h2>
                </div>
                <div>
                    <a class="btn btn-outline-secondary px-2 mt-2" href="buslist.jsp?userId=<%= request.getAttribute("userId") %>" role="button"> All Bus list</a>
                    <a class="btn btn-outline-secondary px-2 mt-2" href="buslist.jsp?userId=<%= request.getAttribute("userId") %>" role="button">Status</a>
                    <a class="btn btn-outline-secondary px-2 mt-2" href="Bookinghistory.jsp?userId=<%= request.getAttribute("userId") %>" role="button">History</a>
                    
                    
                </div>
            </div>
        </div>
        <a href="index.jsp">LogOut</a>
    </div>
</body>
</html>
