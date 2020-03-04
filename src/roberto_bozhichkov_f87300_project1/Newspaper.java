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
public class Newspaper extends Edition{

    public Newspaper(String heading, int numOfPages, PaperSize size) {
        super(heading, numOfPages, size);
        pType = PaperType.NEWSPAPER;
        addedBonus = 8;
    }
    
    public String toString(){
        return "Newspaper{heading=" + heading + " ,numOfPages=" + numOfPages + " ,pSize=" + pSize + " ,pType=" + pType + '}';
    }
    
    
}
