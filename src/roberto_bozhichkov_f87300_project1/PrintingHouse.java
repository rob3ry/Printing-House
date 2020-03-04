/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roberto_bozhichkov_f87300_project1;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class PrintingHouse {
    private String name;
    private double balance;
    private double income;
    private double expenditure;
    private int paperInStock;
    private double managerBonus;
    private double profitForManagerBonus;
    private int overThisNumberPromo;
    private double salePercentForOneEdition;
    private int editionsNumber;
    
    private List<Employee> employees;
    private List<Edition> printedEditions;
    private List<Press> presses;
    
    private Press press1;
    private Press press2;

    public PrintingHouse(String name, double balance, double profitForManagerBonus, double managerBonus, int overThisNumberPromo, double salePercentForOneEdition) {
        this.name = name;
        this.balance = balance;
        this.expenditure = 0;
        this.income = 0;
        this.paperInStock = 0;
        this.editionsNumber = 0;
        this.profitForManagerBonus = profitForManagerBonus;
        this.managerBonus = managerBonus;
        this.overThisNumberPromo = overThisNumberPromo;
        this.salePercentForOneEdition = salePercentForOneEdition;
        
        presses = new ArrayList();
        employees = new ArrayList();
        printedEditions = new ArrayList();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPaperInStock() {
        return paperInStock;
    }
    public void setPaperInStock(int paperInStock) {
        this.paperInStock = paperInStock;
    }

    public double getExpenditure() {
        return expenditure;
    }
    
    
    public double getManagerBonus() {
        return managerBonus;
    }  
    public void setManagerBonus(double managerBonus) {
        this.managerBonus = managerBonus;
    }
    
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public double getIncome() {
        return income;
    }
    
    public double getProfitForManagerBonus() {
        return profitForManagerBonus;
    }
    public void setProfitForManagerBonus(double profitForManagerBonus) {
        this.profitForManagerBonus = profitForManagerBonus;
    }
    
    public int getOverThisNumberPromo() {
        return overThisNumberPromo;
    }
    public void setOverThisNumberPromo(int overThisNumberPromo) {
        this.overThisNumberPromo = overThisNumberPromo;
    }

    public double getSalePercentForOneEdition() {
        return salePercentForOneEdition;
    }
    public void setSalePercentForOneEdition(double salePercentForOneEdition) {
        this.salePercentForOneEdition = salePercentForOneEdition;
    }
    
    public int getEditionsNumber(){
        return editionsNumber;
    }
    
    public void renewBalance(){
        this.balance += (income - expenditure);
    }
    
    public void buyPaper(int numberOfPages, PaperType pt, PaperSize ps){
        double sum = numberOfPages * (pt.getPrice() + ps.getPrice());
        this.expenditure += sum;
    }
    
    public void setPress1(Press press){
        press1 = press;
        press1.setHouse(this);
        presses.add(press);
    }
    public void setPress2(Press press){
        press2 = press;
        press2.setHouse(this);
        presses.add(press);
    }
    
    public Press getPress1() {
        return press1;
    }
    public Press getPress2() {
        return press2;
    }
    
    public void orderEdition(Edition ed){
        editionsNumber++;
        this.income += ed.calcPrice();
        this.printedEditions.add(ed);
        if(press1.getEditionsSize() > press2.getEditionsSize()){
            press2.addEdition(ed);
        }
        else{
            press1.addEdition(ed);
        }
        if(this.income > this.profitForManagerBonus){
            for(Employee emp : employees){
                if(emp instanceof Manager && (((Manager)emp).isHaveBonus() == false)){
                    double exp = (emp.baseSalary * (this.managerBonus / 100));
                    emp.setBaseSalary(emp.baseSalary + exp);
                    //System.out.println("income: " + this.income);
                    //System.out.println("salary: " + emp.baseSalary);
                    
                    this.expenditure += exp;
                }
            }
        }
    }
    
    public void showEditionsOnPress1(){
        press1.showEditions();    
    }
    public void showEditionsOnPress2(){
        press2.showEditions();    
    }
    public void showPrintedEditions(){
        for(Edition ed : printedEditions){
            System.out.println(ed);
        }
    }
    public List<Edition> getPrintedEditions() {
        return printedEditions;
    }
    
    
    public void addEmployee(Employee emp){
        employees.add(emp);
        if(emp instanceof Manager && this.income >= this.profitForManagerBonus){
            emp.setBaseSalary(emp.baseSalary + (emp.baseSalary * (this.managerBonus / 100)));
            System.out.println(emp.baseSalary);
        }
        expenditure += emp.getBaseSalary();
    }

    public List<Employee> getEmployees() {
        return employees;
    }
    
    public void attachPrinter(PrinterMan pm,Press press){
        press.setPrinter(pm);
    }
    public void showEmployees(){
        for(Employee emp : employees){
            System.out.println(emp);
        }
    }
    public void write(String fileName){
        try(FileWriter fw = new FileWriter(fileName)){
            fw.write("Income=" + this.income + " ,expenditure=" + this.expenditure + " ,printedEditions=" + this.printedEditions + System.lineSeparator());
        }catch(IOException e){
            System.out.println(e);
        }
    }
    public void read(String fileName){
        try(FileReader fr = new FileReader(fileName)){
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public void printAll() {
        /*Thread t1 = new Thread(new PrintingThread(press1));
        Thread t2 = new Thread(new PrintingThread(press2));
        t1.start();
        t2.start();*/
        
        
        
        for (Press press : presses) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try{
                        press.printEdition();
                    } catch(NoPaperException e){
                        System.out.println(e);
                    }
                    
                }
            };

            Thread thread = new Thread(runnable);

            System.out.println("Starting Thread..." + press);
            thread.start();
        }
    }

    @Override
    public String toString() {
        return "PrintingHouse{name= " + name + "balance=" + balance + ", income=" + income + ", press1=" + press1 + ", press2=" + press2 + '}';
    }
    

    
}
