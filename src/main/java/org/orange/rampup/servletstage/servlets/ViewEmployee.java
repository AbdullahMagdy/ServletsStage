package org.orange.rampup.servletstage.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.orange.rampup.servletstage.employees.EmployeeDao;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewEmployee extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private EmployeeDao employeeDao = EmployeeDao.getInstance();

	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
		
		List<String> list = new ArrayList<String>();
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			list = employeeDao.viewEmployee(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		PrintWriter pw = response.getWriter();
		pw.println("Employee with id : " + list.get(0) + " and name : " + list.get(1) +
				" and dateBirth : " + list.get(2) + " and gender : " + list.get(3) + " and gradDate " + list.get(4) +
				" and department : " + list.get(5) + "and team : " + list.get(6) + "and manager : " + list.get(7)
				+ "and grossSalary : " + list.get(8) + "and netSalary : " + list.get(9)  + "and isManager : " + list.get(10));
	}
	
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException {
		
	}

}
