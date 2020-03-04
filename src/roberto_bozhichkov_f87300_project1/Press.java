/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roberto_bozhichkov_f87300_project1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class Press {
    private String name;
    private PrintingHouse house;
    private int maxNumOfPages;
    protected int loadedPages;
    private int pagesPerMin;
    private List<Edition> editions;
    //private int numOfEditions;
    private PrinterMan printer;
    
    public Press(String name,int maxNumOfPages,int pagesPerMin){
        this.name = name;
        this.house = null;
        this.maxNumOfPages = maxNumOfPages;
        this.pagesPerMin = pagesPerMin;
        this.loadedPages = 0;
        this.editions = new ArrayList();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public PrintingHouse getHouse() {
        return house;
    }
    public void setHouse(PrintingHouse house) {
        this.house = house;
    }
    
    public List getEditions() {
        return editions;
    }
    public void setEditions(List<Edition> editions) {
        this.editions = editions;
    }
    public int getEditionsSize(){
        return this.editions.size();
    }
    
    public PrinterMan getPrinter() {
        return printer;
    }
    public void setPrinter(PrinterMan printer) {
        this.printer = printer;
    }
    
    public int getMaxNumOfPages() {
        return maxNumOfPages;
    }
    public void setMaxNumOfPages(int maxNumOfPages) {
        this.maxNumOfPages = maxNumOfPages;
    }
    
    public int getLoadedPages() {
        return loadedPages;
    }
    public void setLoadedPages(int loadedPages) {
        this.loadedPages = loadedPages;
    }

    public int getPagesPerMin() {
        return pagesPerMin;
    }
    public void setPagesPerMin(int pagesPerMin) {
        this.pagesPerMin = pagesPerMin;
    }

    public void addEdition(Edition ed){
        editions.add(ed);
    }
    
    public void showEditions(){
        for(Edition ed : editions){
            System.out.println(ed);
        }
    }
    
    public void loadPages(int number){
        if((this.loadedPages + number) > maxNumOfPages){
            System.out.println("Maximum number of pages reached!\n Will be refilled to the maximum only");
            this.loadedPages = maxNumOfPages;
        }
        else{
            this.loadedPages += number;
        }
    }
    public void printEdition() throws NoPaperException {
        for(Edition edit : editions){
            if(this.loadedPages < edit.getNumOfPages()){
                throw new NoPaperException(this.name,this.maxNumOfPages);
            }
            else{
                try{
                    //System.out.println("Printer: " + this.getPrinter() + " working on " + this.getName());
                    int pages = edit.getNumOfPages();
                    for(int i=1;i<=pages;i++){
                        System.out.println(this.getPrinter() + " working on " + this.getName() + " is printing page " + i + " of " + edit);
                        Thread.sleep(1000 * 60 / this.getPagesPerMin());
                    }
                    System.out.println(edit + " printed succesfully on " + this.name);
                    this.loadedPages -= edit.getNumOfPages();
                    System.out.println("Pages left on " + this.name + ": " + this.loadedPages);
                    //this.house.addPrintedEdition(edit);
                    //this.house.addToIncome(edit.calcPrice());
                    //if(house.getPrintedEditions().size() > house.getOverThisNumberPromo()){
                       // house.decrIncome();
                    //}
                    
                }
                catch(InterruptedException e){
                    System.out.println(e);
                }
            }
        }
    }
    

    //int getPagesPerMin() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    @Override
    public String toString() {
        return "Press{" + "name=" + name + " ,house=" + house.getName() + ", maxNumOfPages=" + maxNumOfPages + ", loadedPages=" + loadedPages + ", pagesPerMin=" + pagesPerMin + ", editions=" + editions + ", printer=" + printer + '}';
    }

    /*void setHouse(PrintingHouse aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}
