<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css" /> 
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Register course</title>

<style type="text/css" >

.nav-item{color: white; padding: 0 10px 0 30px;}

.mylink{color: white; padding-bottom: 8px; }
.currentPage{font-weight: bold;} 

.mylink:hover{border-bottom: 2px solid white;}

h1{font-size: 22px; text-align: center; margin-top: 10px;}

table{margin: 0 auto;}

.table-form{ width: 950px;}

input, select{background-color: #dfeddf;}

input[type="submit"]{background-color: royalblue; color: white; margin-top: 15px; }

input[type="submit"]:hover{background-color: navy;}

input::placeholder {
    font-size: 13px; 
}

body{background-color: #d2e8fc;}

.card{background-color: white;border-radius: 10px; display: flex;
        flex-direction: column;
        height: 100%; padding: 15px;}
        
.check-icon{color: green; margin-right: 10px;}

.aboutCourses{font-size: 14px;}

</style>

<!-- For email validation -->
  <script>
        function validateEmail() {
            var emailInput = document.getElementById("email");
            
            var email = emailInput.value.trim();
            
            var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            
            if (emailRegex.test(email)) {
                return true;
            } else {
                alert("Please enter a valid email address.");
                emailInput.focus(); // Set focus back to the email input
                return false;
            }
        }
    </script>

</head>
<body>
<!-- navigation -->
<nav class="navbar navbar-expand-lg navbar-dark sticky-top" style="background:navy;">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
  </button> 
  <!-- Links -->  
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
  	<ul class="navbar-nav mr-auto mt-2 mt-sm-0">
  		<li class="nav-item">
        	<a class="nav-link" href="index.html"><span class="mylink" >Home</span></a>
        </li>         
        <li class="nav-item">
           	<a class="nav-link active" href="training"><span class="mylink currentPage">Course Register</span></a>
        </li>
  	</ul>         
  </div>
 </nav> <br>
 
 <h1>Please Fill Out The Following Form For Your Registration</h1><br>
  
 <div class="container">
	<div class="row">
	<div class="col-sm-7">
		<div class="card">
	 	<form action="registerSession" method="post" onsubmit="return validateEmail();" >
	  		<table>
	  			<tr><td><label for="name"> Attendee Name</label></td></tr>
	  			<tr>		
					<td class="table-form"><input type="text" name="name" placeholder="Enter your name..." required /></td>
				</tr> 
				
				<tr><td><label for="email">Email</label></td></tr>
	    		<tr>      
	    			<td class="table-form"><input type="email" id="email" name="email" placeholder="Enter your email..." required /></td>
	   			</tr>
	   			
	   			<tr><td><label for="address">Address</label></td></tr>
	   			<tr>      
	    			<td class="table-form"><input type="text" name="address" placeholder="Enter the name of your city / town..." required /></td>
	   			</tr>
	   			<tr><td>Course Name (Select the course you wish to attend)</td></tr>
	   			<tr>
	    			<td><select name="course">
	    			<%
	    			if (request.getAttribute("mycourses") != null) 
	    			{
	    				List<String> courses = (List<String>) request.getAttribute("mycourses");
	    				for (int i = 0; i < courses.size(); i++) {
	    			%>
	       					<option><%=courses.get(i)%></option>
	    			<%  
	    				}
	    			}
	    			%>
					</select></td>
		 		</tr> <br/>
		 		<tr><td colspan="2" align="center"><input type="submit" value="Register The Course"/></td></tr>
	  	  	</table>	  	  	
	  	</form>  <br>
	  	</div>
  	</div>	
  	<div class="col-sm-5">
  		<div class="card">
		  	<img alt="" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSD2AJQzmUcJAwo7e8Momx3jKQKXYdLs_n5FupwzMITL2jk7-4H7vfK0-KLqAKmy64WEaQ&usqp=CAU">
	 		<br>
	 		<p style="text-align: center;">All Courses Are Available At The Same Price. </p><br>
	 		<p>You Can Choose Different Sections For Different Prices:</p>
	 		<p class="aboutCourses"><span class="icon check-icon"><i class="fas fa-check"></i></span>Advanced Courses (Morning Sections) Costs 500USD</p>
	 		<p class="aboutCourses"><span class="icon check-icon"><i class="fas fa-check"></i></span>Intermediate Courses (Afternoon Sections) Costs 400USD</p>
	 		<p class="aboutCourses"><span class="icon check-icon"><i class="fas fa-check"></i></span>Beginner Courses (Evening Sections) Costs 350USD</p>	 		
	 	</div>
	 </div>
  	</div>
  </div> <br>
  
</body>
</html>