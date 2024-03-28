package com.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html"); //set content type
	     // try-with-resource – automatically  close  object  
	        try (PrintWriter out = response.getWriter()) 
	       {
	             String mail=request.getParameter("adminEmail");  
	             String pass=request.getParameter("adminPass");  

                  if(pass.equals("admin") && mail.toLowerCase().equals("tsli-ls05752@learning.educlaas.com"))
	              {  
                     RequestDispatcher rd=(RequestDispatcher)request.getRequestDispatcher("Select");  
                     rd.forward(request, response);   //success page 
	              }  
			      else{  
//			        out.print("Sorry UserName or Password Error!");  
			    	  out.println("<!DOCTYPE html>");
			    	    out.println("<html>");
			    	    out.println("<head>");
			    	    out.println("<title>Login Error</title>");
			    	    out.println("</head>");
			    	    out.println("<body>");
			    	    out.println("<p style='text-align:center; margin-top:20px; color:red;'><i class='fas fa-exclamation-triangle' style='color:red;'></i> Username or Password Is Invalid!</p>");
			    	    out.println("</body>");
			    	    out.println("</html>");
			        RequestDispatcher rd=(RequestDispatcher) request.getRequestDispatcher("adminLogin.jsp");  
			        rd.include(request, response);   //failed page 
			                    
			        }   
	        }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
