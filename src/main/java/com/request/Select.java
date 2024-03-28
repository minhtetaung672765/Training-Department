package com.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/Select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request,response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  
		  
		  out.println("<html>");
		  out.println("<head>");
		  out.println("<meta charset='ISO-8859-1'>");
		  out.println("<title>Home</title>");
		  out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css'>");
		  out.println("<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css'>");
		  out.println("<script src='https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js'></script>");
		  out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
		  out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js'></script>");
		  out.println("</head>");

		  out.println("<body style='background-color:#ced9ee;'>");
		  out.println("<nav class='navbar navbar-expand-lg navbar-light sticky-top' style='background:navy;'>");
		  out.println("  <button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#collapsibleNavbar'>");
		  out.println("    <span class='navbar-toggler-icon'></span>");
		  out.println("  </button>");
		  out.println("  <div class='collapse navbar-collapse' id='collapsibleNavbar'>");
		  out.println("    <ul class='navbar-nav mr-auto mt-2 mt-sm-0'>");
		  out.println("      <li class='nav-item'>");
		  out.println("        <a class='nav-link active' href='index.html' style='color:white;'><span class='mylink currentPage'>Home</span></a>");
		  out.println("      </li>");
		  out.println("    </ul>");
		  out.println("  </div>");
		  out.println("</nav>");

		  out.println("<h2 style='text-align: center; font-size:21px; margin-top:50px;'>Registered Information of Users</h2>");
		  
		  out.println("<center>");
		  out.println("<br><br>");
		  try {
              //JDBC Connection
		     Class.forName("com.mysql.jdbc.Driver"); // registration mysql thin driver class
		     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training_department","root","93mysqlmain"); //getConnection
		        
		        String sql="select * from training_department.register;";
		        
		        PreparedStatement ps = con.prepareStatement(sql);
		        
               ResultSet rs =ps.executeQuery(); // for select the data from database..
			 
               out.println("<div class='container'>");
               out.println("<table class='table table-bordered table-striped'>");
               out.println("<thead class='thead-dark'>");
               out.println("<tr>");
               out.println("<th>Attendee ID</th>");
               out.println("<th>Attendee Name</th>");
               out.println("<th>Attendee Email</th>");
               out.println("<th>Address</th>");
               out.println("<th>Selected Course</th>");
               out.println("</tr>");
               out.println("</thead>");
               out.println("<tbody>");

               while (rs.next()) {
                   out.println("<tr>");
                   out.println("<td>" + rs.getInt(1) + "</td>");
                   out.println("<td>" + rs.getString(2) + "</td>");
                   out.println("<td>" + rs.getString(3) + "</td>");
                   out.println("<td>" + rs.getString(4) + "</td>");
                   out.println("<td>" + rs.getString(5) + "</td>");
                   out.println("</tr>");
               }

               out.println("</tbody>");
               out.println("</table>");
               out.println("</div>");
               out.println("<br><br>");

            con.close();                   
            
        }catch(ClassNotFoundException e){
            out.println("Error "+e);
            
        } catch (SQLException e) {
			 
			e.printStackTrace();
		}
		 out.println("</center>");
         out.println("</body>");
         out.println("</html>");     
 
	}

}
