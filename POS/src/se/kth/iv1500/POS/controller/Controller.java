/**
 * 
 */
package se.kth.iv1500.POS.controller;

import se.kth.iv1500.POS.model.*;
/**
 * @author Sadeq
 *i add a commnet in controller class
 * jfjfjfjfjfjfjfjfjf
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
