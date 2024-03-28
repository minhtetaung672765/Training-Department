<jsp:useBean id="register_course" class="model.Course" scope="request"/>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ThankYou</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css" /> 
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<style type="text/css" >

body{background-color:#d2e8fc; }

.nav-item{color: white; padding: 0 10px 0 30px;}

.mylink{color: white; padding-bottom: 8px; }
.currentPage{font-weight: bold;} 

.mylink:hover{border-bottom: 2px solid white;}

h1{font-size: 25px; text-align: center; margin-top: 50px;}

.check-icon{padding: 5px; margin-left: 10px; background-color: green; color: white; border-radius: 50%;}

.btn{font-size: 16px; background-color: royalblue; color:white; margin: 10px 40px 0 0;}

table th{background-color: lightblue;}
table td{background-color: #d0e7ef;}

</style>

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
           	<a class="nav-link" href="training"><span class="mylink">Register courses</span></a>
        </li>
  	</ul>         
  </div>
 </nav> <br>
 
  <div class="container">
 	<h1 style="text-align: center"><span class="icon check-icon"><i class="fas fa-check"></i></span> Your Registration Is Successful.</h1><br>
	<div style="text-align: center">
		<p>Thank You For Registering Our Course.</p>
		<p>We have sent the details of the course to your email.</p>
	 </div><br>

	<table class="table" border="1" width="50%">
		<tr>
			<th>Attendee Name</th>
			<th>Course Name</th>
			<th>Email Address</th>
			<th>Attendee Address</th>
			<th>Price</th>
			
		</tr>
		<tr>
			<td><jsp:getProperty name="register_course" property="userName"/></td>
			<td><jsp:getProperty name="register_course" property="course"/></td>
			<td><jsp:getProperty name="register_course" property="email"/></td>
			<td><jsp:getProperty name="register_course" property="address"/></td>
			<td>
				<%
				String setPrice = request.getParameter("course");
				
				if( setPrice.endsWith("(Morning)")){
				%>
				500 USD
				<%
					
				}else if(setPrice.endsWith("(Afternoon)")){
				
				%>
				400 USD
				<%
				}else{
				%>
				350 USD
				<%
				}%>
			</td>
		</tr>		
		
	</table>
	</br>
	<div style="text-align: center; justify-contents: center;">
	<a href="index.html" class="btn btn-outline-dark btn-lg mybtn1" role="button" >Return To Home</a>
	<a href="training" class="btn btn-outline-dark btn-lg mybtn1" role="button" >Register Another Course</a><br><br>
	</div>
  </div>
</body>
</html>