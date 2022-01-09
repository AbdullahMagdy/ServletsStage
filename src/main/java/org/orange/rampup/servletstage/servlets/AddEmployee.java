package org.orange.rampup.servletstage.servlets;

import java.io.IOException;
import java.io.IOException;
import java.io.PrintWriter;

import org.orange.rampup.servletstage.employees.Employee;
import org.orange.rampup.servletstage.employees.EmployeeDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class AddEmployee extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao = EmployeeDao.getInstance();

    public AddEmployee(){
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
        resp.getWriter().append("Served at : ").append(req.getContextPath());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/index.jsp");
        dispatcher.forward(req,resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("allname");
        String dateBirth  = request.getParameter("dateBirth");
        String gender  = request.getParameter("gender");
        String gradDate  = request.getParameter("gradDate");
        String department 	 = request.getParameter("department");
        String team = request.getParameter("team");
        String manager = request.getParameter("manager");
        String gross = request.getParameter("gross");
        String isManager = request.getParameter("ismanager");
        

        Employee employee = new Employee();
        
        
        employee.setName(name);
        employee.setDateBirth(dateBirth);
        employee.setGender(gender);
        employee.setGradDate(gradDate);
        employee.setDepart(department);
        employee.setTeam(team);
        employee.setManager(manager);
        employee.setGrossSalary(Double.parseDouble(gross));
        employee.setNetSalary();
        employee.setIsManager(isManager);

        try {
            employeeDao.registerEmployee(employee);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        PrintWriter pw = response.getWriter();
		pw.println("Succeefully employee added");

        // response.sendRedirect("employeedetails.jsp");


    }
}