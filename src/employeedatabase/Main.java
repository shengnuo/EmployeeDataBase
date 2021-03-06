/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package employeedatabase;


import java.awt.Component;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Shengnuo
 */
public class Main extends javax.swing.JFrame {
    //Global
    DefaultListModel listModel=new DefaultListModel();
    HashSet<Integer> usedNumbers = new HashSet<>();      //records used numbers
    File database = new File("database.txt");
    public static HashTable<Integer, Employee> employee = new HashTable<>();           //records employees
    Random rand = new Random();
    
    
    /*
    Shengnuo Lin 00000001 123-456-7890 shengnuo.lin@email.com boss managing f
    0.9 999999
    
    David Yin 0000002 123-456-7890 david.yin@email.com janitor cleaning p
    0.9 15 40 51
    
    */
    public static void write(PrintWriter out, HashSet<Integer> usedNumbers, HashTable<Integer, Employee> employee) {
        for (int n : usedNumbers) {
            if (employee.contains(n)) {
                Employee e = employee.get(n);
                out.print(e.getFName()+" ");
                out.print(e.getLName()+" ");
                out.print(e.getEmpNum()+" ");
                out.print(e.getPhone()+" ");
                out.print(e.getEmail()+" ");
                out.print(e.getTitle()+" ");
                out.print(e.getDepartment()+" ");
                if (e instanceof FullTimeEmployee) {
                    FullTimeEmployee f = (FullTimeEmployee) e;
                    out.print("f");
                    out.println();
                    out.print(e.getDRate()+" ");
                    out.print(f.getSalary()+" ");
                }
                else if (e instanceof PartTimeEmployee) {
                    PartTimeEmployee p = (PartTimeEmployee) e;
                    out.print("p");
                    out.println();
                    out.print(e.getDRate()+" ");
                    out.print(p.getWage()+" ");
                    out.print(p.getHoursPerWeek()+" ");
                    out.print(p.getWeeksPerYear()+" ");
                }
                out.println();
                out.println();
            }
        }
    }
    /*
    Shengnuo Lin 00000001 123-456-7890 shengnuo.lin@email.com boss managing f
    0.9 999999
    
    David Yin 0000002 123-456-7890 david.yin@email.com janitor cleaning p
    0.9 15 40 51
    
    */
    public HashTable<Integer, Employee> read(Scanner in) {
        int empNo;
        String fName, lName, phone, email, title, department, type;
        double dRate;
        int i = 0;
        while(in.hasNext()) {
            fName=in.next();
            lName=in.next();
            empNo = in.nextInt();
            phone=in.next();
            email=in.next();
            title=in.next();
            department=in.next();
            type=in.next();
            dRate = in.nextDouble();

            usedNumbers.add(empNo);
            listModel.add(i++, empNo);

            if (type.equals("f")) {     //full time employee
                double salary = in.nextDouble();
                FullTimeEmployee fte = new FullTimeEmployee(fName, lName, empNo, phone, email, title, department, dRate, salary);
                employee.add(empNo,fte);
            }
            else if (type.equals("p")) {
                double wage = in.nextDouble();
                int hoursPerWeek=in.nextInt();
                int weeksPerYear=in.nextInt();
                PartTimeEmployee pte = new PartTimeEmployee(fName, lName, empNo, phone, email, title, department, dRate, wage, hoursPerWeek, weeksPerYear);
                employee.add(empNo,pte);
            }
        }
        employeeList.setModel(listModel);
        return employee;
    }
    
    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        empTypeGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        hoursPerWeekLabel1 = new javax.swing.JLabel();
        emailLabel1 = new javax.swing.JLabel();
        hoursPerWeekTField1 = new javax.swing.JTextField();
        salaryLabel1 = new javax.swing.JLabel();
        phoneLabel1 = new javax.swing.JLabel();
        salaryTField1 = new javax.swing.JTextField();
        emailTField1 = new javax.swing.JTextField();
        deductionRateLabel1 = new javax.swing.JLabel();
        lasNameLabel1 = new javax.swing.JLabel();
        phoneTField1 = new javax.swing.JTextField();
        weeksPerMonthLabel1 = new javax.swing.JLabel();
        firstNameTField1 = new javax.swing.JTextField();
        weeksPerYearTField1 = new javax.swing.JTextField();
        lastNameTField1 = new javax.swing.JTextField();
        dRateTField1 = new javax.swing.JTextField();
        empTypeLabel1 = new javax.swing.JLabel();
        titleLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        firstNameLabel1 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        titleTField1 = new javax.swing.JTextField();
        departmentTField1 = new javax.swing.JTextField();
        partTimeRadioButton1 = new javax.swing.JRadioButton();
        fullTimeRadioButton1 = new javax.swing.JRadioButton();
        saveButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeList = new javax.swing.JList();
        jToolBar1 = new javax.swing.JToolBar();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        searchTField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        NotFoundText = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                openDatabase(evt);
            }
        });

        hoursPerWeekLabel1.setText("Hours per week:");

        emailLabel1.setText("Email:");
        emailLabel1.setAlignmentY(5.0F);

        hoursPerWeekTField1.setEnabled(false);

        salaryLabel1.setText("Salary/wage:");

        phoneLabel1.setText("Phone Number:");
        phoneLabel1.setAlignmentY(5.0F);

        salaryTField1.setEnabled(false);
        salaryTField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryTField1ActionPerformed(evt);
            }
        });

        emailTField1.setAlignmentY(5.0F);
        emailTField1.setEnabled(false);
        emailTField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTField1ActionPerformed(evt);
            }
        });

        deductionRateLabel1.setText("Dedeuction rate:");

        lasNameLabel1.setText("Last Name:");
        lasNameLabel1.setAlignmentY(5.0F);

        phoneTField1.setAlignmentY(5.0F);
        phoneTField1.setEnabled(false);

        weeksPerMonthLabel1.setText("Weeks per year:");

        firstNameTField1.setAlignmentY(5.0F);
        firstNameTField1.setEnabled(false);
        firstNameTField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTField1ActionPerformed(evt);
            }
        });

        weeksPerYearTField1.setEnabled(false);

        lastNameTField1.setAlignmentY(5.0F);
        lastNameTField1.setEnabled(false);

        dRateTField1.setEnabled(false);

        empTypeLabel1.setText("Employee Type:");
        empTypeLabel1.setAlignmentY(5.0F);

        titleLabel1.setText("Title:");

        jLabel11.setText("Department:");

        firstNameLabel1.setText("First Name:");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        titleTField1.setEnabled(false);

        departmentTField1.setEnabled(false);
        departmentTField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentTField1ActionPerformed(evt);
            }
        });

        empTypeGroup1.add(partTimeRadioButton1);
        partTimeRadioButton1.setText("Part Time");
        partTimeRadioButton1.setEnabled(false);
        partTimeRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partTimeRadioButton1ActionPerformed(evt);
            }
        });

        empTypeGroup1.add(fullTimeRadioButton1);
        fullTimeRadioButton1.setText("Full Time");
        fullTimeRadioButton1.setEnabled(false);
        fullTimeRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullTimeRadioButton1ActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        employeeList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                switchEmployee(evt);
            }
        });
        jScrollPane1.setViewportView(employeeList);

        jToolBar1.setRollover(true);

        newButton.setText("New");
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(newButton);

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        searchTField.setToolTipText("Enter Employee #");
        searchTField.setEnabled(false);

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        NotFoundText.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(departmentTField1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(deductionRateLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dRateTField1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(salaryLabel1)
                                            .addComponent(hoursPerWeekLabel1)
                                            .addComponent(weeksPerMonthLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(salaryTField1)
                                            .addComponent(hoursPerWeekTField1)
                                            .addComponent(weeksPerYearTField1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(saveButton)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(empTypeLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fullTimeRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(partTimeRadioButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(titleLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titleTField1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lasNameLabel1)
                                            .addComponent(firstNameLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(firstNameTField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lastNameTField1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(phoneLabel1)
                                            .addComponent(emailLabel1))
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(emailTField1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(phoneTField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchTField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NotFoundText))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNameTField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lasNameLabel1)
                            .addComponent(lastNameTField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneLabel1)
                            .addComponent(phoneTField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel1)
                            .addComponent(emailTField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titleLabel1)
                            .addComponent(titleTField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(departmentTField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dRateTField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deductionRateLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(empTypeLabel1)
                            .addComponent(partTimeRadioButton1)
                            .addComponent(fullTimeRadioButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salaryLabel1)
                            .addComponent(salaryTField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hoursPerWeekLabel1)
                            .addComponent(hoursPerWeekTField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(weeksPerMonthLabel1)
                            .addComponent(weeksPerYearTField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NotFoundText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(saveButton)
                    .addComponent(deleteButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        Employee e = employee.get((Integer) employeeList.getSelectedValue());
        e.setFName(firstNameTField1.getText());
        e.setLName(lastNameTField1.getText());
        e.setPhone(phoneTField1.getText());
        e.setEmail(emailTField1.getText());
        e.setDRate(Double.parseDouble(dRateTField1.getText()));
        e.setDepartment(departmentTField1.getText());
        e.setTitle(titleTField1.getText());
        if (e instanceof PartTimeEmployee) {
            ((PartTimeEmployee) e).setWage(Double.parseDouble(salaryTField1.getText()));
            ((PartTimeEmployee) e).setHoursPerWeek(Integer.parseInt(hoursPerWeekTField1.getText()));
            ((PartTimeEmployee) e).setWeeksPerYear(Integer.parseInt(weeksPerYearTField1.getText()));
        }
        else {
            ((FullTimeEmployee) e).setSalary(Double.parseDouble(salaryTField1.getText()));
        }
        int temp = employeeList.getSelectedIndex();
        employeeList.clearSelection();
        employeeList.setSelectedIndex(temp);
        
        saveFile();
    }//GEN-LAST:event_saveButtonActionPerformed
    
    private void saveFile() {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(database));
            write(out, usedNumbers, employee);
        }
        catch (IOException e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,e);
        }
        finally{
            if (out!=null)
                out.close();
        }
    }
    
    private void fullTimeRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullTimeRadioButton1ActionPerformed
        hoursPerWeekTField1.setEnabled(false);
        weeksPerYearTField1.setEnabled(false);
        int empNo = (Integer) employeeList.getSelectedValue();
        employee.replace(empNo, new FullTimeEmployee(empNo));
    }//GEN-LAST:event_fullTimeRadioButton1ActionPerformed

    private void partTimeRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partTimeRadioButton1ActionPerformed
        // TODO add your handling code here:
        hoursPerWeekTField1.setEnabled(true);
        weeksPerYearTField1.setEnabled(true);
        int empNo = (Integer) employeeList.getSelectedValue();
        employee.replace(empNo, new PartTimeEmployee(empNo));
    }//GEN-LAST:event_partTimeRadioButton1ActionPerformed

    private void departmentTField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentTField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departmentTField1ActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        Employee e = employee.get((Integer) employeeList.getSelectedValue());
        e.setFName(firstNameTField1.getText());
        e.setLName(lastNameTField1.getText());
        e.setPhone(phoneTField1.getText());
        e.setEmail(emailTField1.getText());
        e.setTitle(titleTField1.getText());
        e.setDepartment(departmentTField1.getText());
        e.setDRate(Double.parseDouble(dRateTField1.getText()));
        if (e instanceof PartTimeEmployee) {
            ((PartTimeEmployee) e).setWage(Double.parseDouble(salaryTField1.getText()));
            ((PartTimeEmployee) e).setHoursPerWeek(Integer.parseInt(hoursPerWeekTField1.getText()));
            ((PartTimeEmployee) e).setWeeksPerYear(Integer.parseInt(weeksPerYearTField1.getText()));
        } else {
            ((FullTimeEmployee) e).setSalary(Double.parseDouble(salaryTField1.getText()));
        }
        //refresh the list
        int temp = employeeList.getSelectedIndex();
        employeeList.clearSelection();
        employeeList.setSelectedIndex(temp);
    }//GEN-LAST:event_addButtonActionPerformed

    private void firstNameTField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTField1ActionPerformed

    private void emailTField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTField1ActionPerformed

    private void salaryTField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryTField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryTField1ActionPerformed
    @SuppressWarnings("empty-statement")
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        // TODO add your handling code here:
        int empNo;

        while (usedNumbers.contains(empNo = rand.nextInt(99999)));
        usedNumbers.add(empNo);
        PartTimeEmployee emp = new PartTimeEmployee(empNo);
        employee.add(empNo, emp);
        listModel.add(usedNumbers.size()-1,empNo);
        employeeList.setSelectedIndex(usedNumbers.size()-1); //selected the added employee
    }//GEN-LAST:event_newButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        if(employeeList.getSelectedIndex()!=-1) {   //if something is selected
            usedNumbers.remove((Integer) employeeList.getSelectedValue());
            employee.remove((Integer) employeeList.getSelectedValue());
            listModel.removeElement(employeeList.getSelectedValue());
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void openDatabase(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_openDatabase
        if(!database.exists()) {
            try {
                database.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        
        Scanner fileIn = null;
        try {
            fileIn = new Scanner(database);
            employee = read(fileIn);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fileIn != null) {
                fileIn.close();
            }
        }
    }//GEN-LAST:event_openDatabase

    private void switchEmployee(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_switchEmployee
        // TODO add your handling code here:
        
        for (Component c : getContentPane().getComponents()) {
            if(c != employeeList)
                c.setEnabled(employeeList.getSelectedValue()!=null);
        } 
        if(employeeList.getSelectedValue()!= null){        //if an employee is selected
            fullTimeRadioButton1.setSelected(false);
            partTimeRadioButton1.setSelected(false);
            
            Employee e = employee.get((Integer) employeeList.getSelectedValue());
            firstNameTField1.setText(e.getFName());
            lastNameTField1.setText(e.getLName());
            phoneTField1.setText(e.getPhone());
            emailTField1.setText(e.getEmail());
            titleTField1.setText(e.getTitle());
            departmentTField1.setText(e.getDepartment());
            dRateTField1.setText(String.valueOf(e.getDRate()/100));
            if (e instanceof PartTimeEmployee) {
                fullTimeRadioButton1.setSelected(false);
                partTimeRadioButton1.setSelected(true);
                salaryTField1.setText(String.valueOf(((PartTimeEmployee) e).getWage()));
                hoursPerWeekTField1.setText(String.valueOf(((PartTimeEmployee) e).getHoursPerWeek()));
                weeksPerYearTField1.setText(String.valueOf(((PartTimeEmployee) e).getWeeksPerYear()));
            }
            else {
                fullTimeRadioButton1.setSelected(true);
                partTimeRadioButton1.setSelected(false);
                hoursPerWeekTField1.setEnabled(false);
                weeksPerYearTField1.setEnabled(false);
                salaryTField1.setText(String.valueOf(((FullTimeEmployee) e).getSalary()));
            }
        }
    }
    

    {
    }//GEN-LAST:event_switchEmployee

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        if(employee.contains(Integer.parseInt(searchTField.getText()))) {
            NotFoundText.setVisible(false);
            employeeList.setSelectedValue(Integer.parseInt(searchTField.getText()), rootPaneCheckingEnabled);
        }
        else {
            NotFoundText.setVisible(true);
            NotFoundText.setText("Employee Not Found!");
        }
    }//GEN-LAST:event_searchActionPerformed


    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NotFoundText;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField dRateTField1;
    private javax.swing.JLabel deductionRateLabel1;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField departmentTField1;
    private javax.swing.JLabel emailLabel1;
    private javax.swing.JTextField emailTField1;
    private javax.swing.ButtonGroup empTypeGroup1;
    private javax.swing.JLabel empTypeLabel1;
    private javax.swing.JList employeeList;
    private javax.swing.JLabel firstNameLabel1;
    private javax.swing.JTextField firstNameTField1;
    private javax.swing.JRadioButton fullTimeRadioButton1;
    private javax.swing.JLabel hoursPerWeekLabel1;
    private javax.swing.JTextField hoursPerWeekTField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lasNameLabel1;
    private javax.swing.JTextField lastNameTField1;
    private javax.swing.JButton newButton;
    private javax.swing.JRadioButton partTimeRadioButton1;
    private javax.swing.JLabel phoneLabel1;
    private javax.swing.JTextField phoneTField1;
    private javax.swing.JLabel salaryLabel1;
    private javax.swing.JTextField salaryTField1;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTField;
    private javax.swing.JLabel titleLabel1;
    private javax.swing.JTextField titleTField1;
    private javax.swing.JLabel weeksPerMonthLabel1;
    private javax.swing.JTextField weeksPerYearTField1;
    // End of variables declaration//GEN-END:variables
}