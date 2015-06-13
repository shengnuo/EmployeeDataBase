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
        dRate=0;
        empNo=n;
    }

    void setFName(String name) { fName=name.length()>0 ? name: "Enter First Name";}
    String getFName() { return fName; }
    void setLName(String name) { lName=name.length()>0 ? name : "Enter Last Name"; }
    String getLName() { return lName; }
    void setPhone(String p) { phone=p.length()>0 ? p : "Enter Phone Number"; }
    String getPhone() { return phone; }
    void setEmail(String mail) { email=mail.length()>0 ? mail : "Enter Email"; }
    String getEmail() { return email; }
    void setTitle(String t) { title=t.length()>0? t : "Enter Title"; }
    String getTitle() { return title; }
    void setDepartment(String d) { department=d.length()>0? d : "Enter Department"; }
    String getDepartment() { return department; }
    void setEmpNum(int num) { empNo=num; }
    int getEmpNum() { return empNo; }
    void setDRate(double rate) { dRate=rate; }
    double getDRate() { return dRate; }
}
