/**
 * 
 */
package se.kth.iv1500.POS.controller;

import se.kth.iv1500.POS.model.*;
import se.kth.iv1500.POS.DTOs.*;
/**
<<<<<<< HEAD
 * @author Zeineb
=======
 * @author Sadeq
>>>>>>> master
 *
 * 
 */
public class Controller {
	    private Sale sale;
	    
	    public Controller() {
	    }
	    
	    public void startNewSale() {
	        this.sale = new Sale();
	    }
	    
	    /**
	     * adds an item to the current sale
	     * @param itemIdentifier   the identification of an item
	     * @param itemQuantitiy     the number of items 
	     * @return returns an object of type <code>SaleDTO</code>which contains information about the price of an item, VAT rate and running total 
	     */
	    public SaleDTO addItem(String itemIdentifier, int itemQuantity) {
	    	SaleDTO currentSale = null; 
	    	return currentSale;
	    }
}
