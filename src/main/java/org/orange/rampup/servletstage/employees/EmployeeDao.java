package org.orange.rampup.servletstage.employees;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDao {
	
	private static EmployeeDao employeeBehavioursInstance = null;

    public static EmployeeDao getInstance(){
        if(employeeBehavioursInstance == null){
            employeeBehavioursInstance = new EmployeeDao();
        }
        return employeeBehavioursInstance;
    }

    private EmployeeDao(){
    	

    }
	
	

    public int registerEmployee(Employee employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO employee" +
                "  (emp_name, date_birth, gender, graduation_date, department, team, manager, gross_salary,"
                + "net_salary, is_manager) VALUES " +
                " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        int result = 0;
        
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
        		
                .getConnection("jdbc:mysql://localhost:3306/initial_db", "root", "Ab1pass;");

             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthDay());
            preparedStatement.setString(3, employee.getGender());
            preparedStatement.setString(4, employee.getGraduationDate());
            preparedStatement.setString(5, employee.getDepartment());
            preparedStatement.setString(6, employee.getTeam());
            preparedStatement.setString(7, employee.getManager());
            preparedStatement.setDouble(8, employee.getGrossSalary());
            preparedStatement.setDouble(9, employee.getNetSalary());
            preparedStatement.setString(10, employee.getIsManager());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
    
    
    
    public List<String> viewEmployee(int id) throws ClassNotFoundException {
        String VIEW_USERS_SQL = "SELECT * from employee where idnew_table = ?";

        int result = 0;
        ResultSet rs = null;
        List<String> list = new ArrayList<String>();
        
        
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/initial_db", "root", "Ab1pass;");

            PreparedStatement preparedStatement = connection.prepareStatement(VIEW_USERS_SQL)) {
            preparedStatement.setInt(1, id);
            

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
            	
            	list.add(String.valueOf(rs.getInt(1)));
            	list.add(rs.getString(2));
            	list.add(rs.getString(3));
            	list.add(rs.getString(4));
            	list.add(rs.getString(5));
            	list.add(rs.getString(6));
            	list.add(rs.getString(7));
            	list.add(rs.getString(8));
            	list.add(rs.getString(9));
            	list.add(rs.getString(10));
            	list.add(rs.getString(11));
			    
			}
            

           
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        
        return list;
        
    }
    
    
    public PreparedStatement updateEmployee() throws ClassNotFoundException, SQLException {
        String UPDATE_USERS_SQL = "update employee set emp_name = ?, date_birth = ?, gender = ? ,"
        		+ "graduation_date = ? , department = ? , team = ? , manager = ?, gross_salary = ?,"
        		+ "net_salary = ? , is_manager = ? where idnew_table = ?";

        int result = 0;
        ResultSet rs = null;
        List<String> list = new ArrayList<String>();
        
        
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/initial_db", "root", "Ab1pass;");

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
        	
       
        return preparedStatement;
        
    }
    
    public PreparedStatement deleteEmployee() throws ClassNotFoundException, SQLException {
        String DELETE_USERS_SQL = "delete from employee where idnew_table = ?";

        int result = 0;
        ResultSet rs = null;
        List<String> list = new ArrayList<String>();
        
        
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/initial_db", "root", "Ab1pass;");

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
        	
       
        return preparedStatement;
        
    }
    
    

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}