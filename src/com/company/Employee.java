package com.company;

import java.time.LocalDate;

public class Employee {

    public int EmployeeID;
    public int ProjectID;
    public String StartDate;
    public String EndDate;


    public String timenow2=LocalDate.now().toString();


    public static void main(String[] args) {

    }

    public Employee(int employeeID, int projectID, String startDate, String endDate) {
        EmployeeID = employeeID;
        ProjectID = projectID;
        StartDate = startDate;
        EndDate = endDate;

    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public int getProjectID() {
        return ProjectID;
    }

    public void setProjectID(int projectID) {
        ProjectID = projectID;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        if(EndDate.equalsIgnoreCase("NULL")){return timenow2;}
        else return EndDate ;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeID=" + this.EmployeeID +
                ", ProjectID=" + this.ProjectID +
                ", StartDate='" + this.StartDate + '\'' +
                ", EndDate='" + this.EndDate + '\'' +
                ", timenow2='" + this.timenow2 + '\'' +
                '}';
    }
}
