/**
 * 
 */
package Controller;

import model.Sale;
import model.*;
/**
 * @author Sadeq
 *
 */
public class Controller {
	    private Sale sale;
	    
	    public Controller() {
	     // kkkkkkkkkkkkkkkhhhhhhhhhhhhhhhhhhhhhhhh  
	    }
	    
	    public static void startNewSale() {
	        this.sale = new Sale();
	    }
	    public ItemInformation getItemInformation(String itemIdentifier, int itemQuantity) {
	    	ItemInformation iteminfo = new ItemInformation(itemIdentifier); 
	    	return iteminfo;
	    }
}
