<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"> 
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<title>Admin Login Page</title>

<style type="text/css">

.card {
    box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.4);
    border-radius: 15px;
    z-index: 2;
    opacity: 0.9;
    background-color: #e2e7f1;
}

body{background-color: #ced9ee;}

.form-control{background-color:#ced6e6;  }

.submit-button{margin-right: 20px; background-color: green; color: white;}

.submit-button:hover{background-color: darkgreen; color:white;}

</style>

</head>
<body>


<div class="container" >
    <div class="row justify-content-center mt-5">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h3 class="text-center">Login As Administrator</h3>
                </div>
                <div class="card-body">
                    <form action="Login" method="post">
                        <div class="form-group">
                            <label for="adminEmail">Email</label>
                            <input type="email" class="form-control"  name="adminEmail" placeholder="Enter admin email" required>
                        </div>
                        <div class="form-group">
                            <label for="adminPass">Password</label>
                            <input type="password" class="form-control" name="adminPass" placeholder="Enter admin password" required>
                        </div>
                        <div class="text-center">
                        	<button type="submit" class="btn submit-button">Login</button>
                        	<a href="index.html"><button type="button" class="btn btn-primary">Home</button></a>
                                              
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>