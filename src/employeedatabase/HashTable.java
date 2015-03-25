/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package employeedatabase;

import java.util.ArrayList;

/**
 *
 * @author slin
 */
public class HashTable {
    private static final int BUCKET_SIZE = 6;
    private ArrayList<Employee>[] table = new ArrayList[BUCKET_SIZE];
    
    HashTable() {
        for (int i=0; i<BUCKET_SIZE; i++)
            table[i]=new ArrayList();
    }
    
    private int getIndex(int key) {
        return (key % table.length);
    }
    
    void add(Employee e) {
        table[getIndex(e.getEmpNum())].add(e);
    }
    
    void add(int key, Employee e) {
        table[getIndex(key)].add(e);
    }
    
    int search(int key) {
        for (int i=0; i<table[getIndex(key)].size();i++) {
            if (key==table[getIndex(key)].get(i).getEmpNum())
                return(i);
        }
        return -1;
    }
    
    Employee get (int key) {
        if (search(key)!=-1)
            return (table[getIndex(key)].get(search(key)));
        return null;
    }
    
    void remove(int key) {
        if(search(key)>0)
            table[getIndex(key)].remove(search(key));
    }
    
    void replace(int key, Employee newEmp) {
        try {
            table[getIndex(key)].set(search(key), newEmp);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(getIndex(key)+" "+search(key));
        }
    }   
}