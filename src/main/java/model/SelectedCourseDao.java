package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectedCourseDao {

	public Course saveRegisterCourse(String register_name, String register_email ,String register_address,  String register_course) {
		
		Course reg_course=new Course();
		
		try {
			// step2: Register Driver
			Class.forName("com.mysql.jdbc.Driver");

			// Step 3: Create Connection
			String url = "jdbc:mysql://localhost/training_department";
			Connection con = DriverManager.getConnection(url, "root", "93mysqlmain");			

			// step4: Create a Statement
			Statement stmt = con.createStatement();

			// Insert to the database (Used executeUpdate for insert/delete and update)
			int result = stmt.executeUpdate(
					"INSERT INTO `training_department`.`register` (attendee_name,email,address,selected_course) values ('"
							+ register_name + "','" + register_email + "','" + register_address + "','" + register_course + "');");
			
				// Put the data to access from controller/JSP
				reg_course.setUserName(register_name);
				reg_course.setEmail(register_email);
				reg_course.setAddress(register_address);
				reg_course.setCourse(register_course);
				
			// step 7: Close the statement and connection
			stmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return reg_course;
	}
}
