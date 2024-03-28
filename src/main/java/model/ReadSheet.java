package model;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadSheet {
	
	static XSSFRow row;
			//Reading Excel File
			public List<String> readCourses(HttpServletRequest request) throws IOException{
				
				    List<String> allCourses=new ArrayList<String>();
				    
				 // Get the ServletContext from the HttpServletRequest
			        ServletContext servletContext = request.getServletContext();

			        // Get the real path of the file within the web application context
			        String filePath = servletContext.getRealPath("/CourseList.xlsx");

				      FileInputStream fis = new FileInputStream(new File(filePath));
				      
				      //Prepare to read the excel data
				      XSSFWorkbook workbook = new XSSFWorkbook(fis);
				      
				      //Define Which Sheet of data you want to read
				      XSSFSheet spreadsheet = workbook.getSheetAt(0);
				      
				      //looping the row
				      Iterator < Row > rowIterator = spreadsheet.iterator();
				      
				      while (rowIterator.hasNext()) {
				    	 //check next row
				         row = (XSSFRow) rowIterator.next();
				         
				         //Loop the column (cell)
				         Iterator < Cell > cellIterator = row.cellIterator();
				         
				         //check next cell or not
				         while ( cellIterator.hasNext()) {
				            Cell cell = cellIterator.next();
				            
				            String celldata=cell.getStringCellValue();
				            
				            //put the data to the arraylist
				            allCourses.add(celldata);
				        				            
				            }//end cell loop				         
				         
				         }//end row loop
				      
				         System.out.println();
				      fis.close();
				 
					return allCourses;
			}
}
