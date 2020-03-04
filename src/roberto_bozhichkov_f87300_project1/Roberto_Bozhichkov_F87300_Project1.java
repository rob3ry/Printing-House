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
public class Roberto_Bozhichkov_F87300_Project1 {
    
    public static void main(String[] args) {
        
        Book b1 = new Book("Robin Hood",30,PaperSize.A2);
        Newspaper n1 = new Newspaper("New York Times" , 20, PaperSize.A5);
        Magazine m1 = new Magazine("Playboy",50,PaperSize.A4);
        Magazine m2 = new Magazine("COSMO",50,PaperSize.A4);
        Book b2 = new Book("The beauty and the beast",40,PaperSize.A2);
        Newspaper n2 = new Newspaper("The Times" , 28, PaperSize.A5);
        Book b3 = new Book("Winnie the Pooh",30,PaperSize.A2);
        Newspaper n3 = new Newspaper("Reuters" , 35, PaperSize.A5);
        
        //System.out.println(b1.calcPrice());
       // System.out.println(n1.calcPrice());
       // System.out.println(m1.calcPrice());
        //System.out.println(m2.calcPrice());
        
        ///base salary for all employees
        double baseSal = 500;
        
        Manager man1 = new Manager("Yordan",baseSal);
        Manager man2 = new Manager("Petar",baseSal);
        PrinterMan pm1 = new PrinterMan("Mitko",baseSal);
        PrinterMan pm2 = new PrinterMan("Ivan",baseSal);
        
        Press p1 = new Press("Brother",500,100);
        Press p2 = new Press("Philips",300,140);
        
        p1.loadPages(500);
        p2.loadPages(500);
       
        PrintingHouse ph = new PrintingHouse("Konica",1000,500,10,5,10);
        ph.setPress1(p1);
        ph.setPress2(p2);
        ph.addEmployee(pm2);
        ph.addEmployee(man1);
        ph.addEmployee(man2);
        ph.addEmployee(pm1);
        
        ph.buyPaper(400, PaperType.NORMAL, PaperSize.A3);
        
        ph.attachPrinter(pm1, p1);
        ph.attachPrinter(pm2, ph.getPress2());
        System.out.println(p1);
        System.out.println(p2);
        
        System.out.println("Employees: ");
        ph.showEmployees();
        
                
        ph.orderEdition(b1);
        ph.orderEdition(m1);
        ph.orderEdition(m2);
        ph.orderEdition(n1); 
        ph.orderEdition(n2); 
        ph.orderEdition(b2); 
        ph.orderEdition(n3); 
        ph.orderEdition(b3); 
        
        System.out.println("");
        ph.showEmployees();
        
        System.out.println("Income: " + ph.getIncome());
        //PrintingThread pt = new PrintingThread(p1);
        System.out.println("");
        System.out.println("Editions on press1: ");
        ph.showEditionsOnPress1();
        
        System.out.println("\nEditions on press2: ");
        ph.showEditionsOnPress2();
        System.out.println("\nPrintedEditions: ");
        ph.showPrintedEditions();
        System.out.println(ph.getEditionsNumber());
        System.out.println("");
        
        ph.renewBalance();
        System.out.println(ph.getBalance());
        ph.write("docs.txt");
        ph.read("docs.txt");
        System.out.println();
        ph.printAll();
        
        
    }
    
}
