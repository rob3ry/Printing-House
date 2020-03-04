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
public class NoPaperException extends Exception{
    private int maxNumberOfPages;
    private String name;
    
    public NoPaperException(String name,int maxNumberOfPages){
        this.name = name;
        this.maxNumberOfPages = maxNumberOfPages;
    }

    public int getMaxNumberOfPages() {
        return maxNumberOfPages;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "NoPaperException{name=" + name + ", maxNumberOfPages=" + maxNumberOfPages + '}';
    }

   
    
}
