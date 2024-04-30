<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bus Ticket Booking</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js">
</script>

<style>
   body {
    background-image: url('chan-young-lee-TeotD4SvSLo-unsplash.jpg');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
    min-height: 100vh; /* Change from height to min-height */
    margin: 0;
    display: flex;
    justify-content: center;
    align-items: center;
}

     h1 {
            margin-bottom: 20px;
            color: vibgyor; 
            }

    .container {
        width: 500px; /* Set width of the container */
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    }

    .card-header {
        background-color: #007bff;
        color: white;
        border-bottom: none;
        border-radius: 10px 10px 0 0;
    }

    .card-body {
        padding: 10px; /* Reduced padding */
    }

    .form-control {
        border-radius: 10px; /* Reduced border radius */
    }

    .bg-primary {
        border-radius: 10px;
        background-color: #007bff !important; /* More highlighted background color */
        border: none; /* Remove button border */
    }

    a {
        color: #007bff;
    }
</style>

</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 text-center mb-3"><h1>TNSTC - APSRTC - KSRTC - BUS BOOKING</h1></div>
            <div class="col-12">
                <div class="card">
                    <div class="card-header text-center"><h2>Login</h2></div>
                    <div class="card-body">
                        <form id="loginForm" action="Loginservlet" method="post" autocomplete="on">
                            <div class="form-group">
                                <p class="text-danger" id="message"></p>
                                <label for="uname" class="h4">UserName</label>
                                <input type="text" id="uname" class="form-control" placeholder="UserName" name="uname" required>
                            </div>
                            <div class="form-group">
                                <label for="pwd" class="h4">PassWord</label>    
                                <input type="password" id="pwd" class="form-control" placeholder="PassWord" name="pwd" required>                        
                            </div>
                            <div class="form-group">
                                <input type="submit" class="form-control bg-primary text-white" value="Login">    
                            </div>
                            
                        </form>
                        <div class="text-center">
                            <h4 class="d-inline">New Registration?</h4><br>
                            <a href="userReg.jsp" style="text-decoration: none; font-size: 17px;">SignUp</a><br><br>
                            
                        </div>
                    </div>
                </div>
            </div>      
        </div>
    </div>
    <% if (request.getAttribute("result") != null && (boolean)request.getAttribute("result")) { %>
    <script>
        alert("Registration, Done Successfully!");
    </script>
    <% } %>
</body>
</html>
