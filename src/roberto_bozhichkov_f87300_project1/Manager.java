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
public class Manager extends Employee {

    private boolean haveBonus;
    
    public Manager(String name, double sal){
        super(name,sal);
        this.haveBonus = false;
    }
    
    /*public void setSalaryWithBonus(){
        this.baseSalary += (baseSalary * (bonusPercent / 100));
        this.haveBonus = true;
    }*/

    public boolean isHaveBonus() {
        return haveBonus;
    }
    public void setHaveBonus(boolean haveBonus) {
        this.haveBonus = haveBonus;
    }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
        this.haveBonus = true;
    }
    
    @Override
    public String toString() {
        return "Manager{name=" + name + " , baseSalary=" + baseSalary + '}';
    }
    
    

}
