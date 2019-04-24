/**
 * 
 */
package Controller;

import model.Sale;
import model.*;
/**
 * @author Sadeq
 *this should be shown in git
 */
public class Controller {
	    private Sale sale;
	    
	    public Controller() {
	      kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk  
	    }
	    
	    public void startNewSale() {
	        this.sale = new Sale();
	    }
	    public ItemInformation getItemInformation(String itemIdentifier, int itemQuantity) {
	    	ItemInformation iteminfo = new ItemInformation(itemIdentifier); 
	    	return iteminfo;
	    }
}
