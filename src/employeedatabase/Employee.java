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
public class Employee {
    protected String fName, lName, 
             phone, email, title, department;
    protected int empNo;
    protected double dRate;   //expressed as decimal
    
    Employee(String f, String l, int n, String p, String e, String t, String d, double rate){
        fName=f;
        lName=l;
        empNo=n;
        phone=p;
        email=e;
        department=d;
        title=t;
        
        dRate=rate;
    }
    
    Employee (int n) {
        empNo=n;
    }

    void setFName(String name) { fName=name; }
    String getFName() { return fName; }
    void setLName(String name) { lName=name; }
    String getLName() { return lName; }
    void setPhone(String p) { phone=p; }
    String getPhone() { return phone; }
    void setEmail(String mail) { email=mail; }
    String getEmail() { return email; }
    void setTitle(String t) { title=t; }
    String getTitle() { return title; }
    void setDepartment(String d) { department=d; }
    String getDepartment() { return department; }
    void setEmpNum(int num) { empNo=num; }
    int getEmpNum() { return empNo; }
    void setDRate(double rate) { dRate=rate; }
    double getDRate() { return dRate; }
}
