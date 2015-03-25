/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package employeedatabase;

/**
 *
 * @author slin
 */
public class FullTimeEmployee extends Employee{
    double salary;  //gross salary
    
    FullTimeEmployee(String fName, String lName, int empNo, String phone, String email, String title, String department, double dRate, double s){
        super(fName, lName, empNo, phone, email, title, department, dRate);
        salary=s;
    }
    
    FullTimeEmployee (int empNo) {
        super(empNo);
    }
    
    double getSalary() { return salary; }
    void setSalary(double s) { salary=s; } 
    
    double getNetSalary() {
        return(salary*(1-dRate)/100);
    }
}