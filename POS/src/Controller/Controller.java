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
	        
	    }
	    
	    public void startNewSale() {
	        this.sale = new Sale();
	    }
	    public ItemInformation getItemInformation(String itemIdentifier, int itemQuantity) {
	    	ItemInformation iteminfo = new ItemInformation(itemIdentifier); 
	    	return iteminfo;
	    }
}
