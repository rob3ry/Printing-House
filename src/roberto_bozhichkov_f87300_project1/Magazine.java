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
public class Magazine extends Edition{
    
    public Magazine(String heading, int numOfPages, PaperSize size) {
        super(heading, numOfPages, size);
        pType = PaperType.GLAZED;
        addedBonus = 10;
    }
    
    public String toString(){
        return "Magazine{heading=" + heading + " ,numOfPages=" + numOfPages + " ,pSize=" + pSize + " ,pType=" + pType + '}';
    }

}
