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
public class Book extends Edition {
    
    public Book(String heading, int numOfPages, PaperSize size) {
        super(heading, numOfPages, size);
        pType = PaperType.NORMAL;
        addedBonus = 12;
    }

    public String toString(){
        return "Book{heading=" + heading + " ,numOfPages=" + numOfPages + " ,pSize=" + pSize + " ,pType=" + pType + '}';
    }
    
    
   
}
