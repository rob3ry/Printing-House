/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roberto_bozhichkov_f87300_project1;

/**
 *
 * @author Roberto
 */
public class PrinterMan extends Employee{
    
    public PrinterMan(String name, double sal){
        super(name,sal);
    }
    
    public double calcSalary(){
        return baseSalary;
    }

    @Override
    public String toString() {
        return "PrinterMan{name=" + name + " , baseSalary=" + baseSalary + '}';
    }
    
}
