package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import model.SelectedCourseDao;
import model.SendEmail;

public class RegisterSessionServlet extends HttpServlet {

	@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String register_name = req.getParameter("name");
		String register_email = req.getParameter("email");
		String register_address = req.getParameter("address");
		String register_course = req.getParameter("course");
	

		SelectedCourseDao courseReg = new SelectedCourseDao();

		// Call the Method to save the register course
		Course reg_course = courseReg.saveRegisterCourse(register_name, register_email,register_address,register_course	);

		
		// Send Email To User
		SendEmail mm=new SendEmail();
		String sub="Registration Information of Your Program";
				
		if(register_course.endsWith("(Morning)")){
			
			String message="Hello, "+register_name+".\n"+"Your Registration Is Successful. Thank you for registering to attend the course.\n\n"
					+"Registration Details \n"
					+"Your address : "+ register_address+"\n"
					+"Registered Course : "+ register_course+"\n"+
					"Price : 500 USD\n"+
					"Since you choose to attend morning session, your schedule is from 7:00AM to 10:00AM " +
					"in the morning.\n\n"
					+"Have a pleasant learning journey!";
			 mm.send("enteryouremail@gmail.com","swqp ugll ljcl oxmz",register_email,sub,message); 
		}
		else if(register_course.endsWith("(Afternoon)")){
			String message="Hello, "+register_name+".\n"+"Your Registration Is Successful. Thank you for registering to attend the course.\n\n"
					+"Registration Details \n"
					+"Your address : "+ register_address+"\n"
					+"Registered Course : "+ register_course+"\n"+
					"Price : 400 USD\n"+
					"Since you choose to attend afternoon session, your schedule is from 12:00PM to 2:30PM " +
					"in the afternoon.\n\n"
					+"Have a pleasant learning journey!";
			 mm.send("enteryouremail@gmail.com","swqp ugll ljcl oxmz",register_email,sub,message);
		}
		else{
			String message="Hello, "+register_name+".\n"+"Your Registration Is Successful. Thank you for registering to attend the course.\n\n"
					+"Registration Details \n"
					+"Your address : "+ register_address+"\n"
					+"Registered Course : "+ register_course+"\n"+
					"Price : 350 USD\n"+
					"Since you choose to attend evening session, your schedule is from 4:00PM to 6:00PM " +
					"in the evening.\n\n"
					+"Have a pleasant learning journey!";
			 mm.send("enteryouremail@gmail.com","swqp ugll ljcl oxmz",register_email,sub,message); 
		}
	
		req.setAttribute("register_course", reg_course);

		// Dispatch the JSP
		RequestDispatcher rd = req.getRequestDispatcher("thankyou.jsp");
		rd.forward(req, resp);
		
	}
}
