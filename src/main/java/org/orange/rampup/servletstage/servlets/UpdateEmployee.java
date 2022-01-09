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

public class UpdateEmployee extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private EmployeeDao employeeDao = EmployeeDao.getInstance();

	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
		PrintWriter pw = response.getWriter();
		pw.println("Succeefully employee updated");
	}
	
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		int result = 0;
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = employeeDao.updateEmployee();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			
			preparedStatement.setString(1, request.getParameter("allname"));
            preparedStatement.setString(2, request.getParameter("dateBirth"));
            preparedStatement.setString(3, request.getParameter("gender"));
            preparedStatement.setString(4, request.getParameter("gradDate"));
            preparedStatement.setString(5, request.getParameter("department"));
            preparedStatement.setString(6, request.getParameter("team"));
            preparedStatement.setString(7, request.getParameter("manager"));
            preparedStatement.setDouble(8, Double.parseDouble(request.getParameter("gross")));
            preparedStatement.setDouble(9, Double.parseDouble(request.getParameter("net")));
            preparedStatement.setString(10, request.getParameter("ismanager"));
            preparedStatement.setInt(11, id);
            result = preparedStatement.executeUpdate();
            
            PrintWriter pw = response.getWriter();
    		pw.println("Succeefully employee updated");
            

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
