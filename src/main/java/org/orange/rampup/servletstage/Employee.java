package org.orange.rampup.servletstage;


import java.time.format.DateTimeFormatter;

public class Employee {

    private String name;
    private String birthDay;
    private String gender;
    private String graduationDate;
    private String department;
    private String team;
    private String manager;
    private double grossSalary;
    private double netSalary;
    private String isManager;

    final double insuranceAmount = 500;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Employee(){

    }

    public Employee(String name, String birthDay, String gender, String gradDate,
                    String department, String team, String manager, double grossSalary , String isManager) {
        this.name = name ;
        this.birthDay = birthDay;
        this.gender = gender;
        this.graduationDate = gradDate;
        this.department = department;
        this.team = team;
        this.manager = manager;
        this.grossSalary = grossSalary;
        this.isManager = isManager;

        this.netSalary  = grossSalary - ( insuranceAmount + ( (15 * grossSalary) /100 ) );


    }
    
    public void setName(String firstName) {
        this.name = firstName;
    }
    
    public void setDateBirth(String dateBirth) {
        this.birthDay = dateBirth;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public void setGradDate(String gradDate) {
        this.graduationDate = gradDate;
    }
    
    public void setDepart(String depart) {
        this.department = depart;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    
    public void setManager(String manager) {
        this.manager = manager;
    }
    
    public void setGrossSalary(double gross) {
        this.grossSalary = gross;
    }
    
    public void setNetSalary() {
        this.netSalary = getGrossSalary() - ( insuranceAmount + ( (15 * getGrossSalary()) /100 ) );
    }
    
    public void setIsManager(String isManager) {
        this.isManager = isManager;
    }


    public String getName() {

        return name;
    }

    public String getBirthDay() {

        return birthDay;
    }

    public String getGender(){

        return gender;
    }

    public String getGraduationDate() {

        return graduationDate;
    }

    public String getDepartment(){

        return department;
    }

    public String getTeam(){

        return team;
    }

    public String getManager(){

        return manager;
    }

    public double getGrossSalary() {

        return grossSalary;
    }

    public double getNetSalary() {

        return netSalary;
    }

    public String getIsManager(){
        
        return isManager;
    }
    


}
