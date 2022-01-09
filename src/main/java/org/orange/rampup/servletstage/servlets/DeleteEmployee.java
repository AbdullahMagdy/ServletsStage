package org.orange.rampup.servletstage.servlets;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.orange.rampup.servletstage.employees.EmployeeDao;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteEmployee extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private EmployeeDao employeeDao = EmployeeDao.getInstance();

	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
		
	}
	
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		int result = 0;
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = employeeDao.deleteEmployee();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
            
            PrintWriter pw = response.getWriter();
    		pw.println("Succeefully employee deleted ");
            

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
