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
public class PartTimeEmployee extends Employee {
    private double wage;    
    private int hoursPerWeek, weeksPerYear;
 
    PartTimeEmployee(String fName, String lName, int empNo, String phone, String email, String title, String department, double dRate, double w, int hpw, int wpy) {
        super(fName, lName, empNo, phone, email, title, department, dRate);
        wage=w;
        hoursPerWeek=hpw;
        weeksPerYear=wpy;
    }
    
    PartTimeEmployee(int empNo) {
        super(empNo);
    }
    
    void setWage(double w) { wage=w; }
    double getWage() { return wage; }
    void setHoursPerWeek(int hpw) { hoursPerWeek=hpw; }
    int getHoursPerWeek() { return hoursPerWeek; }
    void setWeeksPerYear(int wpy) { weeksPerYear=wpy; }
    int getWeeksPerYear() {return weeksPerYear; }
    double getGrossPay() { return (wage*hoursPerWeek*weeksPerYear); }
    double getNetPay() { return ((1-dRate/100)*getGrossPay()); }
    
}
