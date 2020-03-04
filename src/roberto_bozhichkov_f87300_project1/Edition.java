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
public abstract class Edition {
    
    protected String heading;
    protected int numOfPages;
    protected double addedBonus;
    protected PaperSize pSize;
    protected PaperType pType;
    
    public Edition(String heading,int numOfPages,PaperSize pSize){
        this.heading = heading;
        this.numOfPages = numOfPages;
        this.pSize = pSize;
    }

    public String getHeading() {
        return heading;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public double getAddedBonus() {
        return addedBonus;
    }
    
    public PaperSize getpSize() {
        return pSize;
    }

    public PaperType getpType() {
        return pType;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public void setAddedBonus(double addedBonus) {
        this.addedBonus = addedBonus;
    }
    
    public void setpSize(PaperSize pSize) {
        this.pSize = pSize;
    }
    
    public void setpType(PaperType pType) {
        this.pType = pType;
    }
    
    public double calcPrice(){
        return (this.numOfPages * (pSize.getPrice() + pType.getPrice() + addedBonus));
    }

    @Override
    public abstract String toString();
       
}
